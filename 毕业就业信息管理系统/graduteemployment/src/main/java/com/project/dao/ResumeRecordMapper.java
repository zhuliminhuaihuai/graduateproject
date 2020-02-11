package com.project.dao;

import com.project.pojo.EmployInfo;
import com.project.pojo.ResumeRecord;
import com.project.vo.CommonVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResumeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResumeRecord record);

    int insertSelective(ResumeRecord record);

    ResumeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResumeRecord record);

    int updateByPrimaryKeyWithBLOBs(ResumeRecord record);

    int updateByPrimaryKey(ResumeRecord record);

    //简历投递信息信息列表
    List<ResumeRecord> resumeRecordList(CommonVo commonVo);

    //检测是否投过该企业
    int checkResumeRecord(@Param("jobName") String jobName,@Param("userCode") String userCode);
}