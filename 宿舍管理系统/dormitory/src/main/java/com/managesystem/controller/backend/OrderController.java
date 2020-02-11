package com.managesystem.controller.backend;

import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.Order;
import com.managesystem.service.IOrderService;
import com.managesystem.vo.OrderVo;
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

    //添加充值订单
    @RequestMapping("addRechargeOrder")
    @ResponseBody
    public ServerResponse addRechargeOrder(HttpServletRequest request, Order order) {
        return iOrderService.addRechargeOrder(request, order);
    }

    //添加报修订单
    @RequestMapping("addRepairOrder")
    @ResponseBody
    public ServerResponse addRepairOrder(HttpServletRequest request, Order order) {
        return iOrderService.addRepairOrder(request, order);
    }

    //充值订单列表
    @RequestMapping("rechargeOrderList")
    @ResponseBody
    public LayUiPageResponse rechargeOrderList(OrderVo orderVo, Integer userRole, Integer page, Integer limit) {
        return iOrderService.rechargeOrderList(orderVo, userRole, page, limit);
    }

    //报修订单列表
    @RequestMapping("repairOrderList")
    @ResponseBody
    public LayUiPageResponse repairOrderList(OrderVo orderVo, Integer userRole, Integer page, Integer limit) {
        return iOrderService.repairOrderList(orderVo, userRole, page, limit);
    }

    //充值成功受理
    @RequestMapping("shenheRechargeOrder")
    @ResponseBody
    public ServerResponse shenheRechargeOrder(Integer orderId) {
        return iOrderService.shenheRechargeOrder(orderId);
    }

    //报修受理成功受理
    @RequestMapping("shenheRepairOrder")
    @ResponseBody
    public ServerResponse shenheRepairOrder(Integer orderId) {
        return iOrderService.shenheRepairOrder(orderId);
    }
    /*********************************/
    //跳转充值订单页面
    @RequestMapping("jumpRechargOrderAdd.html")
    public String jumpRechargOrderAddHtml() {
        return "order/recharge_order_add";
    }

    //跳转报修订单页面
    @RequestMapping("jumpRepairOrderAdd.html")
    public String jumpRepairOrderAddHtml() {
        return "order/repair_order_add";
    }

    //跳转充值订单列表
    @RequestMapping("jumpRechargeOrderList.html")
    public String jumpRechargeOrderListHtml() {
        return "order/recharge_order_list";
    }

    //跳转报修订单列表界面
    @RequestMapping("jumpRepairOrderList.html")
    public String jumpRepairOrderList() {
        return "order/repair_order_list";
    }
}
