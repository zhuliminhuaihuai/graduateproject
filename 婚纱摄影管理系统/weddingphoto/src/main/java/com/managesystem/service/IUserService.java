package com.managesystem.service;

import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.User;
import com.managesystem.vo.UserVo;

import java.util.List;

public interface IUserService {

    //登录
    ServerResponse<User> login(String username, String password);

    //修改密码
    ServerResponse modifyPassword(String userCode, String oldpassword, String newpassword);

    //用户列表
    LayUiPageResponse<List<User>> getUserList(UserVo userVo, Integer page, Integer limit);

    //添加新用户
    ServerResponse addUser(User user);

    //简单注册
    ServerResponse register(User user);

    //获取当前登陆系统的人员信息
    ServerResponse findCurrentUser(String userCode);

    //根据角色类型查找用户
    ServerResponse findUserListByRole(Integer userRole);

    //用户详情
    ServerResponse userDetail(Integer userId);

    //修改用户信息
    ServerResponse userModify(User user);

    //删除用户
    ServerResponse userDelete(Integer userId);

    //重置用户密码
    ServerResponse userRePassword(Integer userId);

    //查找出所有的摄影师
    ServerResponse findAllPhotographer();


}
