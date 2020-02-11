package com.project.controller.backend;


import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.User;
import com.project.service.IUserService;
import com.project.vo.UserQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/manage/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    //在线报名
    @RequestMapping("onlineApplication")
    @ResponseBody
    public ServerResponse onlineApplication(User user) {
        return iUserService.onlineApplication(user);
    }

    //用户登录
    @RequestMapping("login")
    @ResponseBody
    public ServerResponse login(HttpServletRequest request, String userName, String password) {
        return iUserService.login(request, userName, password);
    }

    //所有用户人员
    @RequestMapping("getAllUserList")
    @ResponseBody
    public LayUiPageResponse getAllUserList(Integer page, Integer limit, UserQueryVo userQueryVo) {
        return iUserService.getAllUserList(page, limit, userQueryVo);
    }

    //所有教师
    @RequestMapping("getAllTercherList")
    @ResponseBody
    public LayUiPageResponse getAllTercherList(Integer page, Integer limit, UserQueryVo userQueryVo) {
        return iUserService.getAllTercherList(page, limit, userQueryVo);
    }

    //所有学生
    @RequestMapping("getAllStudentList")
    @ResponseBody
    public LayUiPageResponse getAllStudentList(Integer page, Integer limit, UserQueryVo userQueryVo) {
        return iUserService.getAllStudentList(page, limit, userQueryVo);
    }
    //添加用户
    @RequestMapping("addUser")
    @ResponseBody
    public ServerResponse addUser(User user) {
        return iUserService.addUser(user);
    }

    //用户详情
    @RequestMapping("detailUser")
    @ResponseBody
    public ServerResponse detailUser(Integer userId) {
        return iUserService.detailUser(userId);
    }

    //用户保存
    @RequestMapping("saveUser")
    @ResponseBody
    public ServerResponse saveUser(User user) {
        return iUserService.saveUser(user);
    }

    //重置密码
    @RequestMapping("reSetPassword")
    @ResponseBody
    public ServerResponse reSetPassword(Integer userId) {
        return iUserService.reSetPassword(userId);
    }

    //删除用户
    @RequestMapping("deleteUser")
    @ResponseBody
    public ServerResponse deleteUser(Integer userId, Integer userRole) {
        return iUserService.deleteUser(userId, userRole);
    }

    //根据课程来模糊查找老师
    @RequestMapping("findTeacherByCoursesTitle")
    @ResponseBody
    public ServerResponse findTeacherByCoursesTitle(String coursesTitle) {
        return iUserService.findTeacherByCoursesTitle(coursesTitle);
    }
    /*************************************/
    //跳转首页
    @RequestMapping("jumpHomePage.html")
    public String jumpHomePageHtml() {
        return "homePage";
    }

    //跳转已经登录的首页
    @RequestMapping("jumpHomePage1.html")
    public String jumpHomePage1Html() {
        return "homePage1";
    }

    //跳转视频简介
    @RequestMapping("jumpVideoIntroduce.html")
    public String jumpVideoIntroduceHtml() {
        return "videoIntroduce";
    }

    //跳转已经登录的视频简介
    @RequestMapping("jumpVideoIntroduce1.html")
    public String jumpVideoIntroduce1Html() {
        return "videoIntroduce1";
    }
    //跳转在线报名
    @RequestMapping("jumpOnlineApplication.html")
    public String jumpOnlineApplicationHtml() {
        return "onlineApplication";
    }

    //跳转已经登录的在线报名
    @RequestMapping("jumpOnlineApplication1.html")
    public String jumpOnlineApplication1Html() {
        return "onlineApplication1";
    }
    //跳转在线选课
    @RequestMapping("jumpOnlineCourse.html")
    public String jumpOnlineCourseHtml() {
        return "onlineCourse";
    }

    //跳转已经登录的在线选课
    @RequestMapping("jumpOnlineCourses1.html")
    public String jumpOnlineCourses1Html() {
        return "onlineCourses1";
    }
    //退出默认都退到未登录的首页
    @RequestMapping("jumpNoLoginHomePage.html")
    public String jumpNoLoginHomePageHtml(HttpServletRequest request) {
        request.getSession().removeAttribute(Const.ManagerToken.SESSION);//退出session
        return "homePage";
    }

    //跳转后台首页
    @RequestMapping("jumpBackstage.html")
    public String jumpBackstageHtml() {
        return "backstage";
    }

    //后台主界面
    @RequestMapping("openMain.html")
    public String openMainHtml() {
        return "main";
    }

    //跳转打开用户管理列表
    @RequestMapping("jumpUserAllList.html")
    public String jumpUserAllListHtml() {
        return "user/user_all_list";
    }

    //跳转打开添加用户
    @RequestMapping("jumpOpenUserAdd.html")
    public String jumpOpenUserAddHtml() {
        return "user/user_add";
    }

    //打开用户详情
    @RequestMapping("openUserDetail.html")
    public String openUserDetailHtml() {
        return "user/user_detail";
    }

    //跳转教师列表
    @RequestMapping("jumpUserTercherList.html")
    public String jumpUserTercherListHtml() {
        return "user/user_tercher_list";
    }

    //跳转学生列表
    @RequestMapping("jumpUserStudentList.html")
    public String jumpUserStudentListHtml() {
        return "user/user_student_list";
    }


}
