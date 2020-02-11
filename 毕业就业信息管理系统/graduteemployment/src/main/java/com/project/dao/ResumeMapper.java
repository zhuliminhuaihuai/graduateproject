package com.project.dao;

import com.project.pojo.JobWithBLOBs;
import com.project.pojo.Resume;
import com.project.vo.CommonVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResumeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resume record);

    int insertSelective(Resume record);

    Resume selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);

    //职位信息列表
    List<Resume> resumeList(CommonVo commonVo);

    int updateByResumeCode(Resume record);
    //查该学生默认简历
    Resume resumeByUserCode(@Param("userCode") String userCode);

}