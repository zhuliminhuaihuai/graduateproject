package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.User;
import com.project.vo.UserQueryVo;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {

    //在线报名
    ServerResponse onlineApplication(User user);

    //用户登录
    ServerResponse login(HttpServletRequest request, String userName, String password);

    //所有用户人员
    LayUiPageResponse getAllUserList(Integer page, Integer limit, UserQueryVo userQueryVo);

    //所有教师
    LayUiPageResponse getAllTercherList(Integer page, Integer limit, UserQueryVo userQueryVo);

    //所有学生
    LayUiPageResponse getAllStudentList(Integer page, Integer limit, UserQueryVo userQueryVo);

    //添加用户
    ServerResponse addUser(User user);

    //用户详情
    ServerResponse detailUser(Integer userId);

    //用户保存
    ServerResponse saveUser(User user);

    //重置密码
    ServerResponse reSetPassword(Integer userId);

    //删除用户
    ServerResponse deleteUser(Integer userId, Integer userRole);

    //根据课程来模糊查找老师
    ServerResponse findTeacherByCoursesTitle(String coursesTitle);

    // 不分页找到所有教师
    ServerResponse getAllTercher();
}
