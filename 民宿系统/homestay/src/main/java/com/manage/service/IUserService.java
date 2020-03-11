package com.manage.service;

import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.pojo.User;
import com.manage.vo.UserVo;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {

    //登录
    ServerResponse<User> login(String username, String password);

    //用户注册
    ServerResponse register(String userName, String userPassword, String userPhone, Integer userRole);

    //用户列表
    LayUiPageResponse userList(UserVo userVo, Integer page, Integer limit);

    //添加用户
    ServerResponse addUser(User user);

    //删除用户
    ServerResponse deleteUser(Integer userId);

    //批量删除用户
    ServerResponse someDeleteUser(String ids);

    //用户详情
    ServerResponse detailUser(Integer userId);

    ServerResponse isHaveRealName(HttpServletRequest request);

    //保存用户
    ServerResponse saveUser(HttpServletRequest request, User user);

    ServerResponse findTenant(HttpServletRequest request);

    //重置密码
    ServerResponse rePassword(Integer userId);

    ServerResponse editPass(Integer userId,String oldPass,String newPass);


}
