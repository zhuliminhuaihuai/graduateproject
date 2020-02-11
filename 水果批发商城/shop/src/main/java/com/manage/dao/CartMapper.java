package com.manage.dao;

import com.alipay.api.domain.Car;
import com.manage.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    //获取当前用户下的购物车
    List<Cart> getAllGoods(@Param("userCode") String userCode);

    //获取用户当前下的所有购物车商品数量
    int getShopCartNumber(@Param("userCode") String userCode);

    //p批量更新购物车结算状态
    int updateCartSettlementType(@Param("idList") List<Integer> idList);

    //根据idList获取购物车的商品
    List<Cart> getCartListByIds(@Param("idList") List<Integer> idList);



}