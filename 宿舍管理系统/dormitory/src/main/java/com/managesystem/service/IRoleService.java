package com.managesystem.service;

import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.Role;

public interface IRoleService {

    //得到全部已经获得权限的用户
    LayUiPageResponse getHavePermissionsUserList(Integer page, Integer limit, String userCode, String userName);

    //修改用户的菜单权限
    ServerResponse modifyPermissions(String userCode, Integer[] ids);

    //根据ID删除用户权限
    ServerResponse deleteUserRole(Integer id, String userCode);

    //添加菜单权限成功的用户
    ServerResponse insertPermissions(Role role, Integer[] ids);

}
