package com.manage.service;

import com.alipay.api.AlipayApiException;
import com.manage.common.LayUiPageResponse;
import com.manage.common.LayUiResponse;
import com.manage.common.ServerResponse;
import com.manage.pojo.Order;
import com.manage.vo.OrderVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface IOrderService {

    //前端客户下单
    ServerResponse portalAddOrder(Order order);

    //支付宝电脑端支付
    ServerResponse payCheck(Order order, HttpServletResponse response, HttpServletRequest request) throws IOException, AlipayApiException;

    //支付宝同步通知结果
    ServerResponse payReturn(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, AlipayApiException;

    //后台查询全部订单根据角色
    LayUiPageResponse findOrderByRole(HttpServletRequest request,Integer userRole, Integer page, Integer limit, OrderVo orderVo);

    //后台查询全部未发货订单根据角色
    LayUiPageResponse findOrderByRoleAndUnshippend(HttpServletRequest request, Integer userRole, Integer page, Integer limit, OrderVo orderVo);

    //后台查询全部已发货订单根据角色
    LayUiPageResponse findOrderByRoleAndShippend(HttpServletRequest request,Integer userRole, Integer page, Integer limit, OrderVo orderVo);

    //后台查询配送完成订单根据角色
    LayUiPageResponse findOrderByRoleAndDelivery(HttpServletRequest request, Integer userRole, Integer page, Integer limit, OrderVo orderVo);

    //后台查询退货订单根据角色
    LayUiPageResponse findOrderByRoleAndReturn(HttpServletRequest request, Integer userRole, Integer page, Integer limit, OrderVo orderVo);


    //删除订单
    ServerResponse deleteOrder(Integer orderId);

    //批量删除订单
    ServerResponse someDeleteOrder(String ids);

    //修改订单前的详请
    ServerResponse modifyOrder(Integer orderId);

    //保存订单
    ServerResponse saveOrder(Order order);

    //发货订单
    ServerResponse sendOrder(Integer orderId);

    //订单详情
    LayUiPageResponse detailOrder(Integer orderId, Integer page, Integer limit);

    //退货订单
    ServerResponse rebackOrder(Integer orderId);

    //确认收货订单
    ServerResponse confirmOrder(Integer orderId);



}
