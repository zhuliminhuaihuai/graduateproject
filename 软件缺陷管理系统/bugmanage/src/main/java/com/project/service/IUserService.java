package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.User;
import com.project.vo.CommonVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IUserService {


    //登录验证
    ServerResponse checkLogin(String userName, String password, HttpServletRequest request);
    //分页用户列表
    LayUiPageResponse<List<User>> userList(CommonVo commonVo, int page, int limit );
    //增
    ServerResponse insert(User user);
    //删
    ServerResponse delete(Integer id);
    //改
    ServerResponse edit(User user);
    //查 -根据ID
    ServerResponse get(Integer id);

    //重置密码
    ServerResponse resetPass(Integer id);

    //修改密码
    ServerResponse editPass(Integer userId,String oldPass,String newPass);

}
