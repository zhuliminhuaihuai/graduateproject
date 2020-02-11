package com.managesystem.dao;

import com.managesystem.pojo.User;
import com.managesystem.vo.UserVo;
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

    //验证密码是否正确
    int checkPassword(@Param("userCode") String userCode, @Param("password") String password);

    //修改密码
    int modifyPassword(@Param("userCode") String userCode, @Param("password") String password);

    //用户列表带条件（封装的vo类）
    List<User> getUserList(UserVo userVo);

    //根据角色类型查找用户
    List<User> findUserByRole(@Param("userRole") Integer userRole);

    //重置用户密码
    int userRePassword(@Param("userId") Integer userId);

    //查找出所有的摄影师
    List<User> findAllPhotographer();

    //根据userCode查出用户
    User findUserByUserCode(@Param("userCode") String userCode);


}