package com.manage.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.common.Const;
import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.dao.OrderMapper;
import com.manage.dao.RoomMapper;
import com.manage.dao.UserMapper;
import com.manage.pojo.Order;
import com.manage.pojo.Room;
import com.manage.pojo.User;
import com.manage.service.IOrderService;
import com.manage.util.DateUtil;
import com.manage.util.PublicUtil;
import com.manage.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * OrderServiceImpl
 *
 * @author {zhulimin}
 * @date 2020/3/2 0002 下午 15:53
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ServerResponse addOrder(String startTime, String endTime, Integer roomId, HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        if (user.getUserFindPassword() == null) {
            return ServerResponse.createByErrorMessage("您还未实名，无法预约");
        }
        if (user.getUserRole() == Const.Role.ROLE_TENANT) {
            return ServerResponse.createByErrorMessage("您是房东，无法预约");
        }
        Room room = roomMapper.selectByPrimaryKey(roomId);

        Order order = new Order();
        order.setOrderCode(PublicUtil.setCode("O"));
        order.setOrderCreateTime(new Date());
        order.setOrderState(1);
        order.setCheckInStartTime(DateUtil.stringToDate(startTime, DateUtil.DF_DATE));
        order.setCheckInEndTime(DateUtil.stringToDate(endTime, DateUtil.DF_DATE));
        order.setCheckInState(1);
        order.setCustomerName(user.getHeadimg());
        order.setCustomerCode(user.getUserCode());
        order.setCustomerId(user.getUserFindPassword());
        order.setTenantName(room.getTenantName());
        order.setTenantCode(room.getTenantCode());
        order.setTenantId(user.getUserPhone());
        order.setRoomCode(room.getRoomCode());
        order.setRoomSimpleRemark(room.getRoomSimpleRemark());
        order.setRoomRelPrice(room.getRoomRelPrice());
        order.setRoomId(roomId);
        int count = orderMapper.insertSelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("预约成功");
        } else {
            return ServerResponse.createByErrorMessage("预约失败");
        }
    }

    @Override
    public LayUiPageResponse orderList(HttpServletRequest request, OrderVo orderVo, Integer page, Integer limit) {

        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        if (user.getUserRole() == Const.Role.ROLE_TENANT) {
            orderVo.setTenantCode(user.getUserCode());
        } else if (user.getUserRole() == Const.Role.ROLE_CUSTOMER) {
            orderVo.setCustomerCode(user.getUserCode());
        }
        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.getOrderList(orderVo);
        if (orderList.size() > 0) {
            PageInfo pageInfo = new PageInfo(orderList);
            return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
        }else{
            return LayUiPageResponse.createByErrorMessage("暂无数据！");
        }

    }

    @Override
    public ServerResponse deleteOrder(Integer orderId) {
        int count = orderMapper.deleteByPrimaryKey(orderId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }

    @Override
    public ServerResponse goHome(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order.getCheckInState() == 2) {
            return ServerResponse.createByErrorMessage("已经办理离宿了");
        }
        order.setOrderUpdateTime(new Date());
        order.setCheckInState(2);
        int count = orderMapper.updateByPrimaryKeySelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("离宿成功");
        } else {
            return ServerResponse.createByErrorMessage("离宿失败");
        }
    }

    @Override
    public ServerResponse orderFail(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setOrderState(3);
        order.setOrderUpdateTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("操作成功");
        } else {
            return ServerResponse.createByErrorMessage("操作失败");
        }
    }

    @Override
    public ServerResponse orderSuccess(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        Date startTime = order.getCheckInStartTime();
        Date endTime = order.getCheckInEndTime();
        List<Order> orderList = orderMapper.getOrderListByRoomCode(order.getRoomCode());
        boolean flag = true;
        for (int i = 0; i < orderList.size(); i++) {
            Order order1 = orderList.get(i);
            if ((order1.getCheckInStartTime().before(startTime) && order1.getCheckInEndTime().before(endTime) ||
                    (order1.getCheckInStartTime().after(startTime) && order1.getCheckInEndTime().after(endTime)))) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            order.setOrderState(2);
            order.setOrderUpdateTime(new Date());
            int count = orderMapper.updateByPrimaryKeySelective(order);
            if (count > 0) {
                return ServerResponse.createBySuccessMessage("预约成功");
            } else {
                return ServerResponse.createByErrorMessage("预约失败");
            }
        } else {
            return ServerResponse.createByErrorMessage("不好意思，该订单预约入住的时间范围内已经存在订单了");
        }

    }

}
