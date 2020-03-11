package com.manage.service;

import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.vo.OrderVo;

import javax.servlet.http.HttpServletRequest;

/**
 * IOrderService
 *
 * @author {zhulimin}
 * @date 2020/3/2 0002 下午 15:52
 */
public interface IOrderService {

    ServerResponse addOrder(String startTime, String endTime, Integer roomId, HttpServletRequest request);

    LayUiPageResponse orderList(HttpServletRequest request, OrderVo orderVo, Integer page, Integer limit);

    ServerResponse deleteOrder(Integer orderId);

    ServerResponse goHome(Integer orderId);

    ServerResponse orderFail(Integer orderId);

    ServerResponse orderSuccess(Integer orderId);
}
