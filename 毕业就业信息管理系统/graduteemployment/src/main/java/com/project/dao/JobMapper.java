package com.project.dao;

import com.project.pojo.EmployInfo;
import com.project.pojo.Job;
import com.project.pojo.JobWithBLOBs;
import com.project.vo.CommonVo;

import java.util.List;

public interface JobMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobWithBLOBs record);

    int insertSelective(JobWithBLOBs record);

    JobWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(JobWithBLOBs record);

    int updateByPrimaryKey(Job record);

    //职位信息列表
    List<JobWithBLOBs> jobList(CommonVo commonVo);

    //学生职位信息列表
    List<JobWithBLOBs> jobListMain(CommonVo commonVo);

}