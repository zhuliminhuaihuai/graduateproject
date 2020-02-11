package com.manage.controller.backend;

import com.alipay.api.AlipayApiException;
import com.manage.common.Const;
import com.manage.common.LayUiPageResponse;
import com.manage.common.LayUiResponse;
import com.manage.common.ServerResponse;
import com.manage.pojo.Order;
import com.manage.pojo.User;
import com.manage.service.IOrderService;
import com.manage.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/manage/order/")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    //前端客户下单
    @RequestMapping("portalAddOrder")
    @ResponseBody
    public ServerResponse portalAddOrder(Order order) {
        return iOrderService.portalAddOrder(order);
    }

    //后台查询全部订单根据角色
    @RequestMapping("findOrderByRole")
    @ResponseBody
    public LayUiPageResponse findOrderByRole(HttpServletRequest request, Integer page, Integer limit, OrderVo orderVo) {

        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        Integer userRole = user.getUserRole();
        return iOrderService.findOrderByRole(request, userRole, page, limit, orderVo);

    }

    //支付宝电脑端支付
    @RequestMapping("aliPay")
    @ResponseBody
    public ServerResponse payCheck( Order order,HttpServletResponse response, HttpServletRequest request) throws IOException, AlipayApiException {
         return  iOrderService.payCheck(order,response,request);
    }

    //支付宝同步通知结果
    @RequestMapping(value = "payReturn")
    public String payReturn(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, AlipayApiException {

        ServerResponse serverResponse = iOrderService.payReturn(request, response);
        if (serverResponse.getMsg() == "下单成功") {
            return "user/user_shop_cart";
        } else {
            return "user/user_shop";
        }
//        ModelAndView view = new ModelAndView();
//        view = shopService.payReturn(request, response);
//        return view;
    }

    //后台查询全部未发货订单根据角色
    @RequestMapping("findOrderByRoleAndUnshippend")
    @ResponseBody
    public LayUiPageResponse findOrderByRoleAndUnshippend(HttpServletRequest request, Integer page, Integer limit, OrderVo orderVo) {

        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        Integer userRole = user.getUserRole();
        return iOrderService.findOrderByRoleAndUnshippend(request, userRole, page, limit, orderVo);

    }

    //后台查询全部已发货订单根据角色
    @RequestMapping("findOrderByRoleAndShippend")
    @ResponseBody
    public LayUiPageResponse findOrderByRoleAndShippend(HttpServletRequest request, Integer page, Integer limit, OrderVo orderVo) {

        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        Integer userRole = user.getUserRole();
        return iOrderService.findOrderByRoleAndShippend(request, userRole, page, limit, orderVo);

    }

    //后台查询配送完成订单根据角色
    @RequestMapping("findOrderByRoleAndDelivery")
    @ResponseBody
    public LayUiPageResponse findOrderByRoleAndDelivery(HttpServletRequest request, Integer page, Integer limit, OrderVo orderVo) {

        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        Integer userRole = user.getUserRole();
        return iOrderService.findOrderByRoleAndDelivery(request, userRole, page, limit, orderVo);

    }

    //后台查询退货订单根据角色
    @RequestMapping("findOrderByRoleAndReturn")
    @ResponseBody
    public LayUiPageResponse findOrderByRoleAndReturn(HttpServletRequest request, Integer page, Integer limit, OrderVo orderVo) {

        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        Integer userRole = user.getUserRole();
        return iOrderService.findOrderByRoleAndReturn(request, userRole, page, limit, orderVo);

    }

    //删除订单
    @RequestMapping("deleteOrder")
    @ResponseBody
    public ServerResponse deleteOrder(Integer orderId) {
        return iOrderService.deleteOrder(orderId);
    }

    //批量删除订单
    @RequestMapping("someDeleteOrder")
    @ResponseBody
    public ServerResponse someDeleteOrder(String ids) {
        return iOrderService.someDeleteOrder(ids);
    }

    //修改订单前的详请
    @RequestMapping("modifyOrder")
    @ResponseBody
    public ServerResponse modifyOrder(Integer orderId) {
        return iOrderService.modifyOrder(orderId);
    }

    //保存订单
    @RequestMapping("saveOrder")
    @ResponseBody
    public ServerResponse saveOrder(Order order) {
        return iOrderService.saveOrder(order);
    }

    //发货订单
    @RequestMapping("sendOrder")
    @ResponseBody
    public ServerResponse sendOrder(Integer orderId) {
        return iOrderService.sendOrder(orderId);
    }

    //退货订单
    @RequestMapping("rebackOrder")
    @ResponseBody
    public ServerResponse rebackOrder(Integer orderId) {
        return iOrderService.rebackOrder(orderId);
    }

    //确认收货订单
    @RequestMapping("confirmOrder")
    @ResponseBody
    public ServerResponse confirmOrder(Integer orderId) {

        return iOrderService.confirmOrder(orderId);
    }
    //订单详情
    @RequestMapping("detailOrder")
    @ResponseBody
    public LayUiPageResponse detailOrder(Integer orderId, Integer page, Integer limit) {
        return iOrderService.detailOrder(orderId, page, limit);
    }

    /****************************************************************/
    //跳转订单列表
    @RequestMapping("jumpOrderList.html")
    public String jumpOrderListHtml() {
        return "order/order_list_role1";
    }

    //跳转订单修改页面
    @RequestMapping("jumpOrderModify.html")
    public String jumpOrderModifyHtml() {
        return "order/order_modify";
    }

    //跳转订单详情页面
    @RequestMapping("jumpOrderDetail.html")
    public String jumpOrderDetailHtml() {
        return "order/order_detail";
    }

    //跳转未发货订单页面
    @RequestMapping("jumpOrderListUnshipped.html")
    public String jumpOrderListUnshippedHtml() {
        return "order/order_list_unshipped";
    }

    //跳转已发货订单页面
    @RequestMapping("jumpOrderListShipped.html")
    public String jumpOrderListShippedHtml() {
        return "order/order_list_shipped";
    }

    //跳转配送完成订单页面
    @RequestMapping("jumpOrderListDelivery.html")
    public String jumpOrderListDeliveryHtml() {
        return "order/order_list_delivery";
    }

    //跳转退货订单页面
    @RequestMapping("jumpOrderListReturn.html")
    public String jumpOrderListReturnHtml() {
        return "order/order_list_return";
    }
}
