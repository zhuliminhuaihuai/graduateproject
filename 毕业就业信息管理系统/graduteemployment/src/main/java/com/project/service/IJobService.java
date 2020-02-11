package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Job;
import com.project.pojo.JobWithBLOBs;
import com.project.pojo.User;
import com.project.vo.CommonVo;

import java.util.List;

public interface IJobService {

    //分页职位列表
    LayUiPageResponse<List<JobWithBLOBs>> jobList(CommonVo commonVo, int page, int limit );

    //学生首页-分页职位列表
    LayUiPageResponse<List<JobWithBLOBs>> jobListMain(CommonVo commonVo, int page, int limit );
    //增
    ServerResponse insert(JobWithBLOBs jobWithBLOBs);
    //删
    ServerResponse delete(Integer id);
    //改
    ServerResponse edit(JobWithBLOBs jobWithBLOBs);
    //查 -根据ID
    ServerResponse get(Integer id);

    //关闭/开启职位
    ServerResponse shutOrOpenJob(Integer id,Integer isOn);

    //创建职位前 先验证企业是否审批通过
    ServerResponse checkEnter(String userCode);

}
