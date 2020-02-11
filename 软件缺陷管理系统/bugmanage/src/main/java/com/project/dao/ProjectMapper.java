package com.project.dao;

import com.project.pojo.Project;
import com.project.pojo.User;
import com.project.vo.CommonVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    //List分页角色列表
    List<Project> projectList(CommonVo commonVo);

    //检测项目名
    int checkProjectName(@Param("projectName") String projectName);

    List<Project> projectByProjectIds(@Param("projectIds") List<Integer> projectIds);
}