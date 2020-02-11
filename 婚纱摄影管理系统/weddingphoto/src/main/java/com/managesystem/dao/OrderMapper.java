package com.managesystem.dao;

import com.managesystem.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //客户待拍摄订单
    List<Order> pendingOrderList(@Param("order") Order order, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //客户拍摄中订单
    List<Order> shootingingOrderList(@Param("order") Order order, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //客户已拍摄订单
    List<Order> alreadyingOrderList(@Param("order") Order order, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //摄影师待摄影订单
    List<Order> photographerPendingOrderList(@Param("order") Order order, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //摄影师拍摄中订单
    List<Order> photographerShootingOrderList(@Param("order") Order order, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //摄影师已摄影订单
    List<Order> photographerAlreadyOrderList(@Param("order") Order order, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //客户撤回婚纱拍摄
    Order withdrawWedOrder(@Param("orderId") Integer orderId);


}