package com.project.dao;

import com.project.pojo.WinExperience;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WinExperienceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WinExperience record);

    int insertSelective(WinExperience record);

    WinExperience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WinExperience record);

    int updateByPrimaryKeyWithBLOBs(WinExperience record);

    int updateByPrimaryKey(WinExperience record);

    List<WinExperience> winExperienceList(@Param("resumeCode") String resumeCode);
}