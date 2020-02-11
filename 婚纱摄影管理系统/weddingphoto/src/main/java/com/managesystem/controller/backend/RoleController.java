package com.managesystem.controller.backend;


import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.Role;
import com.managesystem.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/manage/role/")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    //得到全部已经获得权限的用户
    @RequestMapping("getHavePermissionsUserList")
    @ResponseBody
    public LayUiPageResponse getHavePermissionsUserList(Integer page, Integer limit,String userCode,String userName) {
        return iRoleService.getHavePermissionsUserList(page, limit,userCode,userName);
    }

    //添加菜单权限成功的用户
    @RequestMapping("insertPermissions")
    @ResponseBody
    public ServerResponse insertPermissions(Role role, Integer[] ids) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        role.setCreateTime(dateFormat.format(new Date()));
        return iRoleService.insertPermissions(role, ids);
    }

    //修改用户的菜单权限
    @RequestMapping("modifyPermissions")
    @ResponseBody
    public ServerResponse modifyPermissions(String userCode, Integer[] ids) {
        return iRoleService.modifyPermissions(userCode, ids);
    }

    //根据ID删除用户权限
    @RequestMapping("deleteUserRole")
    @ResponseBody
    public ServerResponse deleteUserRole(Integer id,String userCode) {
        System.out.println(id+"---------"+userCode);
        return iRoleService.deleteUserRole(id,userCode);
    }

    //跳转用户权限配置（列表）
    @RequestMapping("jumpUserPermission.html")
    public String jumpUserPermissionHtml() {
        return "role/role_permisson_list";
    }

    //打开权限配置菜单
    @RequestMapping("openConfigUserPermission.html")
    public String openConfigUserPermissionHtml() {
        return "role/config_role_permission";
    }

    //打开修改用户权限界面
    @RequestMapping("openModifyRolePermission.html")
    public String openModifyRolePermissionHtml() {
        return "role/modify_role_permission";
    }


}
