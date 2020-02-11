package com.managesystem.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.dao.RoleMapper;
import com.managesystem.dao.RoleMenuMapper;
import com.managesystem.pojo.Role;
import com.managesystem.pojo.RoleMenu;
import com.managesystem.service.IRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    //得到全部已经获得权限的用户
    public LayUiPageResponse getHavePermissionsUserList(Integer page, Integer limit,String userCode,String userName) {

        PageHelper.startPage(page, limit);
        List<Role> roleList = roleMapper.getHavePermissionUser(userCode,userName);
        PageInfo pageInfo = new PageInfo(roleList);
        if (roleList.size() > 0) {
            return LayUiPageResponse.createBySuccess(roleList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据！！！");
        }

    }

    //修改用户的菜单权限
    public ServerResponse modifyPermissions(String userCode, Integer[] ids) {
        int count = roleMenuMapper.deleteMenuIdList(userCode);
        int total = 0;
        if (count > 0) {
            for (Integer id : ids) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setMenuId(id);
                roleMenu.setUserCode(userCode);
                total++;
                roleMenuMapper.insertSelective(roleMenu);
            }
            if (total > 0) {
                return ServerResponse.createBySuccessMessage("权限修改成功");
            } else {
                return ServerResponse.createByErrorMessage("权限修改失败");
            }
        } else {
            return ServerResponse.createByErrorMessage("权限修改失败");
        }
    }
    //根据ID删除用户权限
    @Override
    public ServerResponse deleteUserRole(Integer id, String userCode) {
        int i=roleMenuMapper.deleteMenuIdList(userCode);
        if(i>0){
            int count = roleMapper.deleteByPrimaryKey(id);
            if (count > 0) {
                return ServerResponse.createBySuccessMessage("权限人员删除成功");
            } else {
                return ServerResponse.createByErrorMessage("权限人员删除失败");
            }
        }else {
            return ServerResponse.createByErrorMessage("权限人员删除失败");
        }
    }
    //添加菜单权限成功的用户
    public ServerResponse insertPermissions(Role role,Integer[] ids) {

        List<RoleMenu> roleMenuList = roleMenuMapper.findRoleMenu(role.getUsercode());
        if (!(CollectionUtils.isNotEmpty(roleMenuList))) {
            String userCode = role.getUsercode();
            int count = roleMapper.insertSelective(role);
            int total = 0;
            for (Integer id : ids) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setMenuId(id);
                roleMenu.setUserCode(userCode);
                total++;
                roleMenuMapper.insertSelective(roleMenu);
            }
            if (count != 0 && total != 0) {
                return ServerResponse.createBySuccessMessage("插入成功");
            }
            return ServerResponse.createByErrorMessage("插入失败");
        } else {
            return ServerResponse.createByErrorMessage("权限已设置");
        }
    }


}
