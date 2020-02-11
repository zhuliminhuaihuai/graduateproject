package com.project.dao;

import com.project.pojo.Order;
import com.project.vo.OrderQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //检查该时间段的教室是否被人借用走
    int checkRoomIsBorrow(@Param("orderAppointmentTime") String orderAppointmentTime, @Param("orderSelection") String orderSelection);

    //教室审核
    List<Order> getBorrowOrderList(OrderQueryVo orderQueryVo);

    //历史记录
    List<Order> getOrederHistory(OrderQueryVo orderQueryVo);


}