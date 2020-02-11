package com.manage.dao;

import com.manage.pojo.Order;
import com.manage.vo.OrderVo;
import com.manage.vo.SumOrderMoneyVo;
import com.manage.vo.TotalVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //后台查询全部订单根据角色
    List<Order> findAllOrder(OrderVo orderVo);

    //后台查询全部未发货订单根据角色
    List<Order> findOrderByRoleAndUnshippend(OrderVo orderVo);

    //后台查询全部已发货订单根据角色
    List<Order> findOrderByRoleAndShippend(OrderVo orderVo);

    //后台查询配送完成订单根据角色
    List<Order> findOrderByRoleAndDelivery(OrderVo orderVo);

    //后台查询退货订单根据角色
    List<Order> findOrderByRoleAndReturn(OrderVo orderVo);

    //批量删除订单
    int someDeleteOrder(@Param("idList") List<Integer> idList);

    //发货
    int sendOrder(@Param("orderId") Integer orderId);

    //退货
    int rebackOrder(@Param("orderId") Integer orderId);

    //确认收货
    int confirmOrder(@Param("orderId") Integer orderId);

    //根据orderCode查找订单
    Order getOrderByOrderCode(@Param("orderCode") String orderCode);

    //计算订单总数以及订单总金额
    TotalVo getOrderCountTotalAndMoney();

    List<Order> getTotalOrder();

    //计算今日订单总数以及订单今额
    TotalVo getTodayOrderCountAndMoney();

    //获取今日所有订单
    List<Order> getTodayOrder();

    //计算昨日订单总数以及订单金额
    TotalVo getYestodayOrderCountAndMoney();

    //获取昨日所有订单
    List<Order> getYesTodayOrder();

    //计算本周订单总数以及订单金额
    TotalVo getWeekOrderCountAndMoney();

    //获取本周所有订单
    List<Order> getWeekOrder();

    //计算 本月订单总数以及订单金额
    TotalVo getMonthOrderCountAndMoney();

    //获取本月所有订单
    List<Order> getMonthOrder();

    //统计当月每日的订单数和订单金额
    List<SumOrderMoneyVo> getMonthOrderNumAndMoney();

    //以当前日期为准向后统计后五天的销售总额
    List<SumOrderMoneyVo> getFiveDaysOrderMoney();






}