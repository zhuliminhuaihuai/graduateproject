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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manage/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;



    //登录
    @RequestMapping(value="loginUser")
    @ResponseBody
    public ServerResponse loginUser(String userName, String password, HttpServletRequest request){
      return iUserService.checkLogin(userName,password,request);
    }

    //注册用户/生成用户
    @RequestMapping(value="registerUser")
    @ResponseBody
    public ServerResponse registerUser(User user){
        return iUserService.insert(user);
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

    //主页-推出到登录
    @RequestMapping(value = "logout")
    public String logout(HttpSession session){
        session.removeAttribute(Const.ManagerToken.SESSION);//退出session
        return "login";
    }
    @RequestMapping(value = "user_list")
    public String user_list(){
        return "/user/user_list";
    }
    //请求用户列表
    @RequestMapping(value="userList")
    @ResponseBody
    public LayUiPageResponse<List<User>> userList(CommonVo commonVo, int page, int limit){
        return iUserService.userList(commonVo,page,limit);
    }

    //进入添加用户
    @RequestMapping(value = "user_add")
    public String user_add(){
        return "/user/user_add";
    }
    //管理员-生成用户
    @RequestMapping(value="addUser")
    @ResponseBody
    public ServerResponse addUser(User user, String birthdays)throws Exception{
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        if(birthdays.equals("")){
            user.setBirthday(simple.parse("1998-06-01"));
        }else {
            user.setBirthday(simple.parse(birthdays));
        }
        return iUserService.insert(user);
    }

    //进入修改用户
    @RequestMapping(value = "user_edit")
    public String user_edit(){
        return "/user/user_edit";
    }
    //获取用户个人信息
    @RequestMapping(value="getUserInfo")
    @ResponseBody
    public ServerResponse getUserInfo(Integer id){
        return iUserService.get(id);
    }
   /* //获取用户个人信息根据userCode
    @RequestMapping(value="getUserByUserCode")
    @ResponseBody
    public ServerResponse getUserByUserCode(String userCode){
        return iUserService.getUserByUserCode(userCode);
    }*/
    //管理员-修改用户
    @RequestMapping(value="editUser")
    @ResponseBody
    public ServerResponse editUser(User user,String birthdays)throws Exception{
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(simple.parse(birthdays));
        return iUserService.edit(user);
    }

    //删除用户
    @RequestMapping(value="deleteUser")
    @ResponseBody
    public ServerResponse deleteUser(Integer id){
        return iUserService.delete(id);
    }


    //管理员-重置用户密码
    @RequestMapping(value="resetPass")
    @ResponseBody
    public ServerResponse resetPass(Integer id){
        return iUserService.resetPass(id);
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
    @RequestMapping(value="editPass")
    @ResponseBody
    public ServerResponse editPass(Integer userId,String oldPass,String newPass){
        return iUserService.editPass(userId,oldPass,newPass);
    }


}

