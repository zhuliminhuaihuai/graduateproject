package com.managesystem.service.Impl;

import com.managesystem.common.ServerResponse;
import com.managesystem.dao.UserMapper;
import com.managesystem.service.IUserService;
import com.managesystem.util.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

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

}
