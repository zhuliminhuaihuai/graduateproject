package com.project.dao;

import com.project.pojo.User;
import com.project.vo.UserQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //检查用户名
    int checkUserName(@Param("userName") String userName);

    //登录
    User login(@Param("userName") String userName, @Param("password") String password);

    //用户列表包含查询
    List<User> getUserListByCondition(UserQueryVo userQueryVo);

    //重置密码
    int reSetAgainPassword(@Param("userId") Integer userId);

    //验证密码是否正确
    int checkPassword(@Param("userId") Integer userId, @Param("userPassword") String userPassword);

    //更改密码
    int updatePassword(@Param("userId") Integer userId, @Param("userPassword") String userPassword);



}