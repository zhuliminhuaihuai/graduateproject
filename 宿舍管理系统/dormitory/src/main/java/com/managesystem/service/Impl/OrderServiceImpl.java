package com.managesystem.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.managesystem.common.Const;
import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.dao.BedRoomMapper;
import com.managesystem.dao.OrderMapper;
import com.managesystem.dao.UserMapper;
import com.managesystem.pojo.BedRoom;
import com.managesystem.pojo.Order;
import com.managesystem.pojo.User;
import com.managesystem.service.IOrderService;
import com.managesystem.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.managesystem.util.PublicUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImpl implements IOrderService {


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BedRoomMapper bedRoomMapper;

    //添加充值订单
    public ServerResponse addRechargeOrder(HttpServletRequest request, Order order) {
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        order.setOrderCode(PublicUtil.setCode("O"));
        order.setOrderType(1);//订单类型 1.充值 2.报修
        order.setOrderState(1);//1.未受理  2.已受理
        order.setUserCode(user.getUserCode());
        order.setUserName(user.getUserName());
        order.setOrderCreateTime(new Date());
        int count = orderMapper.insertSelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("添加成功");
        } else {
            return ServerResponse.createByErrorMessage("添加失败");
        }
    }
    //添加报修订单
    public ServerResponse addRepairOrder(HttpServletRequest request, Order order) {
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        order.setOrderCode(PublicUtil.setCode("O"));
        order.setOrderType(2);//订单类型 1.充值 2.报修
        order.setOrderState(1);//1.未受理  2.已受理
        order.setUserCode(user.getUserCode());
        order.setUserName(user.getUserName());
        order.setOrderCreateTime(new Date());
        int count = orderMapper.insertSelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("添加成功");
        } else {
            return ServerResponse.createByErrorMessage("添加失败");
        }
    }
    //充值订单列表
    public LayUiPageResponse rechargeOrderList(OrderVo orderVo,Integer userRole,Integer page,Integer limit) {

        if (userRole == 1 || userRole == 2) {
            orderVo.setUserCode("");
        }
        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.fingRechargeOrderList(orderVo);
        if (orderList.size() > 0) {
            PageInfo pageInfo = new PageInfo(orderList);
            return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
    }
    //报修订单列表
    public LayUiPageResponse repairOrderList(OrderVo orderVo, Integer userRole, Integer page, Integer limit) {
        if (userRole == 1 || userRole == 2) {
            orderVo.setUserCode("");
        }
        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.fingRepairOrderList(orderVo);
        if (orderList.size() > 0) {
            PageInfo pageInfo = new PageInfo(orderList);
            return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }

    }
    //充值成功受理
    public ServerResponse shenheRechargeOrder(Integer orderId) {

        Order order = orderMapper.selectByPrimaryKey(orderId);
        String userCode = order.getUserCode();
        User user = userMapper.findUserByUserCode(userCode);
        String bedRoomCode = user.getBedroomCode();
        BedRoom bedRoom = bedRoomMapper.findBedRoomByCode(bedRoomCode);
        bedRoom.setBedroomBalance(bedRoom.getBedroomBalance()+order.getOrderMoney());
        int count = bedRoomMapper.updateByPrimaryKeySelective(bedRoom);
        if (count > 0) {
            order.setOrderState(2);
            order.setOrderUpdateTime(new Date());
            int updateCount = orderMapper.updateByPrimaryKeySelective(order);
            if (updateCount > 0) {
                return ServerResponse.createBySuccessMessage("充值成功");
            } else {
                return ServerResponse.createByErrorMessage("充值失败");
            }
        } else {
            return ServerResponse.createByErrorMessage("充值失败");
        }
    }
    //报修受理成功受理
    public ServerResponse shenheRepairOrder(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setOrderState(2);
        order.setOrderUpdateTime(new Date());
        int updateCount = orderMapper.updateByPrimaryKeySelective(order);
        if (updateCount > 0) {
            return ServerResponse.createBySuccessMessage("受理成功");
        } else {
            return ServerResponse.createByErrorMessage("受理失败");
        }
    }
}
