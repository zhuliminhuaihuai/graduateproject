package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.GoodsMapper;
import com.project.dao.OrderMapper;
import com.project.pojo.Goods;
import com.project.service.IGoodService;
import com.project.util.PublicUtil;
import com.project.vo.GoodsQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * GoodServiceImpl
 *
 * @author {zhulimin}
 * @date 2020/2/14 0014 上午 2:08
 */
@Service
public class GoodServiceImpl implements IGoodService {


    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderMapper orderMapper;


    //后台商品列表
    @Override
    public LayUiPageResponse goodsList(GoodsQueryVo goodsQueryVo, Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<Goods> goodsList = goodsMapper.getGoodsList(goodsQueryVo);
        String photoPath = "http://127.0.0.1:8080/upload/";
        if (goodsList.size() > 0) {
            for (int i = 0; i < goodsList.size(); i++) {
                goodsList.get(i).setGoodsImg(photoPath + goodsList.get(i).getGoodsImg());
            }
            PageInfo pageInfo = new PageInfo(goodsList);
            return LayUiPageResponse.createBySuccess(goodsList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
    }
    //修改商品状态 是否启用
    @Override
    public ServerResponse modifyGoodsState(Integer goodsId, Integer goodsState) {

        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        goods.setGoodsState(goodsState);
        int count = goodsMapper.updateByPrimaryKeySelective(goods);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        } else {
            return ServerResponse.createByErrorMessage("修改失败");
        }
    }
    //批量删除商品
    @Override
    public ServerResponse someDeleteGoods(String ids) {
        int i = ids.indexOf("[");
        int j = ids.indexOf("]");
        String s1 = ids.substring(i + 1, j);
        String[] idsArray= s1.split(",");
        List<Integer> idList =new ArrayList();
        for(String s : idsArray){
            Integer k = Integer.parseInt(s);
            idList.add(k);
        }
        int count = goodsMapper.someDeleteGoods(idList);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }

    }
    //删除商品
    @Override
    public ServerResponse deleteGoods(Integer goodsId) {

        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        int count = goodsMapper.deleteByPrimaryKey(goodsId);
        if (count > 0) {
            orderMapper.deleteOrderByGoodsCode(goods.getGoodsCode());
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }
    //商品详情
    @Override
    public ServerResponse detailGoods(Integer goodsId) {

        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        if (goods != null) {
            return ServerResponse.createBySuccess("找到商品", goods);
        } else {
            return ServerResponse.createByErrorMessage("未找到该商品");
        }

    }
    //保存商品 修改商品
    @Override
    public ServerResponse modifyGoods(Goods goods, String goodsCostPrice1, String goodsRelPrice1) {

        goods.setGoodsCostPrice(Double.parseDouble(goodsCostPrice1));
        goods.setGoodsRelPrice(Double.parseDouble(goodsRelPrice1));
        goods.setGoodsUpdateTime(new Date());
        int count = goodsMapper.updateByPrimaryKeySelective(goods);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("保存成功");
        } else {
            return ServerResponse.createByErrorMessage("保存失败");
        }
    }
    //商品低于预警线
    @Override
    public ServerResponse goodsLowNumberLine() {

        int count = goodsMapper.goodsLowNumberLine();
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("商品存在低于预警线");
        } else {
            return ServerResponse.createByErrorMessage("不存在商品低于预警线");
        }
    }
    //补货商品列表
    @Override
    public LayUiPageResponse getReplenishmentList(Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<Goods> goodsList = goodsMapper.getReplenishmentList();
        String photoPath = "http://127.0.0.1:8080/upload/";
        if (goodsList.size() > 0) {
            for (int i = 0; i < goodsList.size(); i++) {
                goodsList.get(i).setGoodsImg(photoPath + goodsList.get(i).getGoodsImg());
            }
            PageInfo pageInfo = new PageInfo(goodsList);
            return LayUiPageResponse.createBySuccess(goodsList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }

    }

    @Override
    public ServerResponse getGoodListByGoodSort(String goodsSort) {
        List<Goods> goodsList = goodsMapper.getGoodsBySort(goodsSort);
        if (goodsList.size() > 0) {
            return ServerResponse.createBySuccess("找到商品", goodsList);
        } else {
            return ServerResponse.createByErrorMessage("暂无数据");
        }
    }

    //补充商品货物
    @Override
    public ServerResponse addReplenishmentGoods(Goods goods) {

        Goods goods1 = goodsMapper.selectByPrimaryKey(goods.getGoodsId());
        goods.setGoodsInventory(goods1.getGoodsInventory() + goods.getGoodsInventory());
        int count = goodsMapper.updateByPrimaryKeySelective(goods);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("补货成功");
        } else {
            return ServerResponse.createByErrorMessage("补货失败");
        }
    }
    //添加商品

    /**
     *
     * @param goods
     * @param goodsCostPrice1
     * @param goodsRelPrice1
     * @return
     */
    @Override
    public ServerResponse addGoods(Goods goods, String goodsCostPrice1, String goodsRelPrice1) {

        goods.setGoodsCostPrice(Double.parseDouble(goodsCostPrice1));
        goods.setGoodsRelPrice(Double.parseDouble(goodsRelPrice1));
        goods.setGoodsCode(PublicUtil.setCode("G"));
        goods.setGoodsState(1);
        goods.setGoodsBuyNum(0);
        goods.setGoodsCreateTime(new Date());
        int count = goodsMapper.insertSelective(goods);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("添加成功");
        } else {
            return ServerResponse.createByErrorMessage("添加失败");
        }
    }



}
