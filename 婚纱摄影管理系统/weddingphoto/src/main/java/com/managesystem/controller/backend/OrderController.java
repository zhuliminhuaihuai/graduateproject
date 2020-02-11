package com.managesystem.controller.backend;


import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.Order;
import com.managesystem.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manage/order/")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    //客户下单 预约婚纱
    @RequestMapping("addOrder")
    @ResponseBody
    public ServerResponse addOrder(String photographerCode, String orderRemark, String userCode, Integer photoId) {

        return iOrderService.addOrder(photographerCode, orderRemark, userCode, photoId);

    }

    //客户待拍摄订单
    @RequestMapping("pendingOrderList")
    @ResponseBody
    public LayUiPageResponse pendingOrderList(Order order, String startTime, String endTime, Integer page, Integer limit) {

        return iOrderService.pendingOrderList(order, startTime, endTime, page, limit);
    }

    //客户拍摄中订单
    @RequestMapping("shootingOrderList")
    @ResponseBody
    public LayUiPageResponse shootingOrderList(Order order, String startTime, String endTime, Integer page, Integer limit) {
        return iOrderService.shootingOrderList(order, startTime, endTime, page, limit);
    }

    //客户已拍摄订单
    @RequestMapping("alreadyOrderList")
    @ResponseBody
    public LayUiPageResponse alreadyOrderList(Order order, String startTime, String endTime, Integer page, Integer limit) {
        return iOrderService.alreadyOrderList(order, startTime, endTime, page, limit);
    }

    //摄影师待摄影订单
    @RequestMapping("photographerPendingOrderList")
    @ResponseBody
    public LayUiPageResponse photographerPendingOrderList(Order order, String startTime, String endTime, Integer page, Integer limit) {
        return iOrderService.photographerPendingOrderList(order, startTime, endTime, page, limit);
    }

    //摄影师摄影中订单
    @RequestMapping("photographerShootingOrderList")
    @ResponseBody
    public LayUiPageResponse photographerShootingOrderList(Order order, String startTime, String endTime, Integer page, Integer limit) {
        return iOrderService.photographerShootingOrderList(order, startTime, endTime, page, limit);
    }

    //摄影师已摄影订单
    @RequestMapping("photographerAlreadyOrderList")
    @ResponseBody
    public LayUiPageResponse photographerAlreadyOrderList(Order order, String startTime, String endTime, Integer page, Integer limit) {
        return iOrderService.photographerAlreadyOrderList(order, startTime, endTime, page, limit);
    }
    //客户撤回婚纱拍摄
    @RequestMapping("withdrawWedOrder")
    @ResponseBody
    public ServerResponse withdrawWedOrder(Integer orderId) {

        return iOrderService.withdrawWedOrder(orderId);
    }
    //客户修改前的详情页面
    @RequestMapping("withdrawDetailWedOrder")
    @ResponseBody
    public ServerResponse withdrawDetailWedOrder(Integer orderId) {
        return iOrderService.withdrawDetailWedOrder(orderId);
    }
    //客户修改婚纱预约单
    @RequestMapping("modifyWedOrder")
    @ResponseBody
    public ServerResponse modifyWedOrder(Order order) {
        return iOrderService.modifyWedOrder(order);
    }

    //摄影师接单
    @RequestMapping("receiptWedOrder")
    @ResponseBody
    public ServerResponse receiptWedOrder(Integer orderId,String orderPhotographerCode) {
        return iOrderService.receiptWedOrder(orderId,orderPhotographerCode);
    }

    //摄影师提交完成订单
    @RequestMapping("completeWedOrder")
    @ResponseBody
    public ServerResponse completeWedOrder(Integer orderId) {
        return iOrderService.completeWedOrder(orderId);
    }

    //客户确认完成订单
    @RequestMapping("confimWedOrder")
    @ResponseBody
    public ServerResponse confimWedOrder(Integer orderId) {
        return iOrderService.confimWedOrder(orderId);
    }
    /*********************************************************************/
    //跳转客户待拍摄页面
    @RequestMapping("jumpOrderCustomerWaitList.html")
    public String jumpOrderCustomerWaitListHtml() {
        return "order/order_customer_wait_list";
    }

    //打开客户修改订单页面
    @RequestMapping("openOrderCustomerModify.html")
    public String openOrderCustomerModifyHtml() {
        return "order/order_customer_modify";
    }

    //跳转客户拍摄中页面
    @RequestMapping("jumpOrderCustomerShooting.html")
    public String jumpOrderCustomerShootingHtml() {
        return "order/order_customer_shooting";
    }

    //跳转客户已拍摄页面
    @RequestMapping("jumpOrderCustomerAlready.html")
    public String jumpOrderCustomerAlreadyHtml() {
        return "order/order_customer_already";
    }

    //跳转摄影师待摄影接单页面
    @RequestMapping("jumpOrderPhotograpgerWait.html")
    public String jumpOrderPhotograpgerWaitHtml() {
        return "order/order_photographer_wait";
    }

    //跳转摄影师拍摄中页面
    @RequestMapping("jumpOrderPhotographerShooting.html")
    public String jumpOrderPhotographerShootingHtml() {
        return "order/order_photographer_shooting";
    }

    //跳转摄影师完成拍摄的页面
    @RequestMapping("jumpOrderPhotographerAlready.html")
    public String jumpOrderPhotographerAlreadyHtml() {
        return "order/order_photographer_already";
    }


}
