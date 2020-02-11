package com.manage.service;

import com.manage.common.ServerResponse;

public interface ICartService {

    //获取当前用户下的购物车所有商品
    ServerResponse getAllGoodsUnderCart(String userCode);

    //加入购物车
    ServerResponse addGoodsToCart(String userCode, Integer goodsId, Integer number);

    //获取用户当前下的所有购物车商品数量
    ServerResponse getShopCartNumber(String userCode);

    //删除购物车的商品
    ServerResponse deleteGoodsUnderCart(Integer cartId);

//    //ds
//    ServerResponse dasd(String aa);



}
