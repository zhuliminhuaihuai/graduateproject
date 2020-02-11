package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.User;
import com.project.vo.UserQueryVo;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {

    //用户登录
    ServerResponse login(HttpServletRequest request, String userName, String password);

    //用户列表包含查询
    LayUiPageResponse getUserList(Integer page, Integer limit, UserQueryVo userQueryVo);

    //添加学生
    ServerResponse addUser(User user);

    //用户详情
    ServerResponse detailUser(Integer userId);

    //用户保存
    ServerResponse saveUser(User user);

    //重置密码
    ServerResponse reSetAgainPassword(Integer userId);

    //删除用户
    ServerResponse deleteUserByUserId(Integer userId);

    //修改密码
    ServerResponse modifyUserPassword(String oldPssword, String newPassword, Integer userId);


}
