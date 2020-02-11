package com.managesystem.service;

import com.managesystem.common.ServerResponse;

public interface IUserService {

    //登录
    ServerResponse<User> login(String username, String password);

}
