package com.managesystem.controller.backend;


import com.managesystem.common.ServerResponse;
import com.managesystem.service.IMenuService;
import com.managesystem.vo.MenuVo;
import com.managesystem.vo.PermissionsMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/manage/menu/")
public class MenuController {

    @Autowired
    private IMenuService iMenuService;


    //根据不同的角色显示不同的左测功能菜单
    @RequestMapping("getMenuList")
    @ResponseBody
    public ServerResponse<List<MenuVo>> getMenuList(HttpServletRequest request) {

        return iMenuService.getMenuList(request);
    }

    //设置用户权限的菜单栏
    @RequestMapping("getPermissionsMenuList")
    @ResponseBody
    public List<PermissionsMenuVo> getPermissionsMenuList() {
        return iMenuService.getPermissionsMenuList();
    }

    //用户拥有的菜单权限
    @RequestMapping("getUserHavePermissionsList")
    @ResponseBody
    public List<PermissionsMenuVo> getUserHavePermissionsList(String userCode) {
        return iMenuService.getUserHavePermissionsList(userCode);
    }



}
