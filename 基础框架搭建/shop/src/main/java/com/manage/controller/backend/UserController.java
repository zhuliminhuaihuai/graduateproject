package com.managesystem.controller.backend;
import com.managesystem.common.Const;
import com.managesystem.common.ServerResponse;
import com.managesystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manage/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;


    //用户登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
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
            }else {
                return ServerResponse.createByErrorMessage("不是系统人员,无法登录");
            }
        } else {
            return ServerResponse.createByErrorMessage("用户名或者密码错误");
        }


    }

    @RequestMapping("a")
    @ResponseBody
    public ServerResponse a() {
        return ServerResponse.createBySuccessMessage("hhhhh");
    }



}
