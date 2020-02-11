package com.managesystem.dao;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //验证用户名是否存在
    int checkUserName(@Param("userName") String userName);

    //登录
    User login(@Param("userName") String userName, @Param("password") String password);

}