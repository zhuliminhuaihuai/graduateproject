package com.project.controller.backend;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Order;
import com.project.service.IOrderService;
import com.project.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * OrderController
 *
 * @author {zhulimin}
 * @date 2020/2/17 0017 下午 15:24
 */
@Controller
@RequestMapping("/manage/order/")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    @RequestMapping("add")
    @ResponseBody
    public ServerResponse addOrder(Order order) {
        return iOrderService.addOrder(order);
    }

    @RequestMapping("orderList")
    @ResponseBody
    public LayUiPageResponse getOrderList(OrderVo orderVo, int page, int limit) {
        return iOrderService.getOrderList(orderVo, page, limit);
    }

    @RequestMapping("deleteOrder")
    @ResponseBody
    public ServerResponse deleteOrder(Integer orderId) {
        return iOrderService.deleteOrder(orderId);
    }
    /**************************/
    //跳转入库单添加界面
    @RequestMapping("jumpOrderAdd.html")
    public String jumpOrderAddHtml() {
        return "order/order_add";
    }

    //跳转指定入库单添加界面
    @RequestMapping("jumpOrderAddSelect.html")
    public String jumpOrderAddSelectHtml() {
        return "order/order_add_select";
    }

    //跳转出库单添加界面
    @RequestMapping("jumpOrderReduce.html")
    public String jumpOrderReduceHtml() {
        return "order/order_reduce";
    }

    //跳转库单列表界面
    @RequestMapping("jumpOrderList.html")
    public String jumpOrderListHtml() {
        return "order/order_list";
    }

}
