package com.manage.service.Impl;

import com.google.common.collect.Lists;
import com.manage.common.ServerResponse;
import com.manage.dao.CartMapper;
import com.manage.dao.GoodsMapper;
import com.manage.dao.OrderMapper;
import com.manage.dao.UserMapper;
import com.manage.pojo.Cart;
import com.manage.pojo.Goods;
import com.manage.pojo.Order;
import com.manage.service.ICountService;
import com.manage.util.DateUtil;
import com.manage.vo.SumOrderMoneyVo;
import com.manage.vo.TotalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CountServiceImpl implements ICountService {


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private CartMapper cartMapper;

    //计算总数
    public ServerResponse getTotal() {
        //封装一个实体类，存放订单数，订单总额，注册总数，以及利润总数
        //将数据库统计好的订单总数和订单总额放入实体类
        TotalVo totalVo = orderMapper.getOrderCountTotalAndMoney();//获取到订单总数和订单总额
        if (totalVo != null) {
            //获取注册客户总人数
            int userTotal = userMapper.getUserCountTotal();//获取所有客户人数
            totalVo.setUserTotal(userTotal);
            //利润
            double profitTotal = 0.0;
            //获取订单
            List<Order> orderList = orderMapper.getTotalOrder();//所有订单
            if (orderList.size() > 0) {
                for (int i = 0; i < orderList.size(); i++) {
                    //遍历订单取出商品信息
                    String cardIdsString = orderList.get(i).getCartIds();
                    String[] cardIdsStringArray = cardIdsString.split(",");
                    List<Integer> cardIdsList = Lists.newArrayList();
                    for (String j : cardIdsStringArray) {
                        cardIdsList.add(Integer.parseInt(j));
                    }
                    List<Cart> cartList = cartMapper.getCartListByIds(cardIdsList);
                    for (int z = 0; z < cartList.size(); z++) {
                        Integer buyNum = cartList.get(z).getGoodsBuyNum();
                        Goods goods = goodsMapper.selectByPrimaryKey(cartList.get(z).getGoodsId());
                        //计算一件商品所获得的利润，然后进行累加
                        double profit = goods.getGoodsRelPrice() - goods.getGoodsCostPrice();//一件商品利润
                        profitTotal += buyNum * profit;
                    }
                }
                //将计算完的利润封装进实体类
                totalVo.setProfitTotal(profitTotal);
            } else {
                totalVo.setProfitTotal(profitTotal);
            }
            return ServerResponse.createBySuccess("总数统计完成", totalVo);
        } else {
            TotalVo totalVo1 = new TotalVo();
            totalVo1.setOrderCountTotal(0);
            totalVo1.setOrderMoneyTotal(0.0);
            int userTotal = userMapper.getUserCountTotal();//获取所有客户人数
            totalVo1.setUserTotal(userTotal);
            double profitTotal = 0.0;
            List<Order> orderList = orderMapper.getTotalOrder();//所有订单
            if (orderList.size() > 0) {
                for (int i = 0; i < orderList.size(); i++) {
                    String cardIdsString = orderList.get(i).getCartIds();
                    String[] cardIdsStringArray = cardIdsString.split(",");
                    List<Integer> cardIdsList = Lists.newArrayList();
                    for (String j : cardIdsStringArray) {
                        cardIdsList.add(Integer.parseInt(j));
                    }
                    List<Cart> cartList = cartMapper.getCartListByIds(cardIdsList);
                    for (int z = 0; z < cartList.size(); z++) {
                        Integer buyNum = cartList.get(z).getGoodsBuyNum();
                        Goods goods = goodsMapper.selectByPrimaryKey(cartList.get(z).getGoodsId());
                        double profit = goods.getGoodsRelPrice() - goods.getGoodsCostPrice();//一件商品利润
                        profitTotal += buyNum * profit;
                    }
                }
                totalVo1.setProfitTotal(profitTotal);
            } else {
                totalVo1.setProfitTotal(profitTotal);
            }
            return ServerResponse.createBySuccess("总数统计完成", totalVo1);
        }
    }

    //计算今日
    public ServerResponse getToday() {
        TotalVo totalVo = orderMapper.getTodayOrderCountAndMoney();//获取到今日订单总数和订单总额
        if (totalVo != null) {
            int userTotal = userMapper.getTodayUserCount();//获取今日注册客户人数
            totalVo.setUserTotal(userTotal);
            double profitTotal = 0.0;
            List<Order> orderList = orderMapper.getTodayOrder();//今日订单
            if (orderList.size() > 0) {
                for (int i = 0; i < orderList.size(); i++) {
                    String cardIdsString = orderList.get(i).getCartIds();
                    String[] cardIdsStringArray = cardIdsString.split(",");
                    List<Integer> cardIdsList = Lists.newArrayList();
                    for (String j : cardIdsStringArray) {
                        cardIdsList.add(Integer.parseInt(j));
                    }
                    List<Cart> cartList = cartMapper.getCartListByIds(cardIdsList);
                    for (int z = 0; z < cartList.size(); z++) {
                        Integer buyNum = cartList.get(z).getGoodsBuyNum();
                        Goods goods = goodsMapper.selectByPrimaryKey(cartList.get(z).getGoodsId());
                        double profit = goods.getGoodsRelPrice() - goods.getGoodsCostPrice();//一件商品利润
                        profitTotal += buyNum * profit;
                    }
                }
                totalVo.setProfitTotal(profitTotal);
            } else {
                totalVo.setProfitTotal(profitTotal);
            }
            return ServerResponse.createBySuccess("今日统计完成", totalVo);
        } else {
            TotalVo totalVo1 = new TotalVo();
            totalVo1.setOrderCountTotal(0);
            totalVo1.setOrderMoneyTotal(0.0);
            int userTotal = userMapper.getTodayUserCount();//获取今日所有客户人数
            totalVo1.setUserTotal(userTotal);
            double profitTotal = 0.0;
            List<Order> orderList = orderMapper.getTodayOrder();//今日订单
            if (orderList.size() > 0) {
                for (int i = 0; i < orderList.size(); i++) {
                    String cardIdsString = orderList.get(i).getCartIds();
                    String[] cardIdsStringArray = cardIdsString.split(",");
                    List<Integer> cardIdsList = Lists.newArrayList();
                    for (String j : cardIdsStringArray) {
                        cardIdsList.add(Integer.parseInt(j));
                    }
                    List<Cart> cartList = cartMapper.getCartListByIds(cardIdsList);
                    for (int z = 0; z < cartList.size(); z++) {
                        Integer buyNum = cartList.get(z).getGoodsBuyNum();
                        Goods goods = goodsMapper.selectByPrimaryKey(cartList.get(z).getGoodsId());
                        double profit = goods.getGoodsRelPrice() - goods.getGoodsCostPrice();//一件商品利润
                        profitTotal += buyNum * profit;
                    }
                }
                totalVo1.setProfitTotal(profitTotal);
            } else {
                totalVo1.setProfitTotal(profitTotal);
            }
            return ServerResponse.createBySuccess("今日统计完成", totalVo1);
        }
    }
    //计算昨日
    public ServerResponse getYestoday() {
        TotalVo totalVo = orderMapper.getYestodayOrderCountAndMoney();//获取到昨日订单总数和订单总额
        if (totalVo != null) {
            int userTotal = userMapper.getYestodayUserCount();//获取昨日注册客户人数
            totalVo.setUserTotal(userTotal);
            double profitTotal = 0.0;
            List<Order> orderList = orderMapper.getYesTodayOrder();//昨日订单
            if (orderList.size() > 0) {
                for (int i = 0; i < orderList.size(); i++) {
                    String cardIdsString = orderList.get(i).getCartIds();
                    String[] cardIdsStringArray = cardIdsString.split(",");
                    List<Integer> cardIdsList = Lists.newArrayList();
                    for (String j : cardIdsStringArray) {
                        cardIdsList.add(Integer.parseInt(j));
                    }
                    List<Cart> cartList = cartMapper.getCartListByIds(cardIdsList);
                    for (int z = 0; z < cartList.size(); z++) {
                        Integer buyNum = cartList.get(z).getGoodsBuyNum();
                        Goods goods = goodsMapper.selectByPrimaryKey(cartList.get(z).getGoodsId());
                        double profit = goods.getGoodsRelPrice() - goods.getGoodsCostPrice();//一件商品利润
                        profitTotal += buyNum * profit;
                    }
                }
                totalVo.setProfitTotal(profitTotal);
            } else {
                totalVo.setProfitTotal(profitTotal);
            }
            return ServerResponse.createBySuccess("昨日统计完成", totalVo);
        } else {
            TotalVo totalVo1 = new TotalVo();
            totalVo1.setOrderCountTotal(0);
            totalVo1.setOrderMoneyTotal(0.0);
            int userTotal = userMapper.getYestodayUserCount();//获取昨日注册客户人数
            totalVo1.setUserTotal(userTotal);
            double profitTotal = 0.0;
            List<Order> orderList = orderMapper.getYesTodayOrder();//昨日订单
            if (orderList.size() > 0) {
                for (int i = 0; i < orderList.size(); i++) {
                    String cardIdsString = orderList.get(i).getCartIds();
                    String[] cardIdsStringArray = cardIdsString.split(",");
                    List<Integer> cardIdsList = Lists.newArrayList();
                    for (String j : cardIdsStringArray) {
                        cardIdsList.add(Integer.parseInt(j));
                    }
                    List<Cart> cartList = cartMapper.getCartListByIds(cardIdsList);
                    for (int z = 0; z < cartList.size(); z++) {
                        Integer buyNum = cartList.get(z).getGoodsBuyNum();
                        Goods goods = goodsMapper.selectByPrimaryKey(cartList.get(z).getGoodsId());
                        double profit = goods.getGoodsRelPrice() - goods.getGoodsCostPrice();//一件商品利润
                        profitTotal += buyNum * profit;
                    }
                }
                totalVo1.setProfitTotal(profitTotal);
            } else {
                totalVo1.setProfitTotal(profitTotal);
            }
            return ServerResponse.createBySuccess("昨日统计完成", totalVo1);
        }
    }

    //计算本周
    public ServerResponse getWeek() {

        TotalVo totalVo = orderMapper.getWeekOrderCountAndMoney();//获取到本周订单总数和订单总额
        if (totalVo != null) {
            int userTotal = userMapper.getWeekUserCount();//获取本周注册客户人数
            totalVo.setUserTotal(userTotal);
            double profitTotal = 0.0;
            List<Order> orderList = orderMapper.getWeekOrder();//本周订单
            if (orderList.size() > 0) {
                for (int i = 0; i < orderList.size(); i++) {
                    String cardIdsString = orderList.get(i).getCartIds();
                    String[] cardIdsStringArray = cardIdsString.split(",");
                    List<Integer> cardIdsList = Lists.newArrayList();
                    for (String j : cardIdsStringArray) {
                        cardIdsList.add(Integer.parseInt(j));
                    }
                    List<Cart> cartList = cartMapper.getCartListByIds(cardIdsList);
                    for (int z = 0; z < cartList.size(); z++) {
                        Integer buyNum = cartList.get(z).getGoodsBuyNum();
                        Goods goods = goodsMapper.selectByPrimaryKey(cartList.get(z).getGoodsId());
                        double profit = goods.getGoodsRelPrice() - goods.getGoodsCostPrice();//一件商品利润
                        profitTotal += buyNum * profit;
                    }
                }
                totalVo.setProfitTotal(profitTotal);
            } else {
                totalVo.setProfitTotal(profitTotal);
            }
            return ServerResponse.createBySuccess("本周统计完成", totalVo);
        } else {
            TotalVo totalVo1 = new TotalVo();
            totalVo1.setOrderCountTotal(0);
            totalVo1.setOrderMoneyTotal(0.0);
            int userTotal = userMapper.getWeekUserCount();//获取本周注册客户人数
            totalVo1.setUserTotal(userTotal);
            double profitTotal = 0.0;
            List<Order> orderList = orderMapper.getWeekOrder();//本周订单
            if (orderList.size() > 0) {
                for (int i = 0; i < orderList.size(); i++) {
                    String cardIdsString = orderList.get(i).getCartIds();
                    String[] cardIdsStringArray = cardIdsString.split(",");
                    List<Integer> cardIdsList = Lists.newArrayList();
                    for (String j : cardIdsStringArray) {
                        cardIdsList.add(Integer.parseInt(j));
                    }
                    List<Cart> cartList = cartMapper.getCartListByIds(cardIdsList);
                    for (int z = 0; z < cartList.size(); z++) {
                        Integer buyNum = cartList.get(z).getGoodsBuyNum();
                        Goods goods = goodsMapper.selectByPrimaryKey(cartList.get(z).getGoodsId());
                        double profit = goods.getGoodsRelPrice() - goods.getGoodsCostPrice();//一件商品利润
                        profitTotal += buyNum * profit;
                    }
                }
                totalVo1.setProfitTotal(profitTotal);
            } else {
                totalVo1.setProfitTotal(profitTotal);
            }
            return ServerResponse.createBySuccess("本周统计完成", totalVo1);
        }
    }
    //计算本月
    public ServerResponse getMonth() {
        TotalVo totalVo = orderMapper.getMonthOrderCountAndMoney();//获取到本月订单总数和订单总额
        if (totalVo != null) {
            int userTotal = userMapper.getMonthUserCount();//获取本月注册客户人数
            totalVo.setUserTotal(userTotal);
            double profitTotal = 0.0;
            List<Order> orderList = orderMapper.getMonthOrder();//本月订单
            if (orderList.size() > 0) {
                for (int i = 0; i < orderList.size(); i++) {
                    String cardIdsString = orderList.get(i).getCartIds();
                    String[] cardIdsStringArray = cardIdsString.split(",");
                    List<Integer> cardIdsList = Lists.newArrayList();
                    for (String j : cardIdsStringArray) {
                        cardIdsList.add(Integer.parseInt(j));
                    }
                    List<Cart> cartList = cartMapper.getCartListByIds(cardIdsList);
                    for (int z = 0; z < cartList.size(); z++) {
                        Integer buyNum = cartList.get(z).getGoodsBuyNum();
                        Goods goods = goodsMapper.selectByPrimaryKey(cartList.get(z).getGoodsId());
                        double profit = goods.getGoodsRelPrice() - goods.getGoodsCostPrice();//一件商品利润
                        profitTotal += buyNum * profit;
                    }
                }
                totalVo.setProfitTotal(profitTotal);
            } else {
                totalVo.setProfitTotal(profitTotal);
            }
            return ServerResponse.createBySuccess("本周统计完成", totalVo);
        } else {
            TotalVo totalVo1 = new TotalVo();
            totalVo1.setOrderCountTotal(0);
            totalVo1.setOrderMoneyTotal(0.0);
            int userTotal = userMapper.getMonthUserCount();//获取本月注册客户人数
            totalVo1.setUserTotal(userTotal);
            double profitTotal = 0.0;
            List<Order> orderList = orderMapper.getMonthOrder();//本月订单
            if (orderList.size() > 0) {
                for (int i = 0; i < orderList.size(); i++) {
                    String cardIdsString = orderList.get(i).getCartIds();
                    String[] cardIdsStringArray = cardIdsString.split(",");
                    List<Integer> cardIdsList = Lists.newArrayList();
                    for (String j : cardIdsStringArray) {
                        cardIdsList.add(Integer.parseInt(j));
                    }
                    List<Cart> cartList = cartMapper.getCartListByIds(cardIdsList);
                    for (int z = 0; z < cartList.size(); z++) {
                        Integer buyNum = cartList.get(z).getGoodsBuyNum();
                        Goods goods = goodsMapper.selectByPrimaryKey(cartList.get(z).getGoodsId());
                        double profit = goods.getGoodsRelPrice() - goods.getGoodsCostPrice();//一件商品利润
                        profitTotal += buyNum * profit;
                    }
                }
                totalVo1.setProfitTotal(profitTotal);
            } else {
                totalVo1.setProfitTotal(profitTotal);
            }
            return ServerResponse.createBySuccess("本周统计完成", totalVo1);
        }

    }
    //统计当月每日的订单数和订单金额
    public ServerResponse<List<SumOrderMoneyVo>> getMonthOrderNumAndMoney() {

        Integer monthSize = DateUtil.getMonthSize();
        List<String> xAxisNameList = Lists.newArrayList();
        for (int i = 1; i <= monthSize; i++) {
            xAxisNameList.add(i + "号数据");
        }
        int count = 0;//定义一个是否list加入对象的标识
        List<SumOrderMoneyVo> sumOrderMoneyVoList = orderMapper.getMonthOrderNumAndMoney();
        List<SumOrderMoneyVo> sumOrderMoneyVoList1 = Lists.newArrayList();
        for (int i = 0; i < xAxisNameList.size(); i++) {
            String Time = DateUtil.dateToString(DateUtil.getDateAfter(DateUtil.stringToDate(DateUtil.getFirstDayOfMonth(),"yyyy-MM-dd"), i), "yyyy-MM-dd");
            count = 0;
            for (SumOrderMoneyVo sumOrderMoneyVo : sumOrderMoneyVoList) {
                if (Time.equals((DateUtil.dateToString(sumOrderMoneyVo.getOrderdateTime(), "yyyy-MM-dd")))) {
                    sumOrderMoneyVo.setXaxisName(xAxisNameList.get(i));
                    sumOrderMoneyVoList1.add(sumOrderMoneyVo);
                    count++;
                }
            }
            if (count == 0) {
                SumOrderMoneyVo sumOrderMoneyVo1 = new SumOrderMoneyVo();
                sumOrderMoneyVo1.setOrderdateTime(DateUtil.getDateBefore(new Date(), i));
                sumOrderMoneyVo1.setTransactionMoney(0.00);
                sumOrderMoneyVo1.setXaxisName(xAxisNameList.get(i));
                sumOrderMoneyVo1.setCountOrder(0);
                sumOrderMoneyVoList1.add(sumOrderMoneyVo1);
            }
        }
        return ServerResponse.createBySuccess("找到当前月的每日订单和金额！", sumOrderMoneyVoList1);
    }
    //以当前日期为准向后统计后五天的销售总额
    public ServerResponse<List<SumOrderMoneyVo>> getFiveDaysOrderMoney() {

        int count = 0;//定义一个是否list加入对象的标识
        List<SumOrderMoneyVo> sumOrderMoneyVoList = orderMapper.getFiveDaysOrderMoney();
        List<SumOrderMoneyVo> sumOrderMoneyVoList1 = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            String Time = DateUtil.dateToString(DateUtil.getDateBefore(new Date(), i), "yyyy-MM-dd");
            count = 0;
            for (SumOrderMoneyVo sumOrderMoneyVo : sumOrderMoneyVoList) {
                if (Time.equals((DateUtil.dateToString(sumOrderMoneyVo.getOrderdateTime(), "yyyy-MM-dd")))) {
                    sumOrderMoneyVoList1.add(sumOrderMoneyVo);
                    count++;
                }
            }
            if (count == 0) {
                SumOrderMoneyVo sumOrderMoneyVo1 = new SumOrderMoneyVo();
                sumOrderMoneyVo1.setOrderdateTime(DateUtil.getDateBefore(new Date(), i));
                sumOrderMoneyVo1.setTransactionMoney(0.00);
                sumOrderMoneyVoList1.add(sumOrderMoneyVo1);
            }
        }
        return ServerResponse.createBySuccess("找到这几日的订单金额数", sumOrderMoneyVoList1);
    }

}
