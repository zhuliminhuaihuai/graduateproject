package com.manage.dao;

import com.manage.pojo.Goods;
import com.manage.vo.GoodsQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    //商品低于预警线
    int goodsLowNumberLine();

    //补货单列表
    List<Goods> getReplenishmentList();

    //前端商城展示的商品
    List<Goods> portalGetGoodsImg(@Param("goodsTitle") String goodsTitle, @Param("goodsBigType") Integer goodsBigType, @Param("goodsType") Integer goodsType);

    //后台商品列表
    List<Goods> getGoodsList(GoodsQueryVo goodsQueryVo);

    //批量删除商品
    int someDeleteGoods(@Param("idList") List<Integer> idList);

    //计算所获得的所有利润
    double getprofitMoneyTotal();


}