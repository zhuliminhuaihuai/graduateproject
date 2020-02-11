package com.manage.service.Impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.common.Const;
import com.manage.common.LayUiPageResponse;
import com.manage.common.LayUiResponse;
import com.manage.common.ServerResponse;
import com.manage.dao.CartMapper;
import com.manage.dao.GoodsMapper;
import com.manage.dao.OrderMapper;
import com.manage.dao.UserMapper;
import com.manage.pojo.Cart;
import com.manage.pojo.Goods;
import com.manage.pojo.Order;
import com.manage.pojo.User;
import com.manage.service.IOrderService;
import com.manage.util.AlipayConfig;
import com.manage.util.PublicUtil;
import com.manage.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Service
public class OrderServiceImpl implements IOrderService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    //前端客户下单



    public ServerResponse portalAddOrder(Order order) {

        String userCode = order.getUserCode();
        User user = userMapper.findUserByUserCode(userCode);
        order.setUserName(user.getUserName());
        order.setUserPhone(user.getUserPhone());
        String orderCode = PublicUtil.setCode("O");
        order.setOrderCode(orderCode);
        order.setOrderCreateTime(new Date());
        int count = orderMapper.insertSelective(order);
        if (count > 0) {
            String cartIdsString = order.getCartIds();
            String[] ids= cartIdsString.split(",");
            List<Integer> idList =new ArrayList();
            for(String s : ids){
                Integer i = Integer.parseInt(s);
                //商品表的商品购买数量加+1
                Cart cart = cartMapper.selectByPrimaryKey(i);
                Integer number = cart.getGoodsBuyNum();
                Goods goods = goodsMapper.selectByPrimaryKey(cart.getGoodsId());
                goods.setGoodsBuyNum(goods.getGoodsBuyNum() + 1);
                goods.setGoodsInventory(goods.getGoodsInventory() - number);
                goodsMapper.updateByPrimaryKeySelective(goods);
                idList.add(i);
            }
            int updateCount = cartMapper.updateCartSettlementType(idList);
            if (updateCount > 0) {
                return ServerResponse.createBySuccessMessage("下单成功");
            } else {
                return ServerResponse.createByErrorMessage("更新购物车失败");
            }
        } else {
            return ServerResponse.createByErrorMessage("下单失败");
        }
    }
    //后台查询全部订单根据角色
    public LayUiPageResponse findOrderByRole(HttpServletRequest request,Integer userRole, Integer page, Integer limit ,OrderVo orderVo) {

        if (userRole == 1) {
            PageHelper.startPage(page, limit);
            List<Order> orderList = orderMapper.findAllOrder(orderVo);
            if (orderList.size() > 0) {
                PageInfo pageInfo = new PageInfo(orderList);
                return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
            } else {
                return LayUiPageResponse.createByErrorMessage("暂无数据");
            }
        } else if (userRole == 2) {
            User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
            orderVo.setUserCode(user.getUserCode());
            PageHelper.startPage(page, limit);
            List<Order> orderList = orderMapper.findAllOrder(orderVo);
            if (orderList.size() > 0) {
                PageInfo pageInfo = new PageInfo(orderList);
                return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
            } else {
                return LayUiPageResponse.createByErrorMessage("暂无数据");
            }
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
    }

    //支付宝电脑端支付
    public ServerResponse payCheck(Order order,HttpServletResponse response, HttpServletRequest request) throws IOException, AlipayApiException {

        System.out.println("asdknkasf");
        //设置编码
        response.setContentType("text/html;charset=utf-8");
        //活动初始的AliPayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        aliPayRequest.setReturnUrl(AlipayConfig.return_url);
        aliPayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //获取订单
        String userCode = order.getUserCode();
        User user = userMapper.findUserByUserCode(userCode);
        order.setUserName(user.getUserName());
        order.setUserPhone(user.getUserPhone());
        String orderCode = PublicUtil.setCode("O");
        order.setOrderCode(orderCode);
//        OrderDto order = orderJpa.getOrder(orderId);
        //商户订单号，后台可以写一个工具类生成一个订单号，必填
        aliPayRequest.setBizContent("{\"out_trade_no\":\"" + orderCode + "\","
                + "\"total_amount\":\"" + order.getOrderMoney() + "\","
                + "\"subject\":\"" + "水果批发商城批发水果" + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}"
        );
        String form = alipayClient.pageExecute(aliPayRequest).getBody();
        order.setOrderCreateTime(new Date());
        orderMapper.insertSelective(order);
        return ServerResponse.createBySuccessMessage(form);
//        System.out.println("form:" + form);
//        out.write(form);
//        out.flush();
//        out.close();
    }
    //支付宝同步通知结果
    public ServerResponse payReturn(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, AlipayApiException {
        ModelAndView view = new ModelAndView();
      //获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            System.out.println("valueStr:" + valueStr);
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
//验证成功
        if (signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
            //业务操作
            Order order = orderMapper.getOrderByOrderCode(out_trade_no);
            String cartIdsString = order.getCartIds();
            String[] ids= cartIdsString.split(",");
            List<Integer> idList =new ArrayList();
            for(String s : ids){
                Integer i = Integer.parseInt(s);
                //商品表的商品购买数量加+1
                Cart cart = cartMapper.selectByPrimaryKey(i);
                Goods goods = goodsMapper.selectByPrimaryKey(cart.getGoodsId());
                goods.setGoodsBuyNum(goods.getGoodsBuyNum() + 1);
                goodsMapper.updateByPrimaryKeySelective(goods);
                idList.add(i);
            }
            int updateCount = cartMapper.updateCartSettlementType(idList);
            if (updateCount > 0) {
                return ServerResponse.createBySuccessMessage("下单成功");
            } else {
                return ServerResponse.createByErrorMessage("更新购物车失败");
            }


        }
        return ServerResponse.createByErrorMessage("验签失败");


        //——请在这里编写您的程序（以上代码仅作参考）——
    }
    //后台查询全部未发货订单根据角色
    public LayUiPageResponse findOrderByRoleAndUnshippend(HttpServletRequest request,Integer userRole, Integer page, Integer limit, OrderVo orderVo) {

        if (userRole == 1) {
            PageHelper.startPage(page, limit);
            List<Order> orderList = orderMapper.findOrderByRoleAndUnshippend(orderVo);
            if (orderList.size() > 0) {
                PageInfo pageInfo = new PageInfo(orderList);
                return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
            } else {
                return LayUiPageResponse.createByErrorMessage("暂无数据");
            }
        } else if (userRole == 2) {
            User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
            orderVo.setUserCode(user.getUserCode());
            PageHelper.startPage(page, limit);
            List<Order> orderList = orderMapper.findOrderByRoleAndUnshippend(orderVo);
            if (orderList.size() > 0) {
                PageInfo pageInfo = new PageInfo(orderList);
                return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
            } else {
                return LayUiPageResponse.createByErrorMessage("暂无数据");
            }
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }

    }
    //后台查询全部已发货订单根据角色
    public LayUiPageResponse findOrderByRoleAndShippend(HttpServletRequest request,Integer userRole, Integer page, Integer limit, OrderVo orderVo) {

        if (userRole == 1) {
            PageHelper.startPage(page, limit);
            List<Order> orderList = orderMapper.findOrderByRoleAndShippend(orderVo);
            if (orderList.size() > 0) {
                PageInfo pageInfo = new PageInfo(orderList);
                return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
            } else {
                return LayUiPageResponse.createByErrorMessage("暂无数据");
            }
        } else if (userRole == 2) {
            User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
            orderVo.setUserCode(user.getUserCode());
            PageHelper.startPage(page, limit);
            List<Order> orderList = orderMapper.findOrderByRoleAndShippend(orderVo);
            if (orderList.size() > 0) {
                PageInfo pageInfo = new PageInfo(orderList);
                return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
            } else {
                return LayUiPageResponse.createByErrorMessage("暂无数据");
            }
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }

    }
    //后台查询配送完成订单根据角色
    public LayUiPageResponse findOrderByRoleAndDelivery(HttpServletRequest request,Integer userRole, Integer page, Integer limit, OrderVo orderVo) {

        if (userRole == 1) {
            PageHelper.startPage(page, limit);
            List<Order> orderList = orderMapper.findOrderByRoleAndDelivery(orderVo);
            if (orderList.size() > 0) {
                PageInfo pageInfo = new PageInfo(orderList);
                return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
            } else {
                return LayUiPageResponse.createByErrorMessage("暂无数据");
            }
        } else if (userRole == 2) {
            User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
            orderVo.setUserCode(user.getUserCode());
            PageHelper.startPage(page, limit);
            List<Order> orderList = orderMapper.findOrderByRoleAndDelivery(orderVo);
            if (orderList.size() > 0) {
                PageInfo pageInfo = new PageInfo(orderList);
                return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
            } else {
                return LayUiPageResponse.createByErrorMessage("暂无数据");
            }
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }

    }
    //后台查询退货订单根据角色
    public LayUiPageResponse findOrderByRoleAndReturn(HttpServletRequest request,Integer userRole, Integer page, Integer limit, OrderVo orderVo) {

        if (userRole == 1) {
            PageHelper.startPage(page, limit);
            List<Order> orderList = orderMapper.findOrderByRoleAndReturn(orderVo);
            if (orderList.size() > 0) {
                PageInfo pageInfo = new PageInfo(orderList);
                return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
            } else {
                return LayUiPageResponse.createByErrorMessage("暂无数据");
            }
        } else if (userRole == 2) {
            User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
            orderVo.setUserCode(user.getUserCode());
            PageHelper.startPage(page, limit);
            List<Order> orderList = orderMapper.findOrderByRoleAndReturn(orderVo);
            if (orderList.size() > 0) {
                PageInfo pageInfo = new PageInfo(orderList);
                return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
            } else {
                return LayUiPageResponse.createByErrorMessage("暂无数据");
            }
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }

    }

    //删除订单
    public ServerResponse deleteOrder(Integer orderId) {

        int count = orderMapper.deleteByPrimaryKey(orderId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }

    }
    //批量删除订单
    public ServerResponse someDeleteOrder(String ids) {

        int i = ids.indexOf("[");
        int j = ids.indexOf("]");
        String s1 = ids.substring(i + 1, j);
        String[] idsArray= s1.split(",");
        List<Integer> idList =new ArrayList();
        for(String s : idsArray){
            Integer k = Integer.parseInt(s);
            idList.add(k);
        }
        int count = orderMapper.someDeleteOrder(idList);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }

    //修改订单前的详请
    public ServerResponse modifyOrder(Integer orderId) {

        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order != null) {
            return ServerResponse.createBySuccess("找到该订单", order);
        } else {
            return ServerResponse.createByErrorMessage("未找到该订单");
        }
    }
    //保存订单
    public ServerResponse saveOrder(Order order) {

        order.setOrderUpdateTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("保存成功");
        } else {
            return ServerResponse.createByErrorMessage("保存失败");

        }
    }
    //发货订单
    public ServerResponse sendOrder(Integer orderId) {

        int count = orderMapper.sendOrder(orderId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("发货成功");
        } else {
            return ServerResponse.createByErrorMessage("发货失败");
        }

    }
    //退货订单
    public ServerResponse rebackOrder(Integer orderId) {
        int count = orderMapper.rebackOrder(orderId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("退货成功");
        } else {
            return ServerResponse.createByErrorMessage("退货失败");
        }
    }
    //确认收货订单
    public ServerResponse confirmOrder(Integer orderId) {
        int count = orderMapper.confirmOrder(orderId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("确认成功");
        } else {
            return ServerResponse.createByErrorMessage("确认失败");
        }
    }

    //订单详情
    public LayUiPageResponse detailOrder(Integer orderId, Integer page,Integer limit) {

        Order order = orderMapper.selectByPrimaryKey(orderId);
        String cartIds = order.getCartIds();
        String[] idsArray= cartIds.split(",");
        List<Integer> idList =new ArrayList();
        for(String s : idsArray){
            Integer k = Integer.parseInt(s);
            idList.add(k);
        }
        PageHelper.startPage(page, limit);
        List<Cart> cartList = cartMapper.getCartListByIds(idList);
        String photoPath = "http://127.0.0.1:8080/upload/";
        for (int i = 0; i < cartList.size(); i++) {
            cartList.get(i).setGoodsImg(photoPath + cartList.get(i).getGoodsImg());
        }
        PageInfo pageInfo = new PageInfo(cartList);
        return LayUiPageResponse.createBySuccess(cartList, pageInfo.getTotal(), page, limit);

    }
}
