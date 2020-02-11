package com.project.dao;

import com.project.pojo.Clean;
import com.project.vo.CleanQueryVo;

import java.util.List;

public interface CleanMapper {
    int deleteByPrimaryKey(Integer cleanId);

    int insert(Clean record);

    int insertSelective(Clean record);

    Clean selectByPrimaryKey(Integer cleanId);

    int updateByPrimaryKeySelective(Clean record);

    int updateByPrimaryKey(Clean record);

    List<Clean> getCleanList(CleanQueryVo cleanQueryVo);

    int deleteByRoomId(Integer roomId);
}