package com.manage.controller.backend;

import com.manage.common.Const;
import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.pojo.User;
import com.manage.service.IUserService;
import com.manage.vo.UserVo;
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
            }else {
                return ServerResponse.createByErrorMessage("不是系统人员,无法登录");
            }
        } else {
            return ServerResponse.createByErrorMessage("用户名或者密码错误");
        }
    }

    //用户注册
    @RequestMapping("register")
    @ResponseBody
    public ServerResponse register(String userName, String userPassword, String userPhone) {
        return iUserService.register(userName, userPassword, userPhone);
    }

    //用户列表
    @RequestMapping("userList")
    @ResponseBody
    public LayUiPageResponse userList(UserVo userVo, Integer page, Integer limit) {
        return iUserService.userList(userVo, page, limit);
    }

    //添加用户
    @RequestMapping("addUser")
    @ResponseBody
    public ServerResponse addUser(User user) {
        return iUserService.addUser(user);
    }

    //删除用户
    @RequestMapping("deleteUser")
    @ResponseBody
    public ServerResponse deleteUser(Integer userId) {
        return iUserService.deleteUser(userId);
    }

    //批量删除用户
    @RequestMapping("someDeleteUser")
    @ResponseBody
    public ServerResponse someDeleteUser(String ids) {
        return iUserService.someDeleteUser(ids);
    }

    //用户详情
    @RequestMapping("detailUser")
    @ResponseBody
    public ServerResponse detailUser(Integer userId) {
        return iUserService.detailUser(userId);
    }

    //保存用户
    @RequestMapping("saveUser")
    @ResponseBody
    public ServerResponse saveUser(User user) {
        return iUserService.saveUser(user);
    }

    //重置密码
    @RequestMapping("rePassword")
    @ResponseBody
    public ServerResponse rePassword(Integer userId) {
        return iUserService.rePassword(userId);
    }
    /***************************************/
    //跳转用户登录界面
    @RequestMapping("jumpUserLogin.html")
    public String jumpUserLoginHtml() {
        return "user/user_login";
    }

    //跳转用户购物商城界面
    @RequestMapping("jumpUserShop.html")
    public String jumpUserShopHtml() {
        return "user/user_shop";
    }

    //跳转购物车界面
    @RequestMapping("jumpUserShopCart.html")
    public String jumpUserShopCartHtml() {
        return "user/user_shop_cart";
    }

    //跳转用户结算界面
    @RequestMapping("jumpUserSettlement.html")
    public String jumpUserSettlementHtml(String cartIds,String sumPrice, HttpServletRequest request) {
        request.setAttribute("cartIds", cartIds);
        request.setAttribute("sumPrice", sumPrice);
        return "user/user_settlement";
    }

    //跳转用户注册
    @RequestMapping("jumpUserRegister.html")
    public String jumpUserRegisterHtml() {
        return "user/user_register";
    }

    //跳转后台登录
    @RequestMapping("jumpUserBackStageLogin.html")
    public String jumpUserBackStageLoginHtml() {
        return "user/user_backstage_login";
    }

    //跳转后台首页
    @RequestMapping("jumpUserBackStageIndex.html")
    public String jumpUserBackStageIndexHtml(Integer userRole) {
        if (userRole == 1) {
            return "user/user_backstage_index";
        } else if (userRole == 2) {
            return "user/user_backstage_index_customer";
        } else {
            return "user/user_backstage_index";
        }
    }

    //跳转最初的首页
    @RequestMapping("jumpShop.html")
    public String jumpShopHtml() {
        return "user/shop";
    }

    //跳转用户列表界面
    @RequestMapping("jumpUserList.html")
    public String jumpUserList() {
        return "user/user_list";
    }

    //跳转添加用户界面
    @RequestMapping("openUserAdd.html")
    public String openUserAddHtml() {
        return "user/user_add";
    }

    //打开个人信息
    @RequestMapping("openUserInfo.html")
    public String openUserInfoHtml() {
        return "user/user_info";
    }

    //打开用户详情
    @RequestMapping("openUserDetail.html")
    public String openUserDetailHtml() {
        return "user/user_detail";
    }


}
