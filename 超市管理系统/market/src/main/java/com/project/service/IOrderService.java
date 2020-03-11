package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Order;
import com.project.vo.OrderVo;

/**
 * IOrderService
 *
 * @author {zhulimin}
 * @date 2020/2/17 0017 下午 15:24
 */
public interface IOrderService {

    ServerResponse addOrder(Order order);

    LayUiPageResponse getOrderList(OrderVo orderVo, int page, int limit);

    ServerResponse deleteOrder(Integer orderId);
}
