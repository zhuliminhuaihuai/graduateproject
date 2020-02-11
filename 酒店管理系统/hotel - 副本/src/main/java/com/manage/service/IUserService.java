package com.manage.service;

import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.pojo.User;

public interface IUserService {

    //登录
    ServerResponse<User> login(String username, String password);

    //找到所有空闲房源的封面照
    ServerResponse findAllFreedomRoom(String roomTitle);

    //用户入住
    ServerResponse addUser(User user, Integer roomId);

    //客户列表
    LayUiPageResponse userList(User user, Integer page, Integer limit);

    //客户预约房变成入住房
    ServerResponse updateRoomStateOneToTwo(Integer userId, String roomCode);

    //客户离房
    ServerResponse updateRoomStateTwoToThree(Integer userId, String roomCode);

    //删除客户的客房记录
    ServerResponse deleteUser(Integer userId);




}
