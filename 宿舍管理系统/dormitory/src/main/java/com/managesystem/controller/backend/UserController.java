package com.managesystem.controller.backend;

import com.managesystem.common.Const;
import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.User;
import com.managesystem.service.IUserService;
import com.managesystem.vo.StudentQueryVo;
import com.managesystem.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/manage/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;


    //用户登录
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse login(HttpServletRequest request, String username, String password) {
        System.out.println("进入验证用户名与密码后台---");
        HttpSession session = request.getSession();
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            User user = response.getData();
            if (user == null) {
                return ServerResponse.createByErrorMessage("用户名或者密码错误");
            }
            if (user.getUserRole() == Const.Role.ROLE_ADMIN) {
                session.setAttribute(Const.ManagerToken.SESSION, user);
                session.setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
                System.out.println("连接websocket---------------");
                return ServerResponse.createBySuccessMessage("登陆成功");
            } else if (user.getUserRole() == Const.Role.ROLE_CUSTOMER) {
                session.setAttribute(Const.ManagerToken.SESSION, user);
                session.setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
                System.out.println("连接websocket---------------");
                return ServerResponse.createBySuccessMessage("登陆成功");
            } else if (user.getUserRole() == Const.Role.ROLE_PHOTOGRAPHER) {
                session.setAttribute(Const.ManagerToken.SESSION, user);
                session.setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
                System.out.println("连接websocket---------------");
                return ServerResponse.createBySuccessMessage("登陆成功");
            } else {
                return ServerResponse.createByErrorMessage("不是系统人员,无法登录");
            }
        } else {
            return ServerResponse.createByErrorMessage("用户名或者密码错误");
        }


    }
    //用户列表
    @RequestMapping("getUserList")
    @ResponseBody
    public LayUiPageResponse<List<User>> getUserList(UserVo userVo, Integer page, Integer limit) {
        return iUserService.getUserList(userVo, page, limit);
    }

    //根据userCode 找到用户
    @RequestMapping("findUserByUserCode")
    @ResponseBody
    public ServerResponse findUserByUserCode(String userCode) {
        return iUserService.findUserByUserCode(userCode);
    }

    //根据userCode找到用户对应的房间余额
    @RequestMapping("findUserByUserCodeAndBalance")
    @ResponseBody
    public ServerResponse findUserByUserCodeAndBalance(String userCode) {
        return iUserService.findUserByUserCodeAndBalance(userCode);
    }
    //重置密码管理员
    @RequestMapping("rePasswordManageUser")
    @ResponseBody
    public ServerResponse rePasswordManageUser(Integer userId) {
        return iUserService.rePasswordManageUser(userId);
    }

    //删除管理员
    @RequestMapping("manageDelete")
    @ResponseBody
    public ServerResponse manageDelete(Integer userId) {
        return iUserService.manageDelete(userId);
    }

    //管理员信息详情
    @RequestMapping("manageDetail")
    @ResponseBody
    public ServerResponse manageDetail(Integer userId) {
        return iUserService.manageDetail(userId);
    }

    //管理员修改保存
    @RequestMapping("manageModify")
    @ResponseBody
    public ServerResponse manageModify(User user) {
        return iUserService.manageModify(user);
    }

    //添加管理员
    @RequestMapping("manageAdd")
    @ResponseBody
    public ServerResponse manageAdd(User user) {
        return iUserService.manageAdd(user);
    }

    //根据角色类型找到用户
    @RequestMapping("findManageByUserRole")
    @ResponseBody
    public ServerResponse findManageByUserRole(Integer userRole) {
        return iUserService.findManageByUserRole(userRole);
    }

    //添加学生
    @RequestMapping("studentAdd")
    @ResponseBody
    public ServerResponse studentAdd(User user) {
        return iUserService.studentAdd(user);
    }

    //学生列表根据条件查询
    @RequestMapping("studentList")
    @ResponseBody
    public LayUiPageResponse studentList(StudentQueryVo studentQueryVo, Integer page, Integer limit) {
        return iUserService.studentList(studentQueryVo, page, limit);
    }

    //未入住且对应的学院学生列表
    @RequestMapping("checkInStudentList")
    @ResponseBody
    public LayUiPageResponse checkInStudentList(String userFaculty,String studentSex, Integer page, Integer limit) {
        return iUserService.checkInStudentList(userFaculty,studentSex, page, limit);
    }
    //修改密码
    @RequestMapping("modifyPassword")
    @ResponseBody
    public ServerResponse modifyPassword(HttpServletRequest request, String oldpassword, String newpassword) {
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        String userCode = user.getUserCode();
        return iUserService.modifyPassword(userCode, oldpassword, newpassword);
    }

    //找到房间里面住的学生
    @RequestMapping("findBedRoomStudent")
    @ResponseBody
    public LayUiPageResponse findBedRoomStudent(Integer bedroomId, Integer page, Integer limit) {
        return iUserService.findBedRoomStudent(bedroomId, page, limit);
    }
    /************************************************************************/

    //跳转后台首页
    @RequestMapping("jumpIndex.html")
    public String jumpIndexHtml() {
        return "index";
    }

    //跳转后台右侧界面
    @RequestMapping("jumpMain.html")
    public String jumpMainHtml() {
        return "main1";
    }

    //跳转打开管理员管理页面
    @RequestMapping("jumpUserManage.html")
    public String jumpUserManageHtml() {
        return "user/user_manage";
    }

    //跳转打开修改管理员界面
    @RequestMapping("jumpManageModify.html")
    public String jumpManageModifyHtml() {
        return "user/manage_modify";
    }

    //跳转打开添加新管理员界面
    @RequestMapping("jumpManageAdd.html")
    public String jumpManageAddHtml() {
        return "user/manage_add";
    }

    //跳转打开添加新学生界面
    @RequestMapping("jumpStudentAdd.html")
    public String jumpStudentAddHtml() {
        return "user/student_add";
    }

    //跳转打开学生列表
    @RequestMapping("jumpStudentList.html")
    public String jumpStudentListHtml() {
        return "user/student_list";
    }

    //用户退出到登录界面
    @RequestMapping("jumpUserLogin.html")
    public String jumpUserLoginHtml() {
        return "login";
    }

    //打开用户修改密码
    @RequestMapping("jumpUserModifyPassword.html")
    public String jumpUserModifyPasswordHtml() {
        return "user/user_modify_password";
    }

    //跳转用户点开房间详情
    @RequestMapping("jumpStudentDetailBedRoom.html")
    public String jumpStudentDetailBedRoomHtml() {
        return "user/student_detail_bedroom";
    }


}
