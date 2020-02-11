package com.manage.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.dao.RoomMapper;
import com.manage.dao.UserMapper;
import com.manage.pojo.Room;
import com.manage.pojo.User;
import com.manage.service.IUserService;
import com.manage.util.MD5Utils;
import com.manage.util.PublicUtil;
import com.manage.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoomMapper roomMapper;

    //登录
    public ServerResponse<User> login(String username, String password) {
        int userCount = userMapper.checkUserName(username);
        if (userCount == 0) {
            return ServerResponse.createByErrorMessage("该用户不存在！");
        }
        String passwordMD5 = MD5Utils.MD5Encode(password, "UTF-8");

        User user = userMapper.login(username, passwordMD5);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误！");
        }
        user.setUserPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功！", user);
    }

    //找到所有空闲房源的封面照
    public ServerResponse findAllFreedomRoom(String roomTitle) {

        List<Room> roomList = roomMapper.findAllFreedomRoom(roomTitle);
        if (roomList.size() > 0) {

            return ServerResponse.createBySuccess("找到空闲房源", roomList);

        } else {
            return ServerResponse.createByErrorMessage("暂无空闲房源");
        }
    }
    //用户入住
    public ServerResponse addUser(User user, Integer roomId) {

        String userCode = PublicUtil.setCode("U");
        user.setUserCode(userCode);
        user.setUserRole(2);
        Room room = roomMapper.selectByPrimaryKey(roomId);
        String roomCode = room.getRoomCode();
        user.setRoomCode(roomCode);
        user.setUserCreateTime(new Date());
        int count = userMapper.insertSelective(user);
        if (count > 0) {

            room.setRoomState(user.getRoomState());
            room.setUserCode(userCode);
            int count1 = roomMapper.updateByPrimaryKeySelective(room);
            if (count1 > 0) {
                return ServerResponse.createBySuccessMessage("确认成功");
            } else {
                return ServerResponse.createByErrorMessage("确认失败");
            }
        } else {
            return ServerResponse.createByErrorMessage("确认失败");
        }
    }
    //客户列表
    public LayUiPageResponse userList(User user,Integer page,Integer limit) {

        PageHelper.startPage(page, limit);
        List<User> userList = userMapper.getUserListByCondition(user);
        List<UserVo> userVoList = Lists.newArrayList();
        String photoPath = "http://127.0.0.1:8080/upload/";

        if (userList.size() > 0) {
            for (int i = 0; i < userList.size(); i++) {
                UserVo userVo = new UserVo();
                User user1 = userList.get(i);
                userVo.setUserId(user1.getUserId());
                userVo.setUserName(user1.getUserName());
                userVo.setUserCode(user1.getUserCode());
                userVo.setUserPhone(user1.getUserPhone());
                userVo.setUserIdCard(user1.getUserIdCard());
                userVo.setRoomCode(user1.getRoomCode());
                userVo.setRoomState(user1.getRoomState());
                userVo.setUserCreateTime(user1.getUserCreateTime());
                Room room = roomMapper.findRoomByRoomCode(user1.getRoomCode());
                userVo.setRoomAddress(room.getRoomAddress());
                userVo.setRoomTitle(room.getRoomTitle());
                userVo.setRomImg(photoPath + room.getRomImg());
                userVoList.add(userVo);
            }
            PageInfo pageInfo = new PageInfo(userVoList);
            return LayUiPageResponse.createBySuccess(userVoList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据！");
        }
    }
    //客户预约房变成入住房
    public ServerResponse updateRoomStateOneToTwo(Integer userId, String roomCode) {

        User user = userMapper.selectByPrimaryKey(userId);
        user.setRoomState(2);
        int count = userMapper.updateByPrimaryKeySelective(user);
        if (count > 0) {

            Room room = roomMapper.findRoomByRoomCode(roomCode);
            room.setRoomState(2);
            int count1 = roomMapper.updateByPrimaryKeySelective(room);
            if (count1 > 0) {
                return ServerResponse.createBySuccessMessage("修改成功");
            } else {
                return ServerResponse.createByErrorMessage("修改失败");
            }
        } else {
            return ServerResponse.createByErrorMessage("修改失败");
        }
    }
    //客户离房
    public ServerResponse updateRoomStateTwoToThree(Integer userId, String roomCode) {
        User user = userMapper.selectByPrimaryKey(userId);
        user.setRoomState(3);
        int count = userMapper.updateByPrimaryKeySelective(user);
        if (count > 0) {

            Room room = roomMapper.findRoomByRoomCode(roomCode);
            room.setRoomState(0);
            room.setUserCode("");
            int count1 = roomMapper.updateByPrimaryKeySelective(room);
            if (count1 > 0) {
                return ServerResponse.createBySuccessMessage("修改成功");
            } else {
                return ServerResponse.createByErrorMessage("修改失败");
            }
        } else {
            return ServerResponse.createByErrorMessage("修改失败");
        }
    }
    //删除客户的客房记录
    public ServerResponse deleteUser(Integer userId) {

        int count = userMapper.deleteByPrimaryKey(userId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }


}
