package com.project.controller.backend;

import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.User;
import com.project.service.IUserService;
import com.project.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manage/user/")
public class UserController {

    @Autowired
    private IUserService iUsertService;



    //登录
    @RequestMapping(value="loginUser")
    @ResponseBody
    public ServerResponse loginUser(HttpSession session,String userName,String password){
        ServerResponse<User> response = iUsertService.checkLogin(userName, password);
        if (response.isSuccess()) {
            User user = response.getData();
            if (user == null) {
                return ServerResponse.createByErrorMessage("用户名或者密码错误");
            }
            if (user.getRole() == Const.Role.ROLE_ADMIN) {
                session.setAttribute(Const.ManagerToken.SESSION, user);
                session.setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
                return ServerResponse.createBySuccessMessage("登录成功");
            } else if (user.getRole() == Const.Role.ROLE_Student) {
                session.setAttribute(Const.ManagerToken.SESSION, user);
                session.setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
                return ServerResponse.createBySuccessMessage("登录成功");
            } else if (user.getRole() == Const.Role.ROLE_ENTERPRISE) {
                session.setAttribute(Const.ManagerToken.SESSION, user);
                session.setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
                return ServerResponse.createBySuccessMessage("登录成功");
            }else {
                return ServerResponse.createByErrorMessage("角色有误,无法登录");
            }
        } else {
            return ServerResponse.createByErrorMessage("登录账户或密码错误");
        }
    }

    //注册用户/生成用户
    @RequestMapping(value="registerUser")
    @ResponseBody
    public ServerResponse registerUser(User user){
        return iUsertService.insert(user);
    }
    //登录成功-进入主页
    @RequestMapping(value = "toIndex")
    public String toIndex(){
        return "index";
    }
    @RequestMapping(value = "main")
    public String main(){
        return "main";
    }
    //登录成功-学生首页
    @RequestMapping(value = "studentMain")
    public String studentMain(){
        return "student_main";
    }
    //主页-推出到登录
    @RequestMapping(value = "logout")
    public String logout(){
        return "login";
    }
    //进入学生用户管理页面
    @RequestMapping("student_list")
    public String student_list(){
        return "/user/student_list";
    }
    //进入企业用户据管理列表页面
    @RequestMapping("enter_list")
      public String enter_list(){
        return "/user/enter_list";
    }
    //请求学生/企业列表
    @RequestMapping(value="userList")
    @ResponseBody
    public LayUiPageResponse<List<User>> userList(CommonVo commonVo, int page, int limit){
        return iUsertService.userList(commonVo,page,limit);
    }

    //进入添加用户/企业界面
    @RequestMapping(value = "user_add")
    public String user_add(){
        return "/user/user_add";
    }
    //管理员-生成用户/企业
    @RequestMapping(value="addUser")
    @ResponseBody
    public ServerResponse addUser(User user, String birthdays)throws Exception{
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        if(birthdays.equals("")){
            user.setBirthday(simple.parse("1998-06-01"));
        }else {
            user.setBirthday(simple.parse(birthdays));
        }
        return iUsertService.insert(user);
    }

    //进入修改用户/企业界面
    @RequestMapping(value = "user_edit")
    public String user_edit(){
        return "/user/user_edit";
    }
    //获取用户个人信息
    @RequestMapping(value="getUserInfo")
    @ResponseBody
    public ServerResponse getUserInfo(Integer id){
        return iUsertService.get(id);
    }
    //获取用户个人信息根据userCode
    @RequestMapping(value="getUserByUserCode")
    @ResponseBody
    public ServerResponse getUserByUserCode(String userCode){
        return iUsertService.getUserByUserCode(userCode);
    }
    //管理员-修改用户/企业
    @RequestMapping(value="editUser")
    @ResponseBody
    public ServerResponse editUser(User user,String birthdays)throws Exception{
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(simple.parse(birthdays));
        return iUsertService.edit(user);
    }

    //管理员删除用户
    @RequestMapping(value="deleteUser")
    @ResponseBody
    public ServerResponse deleteUser(Integer id){
        return iUsertService.delete(id);
    }

    //管理员-重置用户密码
    @RequestMapping(value="resetPass")
    @ResponseBody
    public ServerResponse resetPass(Integer id){
        return iUsertService.resetPass(id);
    }


    //进入右上角个人角色信息
    @RequestMapping("index_user_info")
    public String index_user_info(){
        return "/user/index_user_info";
    }
    //进入右上角修改密码界面
    @RequestMapping("user_modify_password")
    public String user_modify_password(){
        return "/user/user_modify_password";
    }
    //修改密码用户
    @RequestMapping(value="editPss")
    @ResponseBody
    public ServerResponse deleteUser(Integer userId,String oldPass,String newPass){
        return iUsertService.editPass(userId,oldPass,newPass);
    }


}

