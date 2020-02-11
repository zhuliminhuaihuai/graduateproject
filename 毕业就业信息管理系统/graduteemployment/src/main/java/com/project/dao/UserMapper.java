package com.project.dao;

import com.project.pojo.User;
import com.project.vo.CommonVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //用户列表
    List<User> userList(CommonVo commonVo);
    //登陆时检测用户名/手机
    int checkUserName1(@Param("userName") String userName);

    //检测用户名
    int checkUserName(@Param("userName") String userName);

    //检测手机号
    int checkUserPhone(@Param("mobile") String mobile);

    //修改-检测用户名
    int checkUserNameExSelf(@Param("userName") String userName,@Param("userId") Integer userId);

    //修改-检测手机号
    int checkUserPhoneExSelf(@Param("mobile") String mobile,@Param("userId") Integer userId);

    //登录检测-账户密码
    User checkUser(@Param("userName") String userName,@Param("password") String password);

    //检测原密码是否正确
    int checkUserPass(@Param("oPass") String oPass,@Param("userId") Integer userId);

    User selectByUserCode(@Param("userCode") String userCode);
}