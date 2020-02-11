package com.manage.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.dao.GoodsMapper;
import com.manage.dao.UserMapper;
import com.manage.pojo.Goods;
import com.manage.service.IGoodsService;
import com.manage.util.PublicUtil;
import com.manage.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    //前端商城展示的商品

    /**
     *
     * @param goodsTitle 前端模糊查询水果
     * @param goodsBigType 水果分类1搜索
     * @param goodsType  水果分类2搜索
     * @return
     */
    public ServerResponse portalGetGoodsImg(String goodsTitle, Integer goodsBigType, Integer goodsType) {
        //从数据库获取相应条件的水果列表
        List<Goods> goodsList = goodsMapper.portalGetGoodsImg(goodsTitle, goodsBigType, goodsType);
        //封装前端所需要的样式json的list
        List<ContentVo> content = Lists.newArrayList();
        if (goodsList.size() > 0) {
            GoodsVo goodsVo = new GoodsVo();
            MenuVo1 menu = new MenuVo1();
            MilkVo milk = new MilkVo();
            String photoPath = "http://127.0.0.1:8080/upload/";
            for (int i = 0; i < goodsList.size(); i++) {
                ContentVo contentVo = new ContentVo();
                //封装水果商品照片
                contentVo.setImg(photoPath + goodsList.get(i).getGoodsImg());
                //封装水果商品名称
                contentVo.setTitle(goodsList.get(i).getGoodsTitle());
                //封装水果商品成交记录量
                contentVo.setNub(goodsList.get(i).getGoodsBuyNum());
                //封装水果商品成交价
                contentVo.setPri(goodsList.get(i).getGoodsRelPrice());
                //封装水果商品原价
                contentVo.setDelpri(goodsList.get(i).getGoodsPrice());
                //封装水果商品的主键
                contentVo.setGoodsId(goodsList.get(i).getGoodsId());
                content.add(contentVo);
            }
            milk.setContent(content);
            menu.setMilk(milk);
            goodsVo.setStatus(0);
            goodsVo.setMenu(menu);
            goodsVo.setCount(goodsList.size());
            return ServerResponse.createBySuccess("找到商品", goodsVo);
        } else {
            return ServerResponse.createByErrorMessage("没有数据");
        }
    }
    //前端水果商品的详情
    public ServerResponse portalDetailGoodsMessage(Integer goodsId) {

        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        if (goods != null) {
            return ServerResponse.createBySuccess("找到此商品", goods);
        } else {
            return ServerResponse.createByErrorMessage("未找到此商品");
        }
    }
    //后台商品列表
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
    public ServerResponse deleteGoods(Integer goodsId) {

        int count = goodsMapper.deleteByPrimaryKey(goodsId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }
    //商品详情
    public ServerResponse detailGoods(Integer goodsId) {

        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        if (goods != null) {
            return ServerResponse.createBySuccess("找到商品", goods);
        } else {
            return ServerResponse.createByErrorMessage("未找到该商品");
        }

    }
    //保存商品 修改商品
    public ServerResponse modifyGoods(Goods goods, String goodsPrice1, String goodsCostPrice1, String goodsRelPrice1) {

        goods.setGoodsPrice(Double.parseDouble(goodsPrice1));
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
    public ServerResponse goodsLowNumberLine() {

        int count = goodsMapper.goodsLowNumberLine();
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("商品存在低于预警线");
        } else {
            return ServerResponse.createByErrorMessage("不存在商品低于预警线");
        }
    }
    //补货商品列表
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
    //补充商品货物
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
     * @param goodsPrice1
     * @param goodsCostPrice1
     * @param goodsRelPrice1
     * @return
     */
    public ServerResponse addGoods(Goods goods, String goodsPrice1, String goodsCostPrice1, String goodsRelPrice1) {

        goods.setGoodsPrice(Double.parseDouble(goodsPrice1));
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
