package com.manage.dao;

import com.manage.pojo.Order;
import com.manage.vo.OrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> getOrderList(OrderVo orderVo);

    List<Order> getOrderListByRoomCode(@Param("roomCode") String roomCode);
}