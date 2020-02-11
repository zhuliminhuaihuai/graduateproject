package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Order;
import com.project.vo.ClassRoomQueryVo;
import com.project.vo.OrderQueryVo;

import javax.servlet.http.HttpServletRequest;

public interface IOrderService {

    //获取租借教室列表
    LayUiPageResponse getBorrowRoomList(Integer page, Integer limit, ClassRoomQueryVo classRoomQueryVo);

    //学生借用教室
    ServerResponse addBorrowOrder(HttpServletRequest request, Order order, String orderAppointmentTime1);

    //教室审核
    LayUiPageResponse getBorrowOrderList(Integer page, Integer limit, OrderQueryVo orderQueryVo);

    //历史记录
    LayUiPageResponse getOrederHistory(Integer page, Integer limit, OrderQueryVo orderQueryVo);

    //借用订单详情
    ServerResponse getOrderDetail(Integer orderId);

    //审核通过
    ServerResponse passOrder(Integer orderId, HttpServletRequest request);

    //审核不通过
    ServerResponse noPassOrder(Integer orderId, HttpServletRequest request, String orderResult);

    //撤回申请
    ServerResponse withdrawOrder(Integer orderId);

    //删除申请
    ServerResponse deleteOrder(Integer orderId);
}
