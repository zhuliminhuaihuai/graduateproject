package com.managesystem.dao;

import com.managesystem.pojo.Order;
import com.managesystem.vo.OrderVo;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //充值订单列表
    List<Order> fingRechargeOrderList(OrderVo orderVo);

    //报修订单列表
    List<Order> fingRepairOrderList(OrderVo orderVo);
}