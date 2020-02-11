package com.manage.service;

import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.pojo.Goods;
import com.manage.vo.GoodsQueryVo;

public interface IGoodsService {

    //前端商城展示的商品
    ServerResponse portalGetGoodsImg(String goodsTitle, Integer goodsBigType, Integer goodsType);

    //前端水果商品的详情
    ServerResponse portalDetailGoodsMessage(Integer goodsId);

    //后台商品列表
    LayUiPageResponse goodsList(GoodsQueryVo goodsQueryVo, Integer page, Integer limit);

    //修改商品状态 是否启用
    ServerResponse modifyGoodsState(Integer goodsId, Integer goodsState);

    //批量删除商品
    ServerResponse someDeleteGoods(String ids);

    //删除商品
    ServerResponse deleteGoods(Integer goodsId);

    //商品详情
    ServerResponse detailGoods(Integer goodsId);

    //保存商品 修改商品
    ServerResponse modifyGoods(Goods goods, String goodsPrice1, String goodsCostPrice1, String goodsRelPrice1);

    //商品低于预警线
    ServerResponse goodsLowNumberLine();

    //补货商品列表
    LayUiPageResponse getReplenishmentList(Integer page, Integer limit);

    //补充商品货物
    ServerResponse addReplenishmentGoods(Goods goods);

    //添加商品
    ServerResponse addGoods(Goods goods, String goodsPrice1, String goodsCostPrice1, String goodsRelPrice1);


}
