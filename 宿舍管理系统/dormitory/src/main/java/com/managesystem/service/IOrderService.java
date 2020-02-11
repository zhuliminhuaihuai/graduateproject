package com.managesystem.service;

import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.Order;
import com.managesystem.vo.OrderVo;

import javax.servlet.http.HttpServletRequest;

public interface IOrderService {

    //添加充值订单
    ServerResponse addRechargeOrder(HttpServletRequest request, Order order);

    //添加报修订单
    ServerResponse addRepairOrder(HttpServletRequest request, Order order);

    //充值订单列表
    LayUiPageResponse rechargeOrderList(OrderVo orderVo, Integer userRole, Integer page, Integer limit);

    //报修订单列表
    LayUiPageResponse repairOrderList(OrderVo orderVo, Integer userRole, Integer page, Integer limit);

    //充值成功受理
    ServerResponse shenheRechargeOrder(Integer orderId);

    //报修受理成功受理
    ServerResponse shenheRepairOrder(Integer orderId);
}
