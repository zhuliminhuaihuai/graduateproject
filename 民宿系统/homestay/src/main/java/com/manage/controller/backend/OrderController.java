package com.manage.controller.backend;

import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.service.IOrderService;
import com.manage.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * OrderController
 *
 * @author {zhulimin}
 * @date 2020/3/2 0002 下午 15:52
 */
@Controller
@RequestMapping("/manage/order/")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    @RequestMapping("addOrder")
    @ResponseBody
    public ServerResponse addOrder(String startTime, String endTime, Integer roomId, HttpServletRequest request) {
        return iOrderService.addOrder(startTime, endTime, roomId, request);
    }

    @RequestMapping("orderList")
    @ResponseBody
    public LayUiPageResponse orderList(HttpServletRequest request, OrderVo orderVo, Integer page, Integer limit) {
        return iOrderService.orderList(request, orderVo, page, limit);
    }

    @RequestMapping("deleteOrder")
    @ResponseBody
    public ServerResponse deleteOrder(Integer orderId) {
        return iOrderService.deleteOrder(orderId);
    }

    @RequestMapping("goHome")
    @ResponseBody
    public ServerResponse goHome(Integer orderId) {
        return iOrderService.goHome(orderId);
    }

    @RequestMapping("orderFail")
    @ResponseBody
    public ServerResponse orderFail(Integer orderId) {
        return iOrderService.orderFail(orderId);
    }

    @RequestMapping("orderSuccess")
    @ResponseBody
    public ServerResponse orderSuccess(Integer orderId) {
        return iOrderService.orderSuccess(orderId);
    }
    /*********************************/
    @RequestMapping("jumpOrderList.html")
    public String jumpOrderListHtml() {
        return "order/order_list";
    }

}
