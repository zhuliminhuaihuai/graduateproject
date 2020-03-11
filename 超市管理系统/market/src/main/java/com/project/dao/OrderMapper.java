package com.project.dao;

import com.project.pojo.Order;
import com.project.vo.OrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> orderList(OrderVo orderVo);

    int deleteOrderByGoodsCode(@Param("goodsCode") String goodsCode);
}