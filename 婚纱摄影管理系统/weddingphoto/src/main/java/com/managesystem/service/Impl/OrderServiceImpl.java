package com.managesystem.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.dao.OrderMapper;
import com.managesystem.dao.UserMapper;
import com.managesystem.dao.WedPhotoMapper;
import com.managesystem.pojo.Order;
import com.managesystem.pojo.User;
import com.managesystem.pojo.WedPhoto;
import com.managesystem.service.IOrderService;
import com.managesystem.util.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private WedPhotoMapper wedPhotoMapper;

    //客户下单 预约婚纱
    public ServerResponse addOrder(String photographerCode, String orderRemark, String userCode, Integer photoId) {

        Order order = new Order();
        order.setOrderCode(PublicUtil.setCode("O"));

        //插入客户信息
        User user = userMapper.findUserByUserCode(userCode);
        order.setOrderCustomerName(user.getUserName());
        order.setOrderCustomerCode(userCode);
        order.setOrderCustomerPhone(user.getUserPhone());

        //插入摄影师信息
        User user1 = userMapper.findUserByUserCode(photographerCode);
        if (user1 != null) {
            order.setOrderPhotographerName(user1.getUserName());
            order.setOrderPhotographerCode(photographerCode);
            order.setOrderPhotographerPhone(user1.getUserPhone());
        }

        //插入相册套餐信息
        WedPhoto wedPhoto = wedPhotoMapper.selectByPrimaryKey(photoId);
        order.setOrderPhotoCode(wedPhoto.getPhotoCode());
        order.setOrderPhotoTitle(wedPhoto.getPhotoTitle());
        order.setOrderPhotoImg(wedPhoto.getPhotoImg());

        //插入订单信息
        order.setOrderState(0);
        order.setOrderRemark(orderRemark);
        order.setOrderCreateTime(new Date());

        int count = orderMapper.insertSelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("下单成功");
        } else {
            return ServerResponse.createByErrorMessage("下单失败");
        }
    }

    //客户待拍摄订单
    public LayUiPageResponse pendingOrderList(Order order, String startTime, String endTime, Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.pendingOrderList(order, startTime, endTime);
        String photoPath = "http://127.0.0.1:8080/upload/";
        if (orderList.size() > 0) {
            for (int i = 0; i < orderList.size(); i++) {
                orderList.get(i).setOrderPhotoImg(photoPath + orderList.get(i).getOrderPhotoImg());
            }
            PageInfo pageInfo = new PageInfo(orderList);
            return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据!!!");
        }
    }
    //客户拍摄中订单
    public LayUiPageResponse shootingOrderList(Order order, String startTime, String endTime, Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.shootingingOrderList(order, startTime, endTime);
        String photoPath = "http://127.0.0.1:8080/upload/";
        if (orderList.size() > 0) {
            for (int i = 0; i < orderList.size(); i++) {
                orderList.get(i).setOrderPhotoImg(photoPath + orderList.get(i).getOrderPhotoImg());
            }
            PageInfo pageInfo = new PageInfo(orderList);
            return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据!!!");
        }
    }
    //客户已拍摄订单
    public LayUiPageResponse alreadyOrderList(Order order, String startTime, String endTime, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.alreadyingOrderList(order, startTime, endTime);
        String photoPath = "http://127.0.0.1:8080/upload/";
        if (orderList.size() > 0) {
            for (int i = 0; i < orderList.size(); i++) {
                orderList.get(i).setOrderPhotoImg(photoPath + orderList.get(i).getOrderPhotoImg());
            }
            PageInfo pageInfo = new PageInfo(orderList);
            return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据!!!");
        }

    }
    //摄影师待摄影订单
    public LayUiPageResponse photographerPendingOrderList(Order order, String startTime, String endTime, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.photographerPendingOrderList(order, startTime, endTime);
        String photoPath = "http://127.0.0.1:8080/upload/";
        if (orderList.size() > 0) {
            for (int i = 0; i < orderList.size(); i++) {
                orderList.get(i).setOrderPhotoImg(photoPath + orderList.get(i).getOrderPhotoImg());
            }
            PageInfo pageInfo = new PageInfo(orderList);
            return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据!!!");
        }

    }
    //摄影师拍摄中订单
    public LayUiPageResponse photographerShootingOrderList(Order order, String startTime, String endTime, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.photographerShootingOrderList(order, startTime, endTime);
        String photoPath = "http://127.0.0.1:8080/upload/";
        if (orderList.size() > 0) {
            for (int i = 0; i < orderList.size(); i++) {
                orderList.get(i).setOrderPhotoImg(photoPath + orderList.get(i).getOrderPhotoImg());
            }
            PageInfo pageInfo = new PageInfo(orderList);
            return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据!!!");
        }
    }
    //摄影师已摄影订单
    public LayUiPageResponse photographerAlreadyOrderList(Order order, String startTime, String endTime, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.photographerAlreadyOrderList(order, startTime, endTime);
        String photoPath = "http://127.0.0.1:8080/upload/";
        if (orderList.size() > 0) {
            for (int i = 0; i < orderList.size(); i++) {
                orderList.get(i).setOrderPhotoImg(photoPath + orderList.get(i).getOrderPhotoImg());
            }
            PageInfo pageInfo = new PageInfo(orderList);
            return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据!!!");
        }

    }
    //客户撤回婚纱拍摄
    public ServerResponse withdrawWedOrder(Integer orderId) {

        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderState(8);
        order.setOrderUpdateTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        } else {
            return ServerResponse.createByErrorMessage("修改失败！");
        }
    }

    //摄影师接单
    public ServerResponse receiptWedOrder(Integer orderId,String orderPhotographerCode) {
        Order order = new Order();
        User user = userMapper.findUserByUserCode(orderPhotographerCode);
        order.setOrderId(orderId);
        order.setOrderState(1);
        order.setOrderPhotographerName(user.getUserName());
        order.setOrderPhotographerPhone(user.getUserPhone());
        order.setOrderPhotographerCode(orderPhotographerCode);
        order.setOrderCreateTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("接单成功");
        } else {
            return ServerResponse.createByErrorMessage("接单失败");
        }
    }
    //摄影师提交完成订单
    public ServerResponse completeWedOrder(Integer orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderState(6);
        order.setOrderCreateTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("提交完成成功");
        } else {
            return ServerResponse.createByErrorMessage("完成失败");
        }
    }
    //客户确认完成订单
    public ServerResponse confimWedOrder(Integer orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderState(2);
        order.setOrderCreateTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("婚纱确认成功");
        } else {
            return ServerResponse.createByErrorMessage("确认失败");
        }
    }

    //客户修改前的详情页面
    public ServerResponse withdrawDetailWedOrder(Integer orderId) {

        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order != null) {
            return ServerResponse.createBySuccess("找到该订单", order);
        } else {
            return ServerResponse.createByErrorMessage("未找到该订单");
        }

    }
    //客户修改婚纱预约单
    public ServerResponse modifyWedOrder(Order order) {

        String userCode = order.getOrderPhotographerCode();
        User user = userMapper.findUserByUserCode(userCode);
        if (user != null) {
            order.setOrderPhotographerPhone(user.getUserPhone());
            order.setOrderPhotographerName(user.getUserName());
        } else {
            order.setOrderPhotographerPhone("");
            order.setOrderPhotographerName("");
        }
        int count = orderMapper.updateByPrimaryKeySelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        } else {
            return ServerResponse.createByErrorMessage("修改失败");
        }
    }



}
