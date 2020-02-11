package com.manage.controller.backend;

import com.manage.common.Const;
import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.pojo.User;
import com.manage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manage/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    //用户登录
    @RequestMapping("login")
    @ResponseBody
    public ServerResponse login(HttpServletRequest request, String userName, String userPassword) {
        System.out.println("进入验证用户名与密码后台---");
        HttpSession session = request.getSession();
        ServerResponse<User> response = iUserService.login(userName, userPassword);
        if (response.isSuccess()) {
            User user = response.getData();
            if (user == null) {
                return ServerResponse.createByErrorMessage("用户名或者密码错误");
            }
            if (user.getUserRole() == Const.Role.ROLE_ADMIN) {
                session.setAttribute(Const.ManagerToken.SESSION, user);
                session.setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
                return ServerResponse.createBySuccess("登陆成功", user);
            } else if (user.getUserRole() == Const.Role.ROLE_CUSTOMER) {
                session.setAttribute(Const.ManagerToken.SESSION, user);
                session.setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
                return ServerResponse.createBySuccess("登陆成功", user);

            } else if (user.getUserRole() == Const.Role.ROLE_PHOTOGRAPHER) {
                session.setAttribute(Const.ManagerToken.SESSION, user);
                session.setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
                return ServerResponse.createBySuccess("登陆成功", user);
            } else {
                return ServerResponse.createByErrorMessage("不是系统人员,无法登录");
            }
        } else {
            return ServerResponse.createByErrorMessage("用户名或者密码错误");
        }
    }

    //找到所有空闲房源的封面照
    @RequestMapping("findAllFreedomRoom")
    @ResponseBody
    public ServerResponse findAllFreedomRoom(String roomTitle) {
        return iUserService.findAllFreedomRoom(roomTitle);
    }

    //用户入住
    @RequestMapping("addUser")
    @ResponseBody
    public ServerResponse addUser(User user, Integer roomId) {
        return iUserService.addUser(user, roomId);
    }

    //客户列表
    @RequestMapping("userList")
    @ResponseBody
    public LayUiPageResponse userList(User user, Integer page, Integer limit) {
        return iUserService.userList(user, page, limit);
    }

    //客户预约房变成入住房
    @RequestMapping("updateRoomStateOneToTwo")
    @ResponseBody
    public ServerResponse updateRoomStateOneToTwo(Integer userId, String roomCode) {
        return iUserService.updateRoomStateOneToTwo(userId, roomCode);
    }

    //客户离房
    @RequestMapping("updateRoomStateTwoToThree")
    @ResponseBody
    public ServerResponse updateRoomStateTwoToThree(Integer userId, String roomCode) {
        return iUserService.updateRoomStateTwoToThree(userId, roomCode);
    }

    //删除客户的客房记录
    @RequestMapping("deleteUser")
    @ResponseBody
    public ServerResponse deleteUser(Integer userId) {
        return iUserService.deleteUser(userId);
    }
    /***************************************/
    //跳转用户登录界面
    @RequestMapping("jumpUserLogin.html")
    public String jumpUserLoginHtml() {
        return "user/user_login";
    }


    //跳转后台首页
    @RequestMapping("jumpUserBackStageIndex.html")
    public String jumpUserBackStageIndexHtml() {
        return "user/user_backstage_index";
    }

    //跳转客户入住
    @RequestMapping("jumpUserCheckInRoom.html")
    public String jumpUserCheckInRoomHtml() {
        return "user/user_check_in_room";
    }

    //跳转用户查看房间详情
    @RequestMapping("jumpUserSeeRoomMessage.html")
    public String jumpUserSeeRoomMessageHtml() {
        return "user/user_see_room_message";
    }

    //跳转用户确认入住界面
    @RequestMapping("jumpUserCheckInRoomConfirm.html")
    public String jumpUserCheckInRoomConfirmHtml() {
        return "user/user_check_in_room_confirm";
    }

    //跳转客户列表界面
    @RequestMapping("jumpUserList.html")
    public String jumpUserListHtml() {
        return "user/user_list";
    }


}
