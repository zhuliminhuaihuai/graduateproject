package com.manage.dao;

import com.manage.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    //根据userCode找到user
    User findUserByUserCode(@Param("userCode") String userCode);

    //客户列表根据条件 查询出不同用户
    List<User> getUserListByCondition(User user);




}