package com.manage.dao;

import com.manage.pojo.User;
import com.manage.vo.UserVo;
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

    //用户列表
    List<User> getUserList(UserVo userVo);

    //批量删除用户
    int deleteSomeUser(@Param("idList") List<Integer> idList);

    //获取所有客户
    int getUserCountTotal();

    //获取今日注册人数
    int getTodayUserCount();

    //获取昨日注册人数
    int getYestodayUserCount();

    //获取本周注册人数
    int getWeekUserCount();

    //获取本月注册人数
    int getMonthUserCount();


}