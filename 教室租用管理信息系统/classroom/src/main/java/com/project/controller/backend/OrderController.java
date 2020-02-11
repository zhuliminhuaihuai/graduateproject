package com.project.controller.backend;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Order;
import com.project.service.IOrderService;
import com.project.vo.ClassRoomQueryVo;
import com.project.vo.OrderQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/manage/order/")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    //获取租借教室列表
    @RequestMapping("getBorrowRoomList")
    @ResponseBody
    public LayUiPageResponse getBorrowRoomList(Integer page, Integer limit, ClassRoomQueryVo classRoomQueryVo) {
        return iOrderService.getBorrowRoomList(page, limit, classRoomQueryVo);
    }

    //学生借用教室
    @RequestMapping("addBorrowOrder")
    @ResponseBody
    public ServerResponse addBorrowOrder(HttpServletRequest request, Order order, String orderAppointmentTime1) {
        return iOrderService.addBorrowOrder(request, order, orderAppointmentTime1);
    }

    //教室审核
    @RequestMapping("getBorrowOrderList")
    @ResponseBody
    public LayUiPageResponse getBorrowOrderList(Integer page, Integer limit, OrderQueryVo orderQueryVo) {
        return iOrderService.getBorrowOrderList(page, limit, orderQueryVo);
    }

    //历史记录
    @RequestMapping("getOrederHistory")
    @ResponseBody
    public  LayUiPageResponse getOrederHistory(Integer page, Integer limit, OrderQueryVo orderQueryVo) {
        return iOrderService.getOrederHistory(page, limit, orderQueryVo);
    }
    //借用订单详情
    @RequestMapping("getOrderDetail")
    @ResponseBody
    public ServerResponse getOrderDetail(Integer orderId) {
        return iOrderService.getOrderDetail(orderId);
    }

    //审核通过
    @RequestMapping("passOrder")
    @ResponseBody
    public ServerResponse passOrder(Integer orderId, HttpServletRequest request) {
        return iOrderService.passOrder(orderId, request);
    }
    //审核不通过
    @RequestMapping("noPassOrder")
    @ResponseBody
    public ServerResponse noPassOrder(Integer orderId, HttpServletRequest request,String orderResult) {
        return iOrderService.noPassOrder(orderId, request,orderResult);
    }

    //撤回申请
    @RequestMapping("withdrawOrder")
    @ResponseBody
    public ServerResponse withdrawOrder(Integer orderId) {
        return iOrderService.withdrawOrder(orderId);
    }

    //删除申请
    @RequestMapping("deleteOrder")
    @ResponseBody
    public ServerResponse deleteOrder(Integer orderId) {
        return iOrderService.deleteOrder(orderId);
    }
    /****************************************/
    //跳转租借教室界面
    @RequestMapping("jumpRoomBorrowList.html")
    public String jumpRoomBorrowListHtml() {
        return "order/room_borrow_list";
    }

    //打开租借教室详情界面
    @RequestMapping("openBorrowRoomDetail.html")
    public String openBorrowRoomDetailHtml() {
        return "order/borrow_room_detail";
    }

    //打开借用申请教室界面
    @RequestMapping("openBorrowOrderAdd.html")
    public String openBorrowOrderAddHtml() {
        return "order/borrow_order_add";
    }

    //跳转教室审核界面
    @RequestMapping("jumpExamineOrderList.html")
    public String jumpExamineOrderListHtml() {
        return "order/examine_order_list";
    }

    //打开申请请求订单的详情界面
    @RequestMapping("openBorrowOrderDetail.html")
    public String openBorrowOrderDetailHtml() {
        return "order/borrow_order_detail";
    }

    //打开结果反馈界面
    @RequestMapping("openOrderNoPass.html")
    public String openOrderNoPassHtml() {
        return "order/order_noPass";
    }

    //跳转历史记录
    @RequestMapping("jumpOrderHistory.html")
    public String jumpOrderHistoryHtml() {
        return "order/order_histroy";
    }
}
