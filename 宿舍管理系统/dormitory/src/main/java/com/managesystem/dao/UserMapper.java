package com.managesystem.dao;

import com.managesystem.pojo.User;
import com.managesystem.vo.StudentQueryVo;
import com.managesystem.vo.StudentVo;
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

    //用户列表带条件（封装的vo类）
    List<User> getUserList(UserVo userVo);

    //验证用户名是否存在
    int checkUserName(@Param("userName") String userName);

    //登录
    User login(@Param("userName") String userName, @Param("password") String password);

    //根据userCode找到user
    User findUserByUserCode(@Param("userCode") String userCode);

    //重置管理员登录密码
    int rePasswordManageUser(@Param("userId") Integer userId);

    List<User> findManageByUserRole(@Param("userRole") Integer userRole);

    //学生列表根据条件查询
    List<User> getStudentList(StudentQueryVo studentQueryVo);

    //验证密码是否正确
    int checkPassword(@Param("userCode") String userCode, @Param("password") String password);

    //修改密码
    int modifyPassword(@Param("userCode") String userCode, @Param("password") String password);

    //查询学院学生
    List<User> finduserFacultyStudent(@Param("userFaculty") String userFaculty, @Param("studentSex") String studentSex);

    //批量更新学生入住房间信息
    int updateStudentCheckInRoom(@Param("idList") List<Integer> idList, @Param("bedRoomCode") String bedRoomCode);

    //根据房间code找到学生
    List<User> findStudentByBedRoomCode(@Param("bedRoomCode") String bedRoomCode);

}