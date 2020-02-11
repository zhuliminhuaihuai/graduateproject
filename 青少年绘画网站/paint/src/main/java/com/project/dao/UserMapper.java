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

    //登陆
    User selectLogin(@Param("username") String username, @Param("md5Password") String md5Password);

    //检测用户名
    int checkUserName(@Param("username") String username);

    //检测手机号
    int checkUserPhone(@Param("mobile") String mobile);

    //修改-检测用户名
    int checkUserNameExSelf(@Param("username") String username,@Param("userId") Integer userId);

    //修改-检测手机号
    int checkUserPhoneExSelf(@Param("mobile") String mobile,@Param("userId") Integer userId);

    //List分页角色列表
    List<User> userList(CommonVo commonVo);

    //检测原密码是否正确
    int checkUserPass(@Param("oPass") String oPass,@Param("userId") Integer userId);

    List<User> userListByROle(@Param("role") int role);

    //List分页角色列表 用来查询对应成员列表
    List<User> projectUserList(CommonVo commonVo);

    //List分页角色列表 用来查询对应研发成员列表
    List<User> projectTechnologyList(@Param("userIds") List<Integer> userIds);

    //根据UserCode删除
    int deleteByUserCode(@Param("userCode") String userCode);

    //根据UserCode查询
    User selectByUserCode(@Param("userCode") String userCode);

    //教师列表根据机构Id
    List<User> selectTeacherList(@Param("branchId") int branchId);

    //查询该机构所有学生的Id和教师的Id
    List<Integer> selectAllTeacherAndStudentIdsByBranchId(@Param("branchId") int branchId);

    //查询
    List<Integer> selectAllStudentIdsByTeacherId(@Param("teacherId") int teacherId);


}