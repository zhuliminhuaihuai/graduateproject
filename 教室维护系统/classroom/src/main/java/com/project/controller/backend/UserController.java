package com.project.controller.backend;

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

@RequestMapping("/manage/user/")
@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    //用户登录
    @RequestMapping("login")
    @ResponseBody
    public ServerResponse login(HttpServletRequest request, String userName, String password) {
        return iUserService.login(request, userName, password);
    }

    //用户列表包含查询
    @RequestMapping("getUserList")
    @ResponseBody
    public LayUiPageResponse getUserList(Integer page, Integer limit, UserQueryVo userQueryVo) {
        return iUserService.getUserList(page, limit, userQueryVo);
    }

    //添加管理员
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
    @RequestMapping("reSetAgainPassword")
    @ResponseBody
    public ServerResponse reSetAgainPassword(Integer userId) {
        return iUserService.reSetAgainPassword(userId);
    }

    //删除用户
    @RequestMapping("deleteUserByUserId")
    @ResponseBody
    public ServerResponse deleteUser(Integer userId) {
        return iUserService.deleteUserByUserId(userId);
    }

    //修改密码
    @RequestMapping("modifyUserPassword")
    @ResponseBody
    public ServerResponse modifyUserPassword(String oldPssword, String newPassword, Integer userId) {
        return iUserService.modifyUserPassword(oldPssword, newPassword, userId);
    }
    /**********************************************/

    //跳转后台首页
    @RequestMapping("jumpBackStage.html")
    public String jumpBackStageHtml() {
        return "backstage";
    }

    //打开后台主界面
    @RequestMapping("openMain.html")
    public String openMainHtml() {
        return "main";
    }

    //跳转用户管理
    @RequestMapping("jumpUserList.html")
    public String jumpUserListHtml() {
        return "user/user_list";
    }

    //跳转添加新用户界面
    @RequestMapping("openAddUser.html")
    public String openAddUserHtml() {
        return "user/user_add";
    }
    //打开用户详情
    @RequestMapping("openUserDetail.html")
    public String openUserDetailHtml() {
        return "user/user_detail";
    }

    //跳转登录界面
    @RequestMapping("jumpLogin.html")
    public String jumpLoginHtml() {
        return "login";
    }

}
