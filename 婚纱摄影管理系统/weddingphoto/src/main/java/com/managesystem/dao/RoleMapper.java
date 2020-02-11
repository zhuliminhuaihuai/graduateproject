package com.managesystem.dao;

import com.managesystem.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKeyWithBLOBs(Role record);

    int updateByPrimaryKey(Role record);

    //得到全部已经获得权限的用户
    List<Role> getHavePermissionUser(@Param("userCode")String userCode, @Param("userName")String userName);
}