package com.project.dao;

import com.project.pojo.Check;
import com.project.vo.CheckQueryVo;

import java.util.List;

public interface CheckMapper {
    int deleteByPrimaryKey(Integer checkId);

    int insert(Check record);

    int insertSelective(Check record);

    Check selectByPrimaryKey(Integer checkId);

    int updateByPrimaryKeySelective(Check record);

    int updateByPrimaryKey(Check record);

    List<Check> getCheckList(CheckQueryVo checkQueryVo);

    int deleteByRoomId(Integer roomId);
}