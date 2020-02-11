package com.managesystem.dao;

import com.managesystem.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    //取出母菜单
    List<Menu> getMotherMenuList();

    //取出子菜单
    List<Menu> getChildenMenuList();

    List<Menu> getMotherMenuListByIdList(@Param("menuIDList") List<Integer> menuIDList);

    List<Menu> getChildenMenuListByIdList(@Param("menuIDList") List<Integer> menuIDList);
}