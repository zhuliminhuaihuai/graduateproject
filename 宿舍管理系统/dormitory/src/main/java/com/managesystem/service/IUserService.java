package com.managesystem.service;

import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.User;
import com.managesystem.vo.StudentQueryVo;
import com.managesystem.vo.UserVo;

import java.util.List;

public interface IUserService {

    //登录
    ServerResponse<User> login(String username, String password);

    //用户列表
    LayUiPageResponse<List<User>> getUserList(UserVo userVo, Integer page, Integer limit);

    //根据userCode 找到用户
    ServerResponse findUserByUserCode(String userCode);

    //根据userCode找到用户对应的房间余额
    ServerResponse findUserByUserCodeAndBalance(String userCode);

    //重置密码管理员
    ServerResponse rePasswordManageUser(Integer userId);

    //删除管理员
    ServerResponse manageDelete(Integer userId);

    //管理员信息详情
    ServerResponse manageDetail(Integer userId);

    //管理员修改保存
    ServerResponse manageModify(User user);

    //添加管理员
    ServerResponse manageAdd(User user);

    //根据角色类型找到用户
    ServerResponse findManageByUserRole(Integer userRole);

    //添加学生
    ServerResponse studentAdd(User user);

    //学生列表根据条件查询
    LayUiPageResponse studentList(StudentQueryVo studentQueryVo, Integer page, Integer limit);

    //修改密码
    ServerResponse modifyPassword(String userCode, String oldpassword, String newpassword);

    //未入住且对应的学院学生列表
    LayUiPageResponse checkInStudentList(String userFaculty, String studentSex, Integer page, Integer limit);

    //找到房间里面住的学生
    LayUiPageResponse findBedRoomStudent(Integer bedroomId, Integer page, Integer limit);


}
