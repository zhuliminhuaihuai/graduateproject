package com.managesystem.dao;

import com.managesystem.pojo.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    RoleMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);

    //取出该用户拥有的菜单权限
    List<Integer> getMenuIdList(String userCode);

    //修改用户权限前，先删除权限
    int deleteMenuIdList(String userCode);

    //查找此用户是否配过权限
    List<RoleMenu> findRoleMenu(String userCode);

    /*//配置学生默认菜单栏
    int configDefaultPermissions(@Param("idList") List<Integer> idList);
*/
}