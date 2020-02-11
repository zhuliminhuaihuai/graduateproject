package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.OrderMapper;
import com.project.dao.RoomMapper;
import com.project.pojo.Order;
import com.project.pojo.Room;
import com.project.pojo.User;
import com.project.service.IOrderService;
import com.project.util.DateUtil;
import com.project.util.PublicUtil;
import com.project.vo.ClassRoomQueryVo;
import com.project.vo.OrderQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private OrderMapper orderMapper;

    //获取租借教室列表
    @Override
    public LayUiPageResponse getBorrowRoomList(Integer page, Integer limit, ClassRoomQueryVo classRoomQueryVo) {

        PageHelper.startPage(page, limit);
        List<Room> roomList = roomMapper.getBorrowRoomList(classRoomQueryVo);
        if (roomList.size() > 0) {
            PageInfo pageInfo = new PageInfo(roomList);
            return LayUiPageResponse.createBySuccess(roomList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无教室!!!");
        }
    }

    //学生借用教室
    public ServerResponse addBorrowOrder(HttpServletRequest request, Order order, String orderAppointmentTime1) {

        int checkCount = orderMapper.checkRoomIsBorrow(orderAppointmentTime1, order.getOrderSelection());
        if (checkCount > 0) {
            return ServerResponse.createByErrorMessage("该时间段的教室已被租用");
        } else {
            order.setOrderCode(PublicUtil.setCode("B"));
            order.setOrderState(1);//审核中
            order.setOrderAppointmentTime(DateUtil.stringToDate(orderAppointmentTime1, "yyyy-MM-dd"));
            order.setOrderCreateTime(new Date());
            User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
            order.setStudentCode(user.getUserCode());
            order.setStudentName(user.getUserRealName());
            order.setStudentCollege(user.getUserCollege());
            order.setStudentClass(user.getUserClassroom());
            int count = orderMapper.insertSelective(order);
            if (count > 0) {
                return ServerResponse.createBySuccessMessage("借用申请成功!等待审核");
            } else {
                return ServerResponse.createByErrorMessage("借用申请失败!");
            }
        }
    }
    //教室审核
    public LayUiPageResponse getBorrowOrderList(Integer page, Integer limit, OrderQueryVo orderQueryVo) {

        if (orderQueryVo.getUserRole().equals("0")) {
            orderQueryVo.setStudentCode("");
        } else {
            orderQueryVo.setStudentCode(orderQueryVo.getUserCode());
        }
        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.getBorrowOrderList(orderQueryVo);
        if (orderList.size() > 0) {
            PageInfo pageInfo = new PageInfo(orderList);
            return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无教室申请需求!!!");
        }
    }
    //历史记录
    public LayUiPageResponse getOrederHistory(Integer page, Integer limit, OrderQueryVo orderQueryVo) {

        if (orderQueryVo.getUserRole().equals("0")) {
            orderQueryVo.setStudentCode("");
        } else {
            orderQueryVo.setStudentCode(orderQueryVo.getUserCode());
        }
        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.getOrederHistory(orderQueryVo);
        if (orderList.size() > 0) {
            PageInfo pageInfo = new PageInfo(orderList);
            return LayUiPageResponse.createBySuccess(orderList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无教室申请需求!!!");
        }
    }

    //借用订单详情
    public ServerResponse getOrderDetail(Integer orderId) {

        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order != null) {
            return ServerResponse.createBySuccess("找到申请请求", order);
        } else {
            return ServerResponse.createByErrorMessage("未找到申请请求");
        }
    }
    //审核通过
    public ServerResponse passOrder(Integer orderId, HttpServletRequest request) {

        Order order = orderMapper.selectByPrimaryKey(orderId);
        int checkCount = orderMapper.checkRoomIsBorrow(DateUtil.dateToString(order.getOrderAppointmentTime(),"yyyy-MM-dd"), order.getOrderSelection());
        if (checkCount > 0) {
            return ServerResponse.createByErrorMessage("该时间段的教室已被租用");
        } else {
            User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
            order.setOrderState(2);//已审核
            order.setOrderExamineState(1);//审核通过
            order.setTercherCode(user.getUserCode());
            order.setTercherName(user.getUserRealName()+"老师");
            order.setOrderResult("审核通过");
            order.setOrderUpdateTime(new Date());
            int count = orderMapper.updateByPrimaryKeySelective(order);
            if (count > 0) {
                return ServerResponse.createBySuccessMessage("审核通过!!!");
            } else {
                return ServerResponse.createByErrorMessage("审核失败!!!");
            }

        }
    }

    //审核不通过
    public ServerResponse noPassOrder(Integer orderId, HttpServletRequest request,String orderResult) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        order.setOrderState(2);//已审核
        order.setOrderExamineState(2);//审核不通过
        order.setTercherCode(user.getUserCode());
        order.setTercherName(user.getUserRealName()+"老师");
        order.setOrderResult(orderResult);
        order.setOrderUpdateTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("提交成功!!!");
        } else {
            return ServerResponse.createByErrorMessage("审核失败!!!");
        }
    }

    //撤回申请
    public ServerResponse withdrawOrder(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setOrderState(3);//撤回
        order.setOrderResult("申请撤回");
        order.setOrderUpdateTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("撤回成功!!!");
        } else {
            return ServerResponse.createByErrorMessage("撤回失败!!!");
        }
    }

    //删除申请
    public ServerResponse deleteOrder(Integer orderId) {

        int count = orderMapper.deleteByPrimaryKey(orderId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功!!!");
        } else {
            return ServerResponse.createByErrorMessage("删除失败!!!");
        }
    }


}
