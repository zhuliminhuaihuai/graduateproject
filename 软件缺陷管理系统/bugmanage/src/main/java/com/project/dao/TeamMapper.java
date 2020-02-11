package com.project.dao;

import com.project.pojo.Team;
import com.project.vo.TeamVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface TeamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);
    //批量插入
    int insertTeams(@Param("teamVoSet") Set<TeamVo> teamVoSet);
    //查询根据项目ID查询成员ID集合
    List<Integer> teamList(@Param("projectId") int projectId);

    int deleteByProjectId(Integer projectId);

    //查询根据userID查询项目ID集合
    List<Integer> projectIdList(@Param("userId") int userId);

    int selectTeamByProjectId(@Param("id") int id);

}