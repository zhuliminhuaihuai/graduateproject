package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.GoodsMapper;
import com.project.dao.OrderMapper;
import com.project.pojo.Goods;
import com.project.pojo.Order;
import com.project.pojo.User;
import com.project.service.IOrderService;
import com.project.util.PublicUtil;
import com.project.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * OrderServiceImpl
 *
 * @author {zhulimin}
 * @date 2020/2/17 0017 下午 15:24
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderMapper orderMapper;



    @Override
    public ServerResponse addOrder(Order order) {
        if (order.getOrderType() == 2) {
            Goods goods = goodsMapper.getGoodsByCode(order.getOrderGoodCode());
            order.setOrderCode(PublicUtil.setCode("O"));
            order.setOrderCreateTime(new Date());
            order.setOrderGoodName(goods.getGoodsTitle());
            int count = orderMapper.insertSelective(order);
            if (count > 0) {
                goods.setGoodsInventory(goods.getGoodsInventory() + order.getOrderNumber());
                goods.setGoodsUpdateTime(new Date());
                goodsMapper.updateByPrimaryKeySelective(goods);
                return ServerResponse.createBySuccessMessage("操作成功!");
            } else {
                return ServerResponse.createByErrorMessage("操作失败!!");
            }
        } else {
            Goods goods = goodsMapper.getGoodsByCode(order.getOrderGoodCode());
            if ((goods.getGoodsInventory() - order.getOrderNumber()) < 0) {
                return ServerResponse.createByErrorMessage("无法出库，商品库存量不足!!!");
            } else {
                order.setOrderCode(PublicUtil.setCode("O"));
                order.setOrderCreateTime(new Date());
                order.setOrderGoodName(goods.getGoodsTitle());
                int count = orderMapper.insertSelective(order);
                if (count > 0) {
                    goods.setGoodsInventory(goods.getGoodsInventory() - order.getOrderNumber());
                    goods.setGoodsUpdateTime(new Date());
                    goodsMapper.updateByPrimaryKeySelective(goods);
                    return ServerResponse.createBySuccessMessage("操作成功!");
                } else {
                    return ServerResponse.createByErrorMessage("操作失败!!");
                }
            }
        }


    }

    @Override
    public LayUiPageResponse getOrderList(OrderVo orderVo, int page, int limit) {

        PageHelper.startPage(page,limit);
        List<Order> orderList= orderMapper.orderList(orderVo);
        if(orderList.size()==0){
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
        PageInfo pageInfo = new PageInfo(orderList);
        return LayUiPageResponse.createBySuccess(orderList,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }

    @Override
    public ServerResponse deleteOrder(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order.getOrderType() == 2) {
            int count = orderMapper.deleteByPrimaryKey(orderId);
            if (count > 0) {
                Goods goods = goodsMapper.getGoodsByCode(order.getOrderGoodCode());
                goods.setGoodsInventory(goods.getGoodsInventory() - order.getOrderNumber());
                goods.setGoodsUpdateTime(new Date());
                goodsMapper.updateByPrimaryKeySelective(goods);
                return ServerResponse.createBySuccessMessage("删除成功");
            } else {
                return ServerResponse.createByErrorMessage("删除失败");
            }
        } else {
            int count = orderMapper.deleteByPrimaryKey(orderId);
            if (count > 0) {
                Goods goods = goodsMapper.getGoodsByCode(order.getOrderGoodCode());
                goods.setGoodsInventory(goods.getGoodsInventory() + order.getOrderNumber());
                goods.setGoodsUpdateTime(new Date());
                goodsMapper.updateByPrimaryKeySelective(goods);
                return ServerResponse.createBySuccessMessage("删除成功");
            } else {
                return ServerResponse.createByErrorMessage("删除失败");
            }
        }

    }
}
