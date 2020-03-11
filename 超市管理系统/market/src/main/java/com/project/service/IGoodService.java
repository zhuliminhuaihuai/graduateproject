package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Goods;
import com.project.vo.GoodsQueryVo;

/**
 * IGoodService
 *
 * @author {zhulimin}
 * @date 2020/2/14 0014 上午 2:07
 */
public interface IGoodService {

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
    ServerResponse modifyGoods(Goods goods, String goodsCostPrice1, String goodsRelPrice1);

    //商品低于预警线
    ServerResponse goodsLowNumberLine();

    //补货商品列表
    LayUiPageResponse getReplenishmentList(Integer page, Integer limit);

    ServerResponse getGoodListByGoodSort(String goodsSort);

    //补充商品货物
    ServerResponse addReplenishmentGoods(Goods goods);

    //添加商品
    ServerResponse addGoods(Goods goods, String goodsCostPrice1, String goodsRelPrice1);


}
