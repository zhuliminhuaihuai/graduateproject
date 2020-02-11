package com.managesystem.service;

import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.Order;

public interface IOrderService {


    //客户下单 预约婚纱
    ServerResponse addOrder(String photographerCode, String orderRemark, String userCode, Integer photoId);

    //客户待拍摄订单
    LayUiPageResponse pendingOrderList(Order order, String startTime, String endTime, Integer page, Integer limit);

    //客户拍摄中订单
    LayUiPageResponse shootingOrderList(Order order, String startTime, String endTime, Integer page, Integer limit);

    //客户已拍摄订单
    LayUiPageResponse alreadyOrderList(Order order, String startTime, String endTime, Integer page, Integer limit);

    //摄影师待摄影订单
    LayUiPageResponse photographerPendingOrderList(Order order, String startTime, String endTime, Integer page, Integer limit);

    //摄影师拍摄中订单
    LayUiPageResponse photographerShootingOrderList(Order order, String startTime, String endTime, Integer page, Integer limit);

    //摄影师已摄影订单
    LayUiPageResponse photographerAlreadyOrderList(Order order, String startTime, String endTime, Integer page, Integer limit);

    //客户撤回婚纱拍摄
    ServerResponse withdrawWedOrder(Integer orderId);

    //摄影师接单
    ServerResponse receiptWedOrder(Integer orderId,String orderPhotographerCode);

    //摄影师提交完成订单
    ServerResponse completeWedOrder(Integer orderId);

    //客户确认完成订单
    ServerResponse confimWedOrder(Integer orderId);


    //客户修改前的详情页面
    ServerResponse withdrawDetailWedOrder(Integer orderId);

    //客户修改婚纱预约单
    ServerResponse modifyWedOrder(Order order);


}
