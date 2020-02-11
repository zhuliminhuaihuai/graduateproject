package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.CoursesMapper;
import com.project.dao.TimeTableMapper;
import com.project.dao.UserMapper;
import com.project.pojo.User;
import com.project.service.IUserService;
import com.project.util.MD5Util;
import com.project.util.MD5Utils;
import com.project.util.PublicUtil;
import com.project.vo.UserQueryVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CoursesMapper coursesMapper;

    @Autowired
    private TimeTableMapper timeTableMapper;

    //在线报名
    public ServerResponse onlineApplication(User user) {

        int checkCount = userMapper.checkUserName(user.getUserName());
        if (checkCount > 0) {
            return ServerResponse.createByErrorMessage("该用户名已被注册!");
        }
        user.setUserPassword(MD5Utils.MD5Encode(user.getUserPassword(),"UTF-8"));
        user.setUserCode(PublicUtil.setCode("S"));
        user.setUserRole(Const.Role.ROLE_STUDENT);
        user.setUserCreateTime(new Date());
        int count = userMapper.insertSelective(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("报名成功!");
        } else {
            return ServerResponse.createByErrorMessage("报名失败!");
        }
    }
    //用户登录
    public ServerResponse login(HttpServletRequest request, String userName, String password) {

        int userCount = userMapper.checkUserName(userName);
        if (userCount == 0) {
            return ServerResponse.createByErrorMessage("该用户不存在！");
        }
        String passwordMD5 = MD5Utils.MD5Encode(password, "UTF-8");

        User user = userMapper.login(userName, passwordMD5);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误！");
        }
        user.setUserPassword(StringUtils.EMPTY);
        request.getSession().setAttribute(Const.ManagerToken.SESSION,user);//存储用户session
        request.getSession().setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
        return ServerResponse.createBySuccess("登录成功！", user);
    }
    //所有用户人员
    public LayUiPageResponse getAllUserList(Integer page, Integer limit, UserQueryVo userQueryVo) {

        PageHelper.startPage(page, limit);
        List<User> userList = userMapper.getAllUserList(userQueryVo);
        if (userList.size() > 0) {
            PageInfo pageInfo = new PageInfo(userList);
            return LayUiPageResponse.createBySuccess(userList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无人员");
        }
    }
    //所有教师
    public LayUiPageResponse getAllTercherList(Integer page, Integer limit, UserQueryVo userQueryVo) {
        PageHelper.startPage(page, limit);
        List<User> userList = userMapper.getAllTercherList(userQueryVo);
        if (userList.size() > 0) {
            PageInfo pageInfo = new PageInfo(userList);
            return LayUiPageResponse.createBySuccess(userList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无人员");
        }
    }
    //所有学生
    public LayUiPageResponse getAllStudentList(Integer page, Integer limit, UserQueryVo userQueryVo) {
        PageHelper.startPage(page, limit);
        List<User> userList = userMapper.getAllStudentList(userQueryVo);
        if (userList.size() > 0) {
            PageInfo pageInfo = new PageInfo(userList);
            return LayUiPageResponse.createBySuccess(userList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无人员");
        }
    }
    //添加用户
    public ServerResponse addUser(User user) {
        int checkCount = userMapper.checkUserName(user.getUserName());
        if (checkCount > 0) {
            return ServerResponse.createByErrorMessage("该用户名已被注册!");
        }
        if (user.getUserRole() == 2) {
            int x = user.getCoursesTitle().indexOf("[");
            int y = user.getCoursesTitle().indexOf("]");
            String coursesTitleString = user.getCoursesTitle().substring(x + 1, y);
            user.setCoursesTitle(coursesTitleString);
        }
        user.setUserPassword(MD5Utils.MD5Encode(user.getUserPassword(),"UTF-8"));
        user.setUserCode(PublicUtil.setCode("S"));
        user.setUserCreateTime(new Date());
        int count = userMapper.insertSelective(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("添加成功!");
        } else {
            return ServerResponse.createByErrorMessage("添加失败!");
        }
    }
    //用户详情
    public ServerResponse detailUser(Integer userId) {

        User user = userMapper.selectByPrimaryKey(userId);
        if (user != null) {
            return ServerResponse.createBySuccess("找到用户", user);
        } else {
            return ServerResponse.createByErrorMessage("未找到用户");
        }
    }
    //用户保存
    public ServerResponse saveUser(User user) {

        if (user.getUserRole() == 2) {
            int x = user.getCoursesTitle().indexOf("[");
            int y = user.getCoursesTitle().indexOf("]");
            String coursesTitleString = user.getCoursesTitle().substring(x + 1, y);
            user.setCoursesTitle(coursesTitleString);
        }
        int count = userMapper.updateByPrimaryKeySelective(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("保存成功！");
        } else {
            return ServerResponse.createByErrorMessage("保存失败！");
        }
    }
    //重置密码
    public ServerResponse reSetPassword(Integer userId) {

        int count = userMapper.reSetPassword(userId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("重置成功");
        } else {
            return ServerResponse.createByErrorMessage("重置失败");
        }
    }
    //删除用户
    public ServerResponse deleteUser(Integer userId, Integer userRole) {

        int count = 0;
        User user = userMapper.selectByPrimaryKey(userId);
        String userCode = user.getUserCode();
        if (userRole == 2) {
            coursesMapper.deleteCoursesByUserCode(userCode);
        }
        //删除课表里头不管是学生还是教师都是同样得删除
        timeTableMapper.deleteTimeTableByTercherCode(userCode);
        count = userMapper.deleteByPrimaryKey(userId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }
    //根据课程来模糊查找老师
    public ServerResponse findTeacherByCoursesTitle(String coursesTitle) {

        List<User> userList = userMapper.findTeacherByCoursesTitle(coursesTitle);
        if (userList.size() > 0) {
            return ServerResponse.createBySuccess("找到老师", userList);
        } else {
            return ServerResponse.createByErrorMessage("暂无老师");
        }
    }
}
