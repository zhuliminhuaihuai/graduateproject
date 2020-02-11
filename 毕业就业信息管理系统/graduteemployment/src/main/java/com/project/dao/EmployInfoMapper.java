package com.project.dao;

import com.project.pojo.EmployInfo;
import com.project.pojo.User;
import com.project.vo.CommonVo;

import java.util.List;

public interface EmployInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployInfo record);

    int insertSelective(EmployInfo record);

    EmployInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployInfo record);

    int updateByPrimaryKey(EmployInfo record);

    //就业三方列表
    List<EmployInfo> employList(CommonVo commonVo);
}