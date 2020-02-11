package com.managesystem.service;

import com.managesystem.common.ServerResponse;
import com.managesystem.vo.MenuVo;
import com.managesystem.vo.PermissionsMenuVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IMenuService {

    //根据不同的角色显示不同的左测功能菜单
    ServerResponse<List<MenuVo>> getMenuList(HttpServletRequest request);

    //设置用户权限的菜单栏
    List<PermissionsMenuVo> getPermissionsMenuList();

    //取出该用户拥有的权限
    List<PermissionsMenuVo> getUserHavePermissionsList(String userCode);

}
