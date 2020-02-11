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

    //所有用户人员
    List<User> getAllUserList(UserQueryVo userQueryVo);

    //所有教师
    List<User> getAllTercherList(UserQueryVo userQueryVo);

    //所有学生
    List<User> getAllStudentList(UserQueryVo userQueryVo);

    //重置密码
    int reSetPassword(@Param("userId") Integer userId);

    //根据课程来模糊查找老师
    List<User> findTeacherByCoursesTitle(@Param("coursesTitle") String coursesTitle);

    //根据code找到该用户
    User findUserByUserCode(@Param("userCode") String userCode);

    List<User> getAllTercher();


}