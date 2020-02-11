package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.EnterpriseMapper;
import com.project.dao.JobMapper;
import com.project.pojo.Enterprise;
import com.project.pojo.JobWithBLOBs;
import com.project.service.IJobService;
import com.project.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobServiceImpl implements IJobService {

    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public LayUiPageResponse<List<JobWithBLOBs>> jobList(CommonVo commonVo, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<JobWithBLOBs> jobs = jobMapper.jobList(commonVo);
        if(jobs.size()==0){
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
        PageInfo pageInfo = new PageInfo(jobs);
        return LayUiPageResponse.createBySuccess(jobs,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }
    @Override
    public LayUiPageResponse<List<JobWithBLOBs>> jobListMain(CommonVo commonVo, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<JobWithBLOBs> jobs = jobMapper.jobListMain(commonVo);
        if(jobs.size()==0){
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
        PageInfo pageInfo = new PageInfo(jobs);
        return LayUiPageResponse.createBySuccess(jobs,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }

    @Override
    public ServerResponse insert(JobWithBLOBs jobWithBLOBs) {
        String userCode = jobWithBLOBs.getJobCreateCode();
        Enterprise enterprise = enterpriseMapper.enterpriseInfoByUserCode(userCode);
        jobWithBLOBs.setEnterpriseCode(enterprise.getEnterpriseCode());
        jobWithBLOBs.setEnterpriseName(enterprise.getEnterpriseName());
        jobWithBLOBs.setEnterpriseId(enterprise.getId());
        jobWithBLOBs.setCreateTime(new Date());
        int count = jobMapper.insert(jobWithBLOBs);
        if(count>0){
            return ServerResponse.createBySuccessMessage("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }

    @Override
    public ServerResponse delete(Integer id) {
        int count = jobMapper.deleteByPrimaryKey(id);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse edit(JobWithBLOBs jobWithBLOBs) {

        int count = jobMapper.updateByPrimaryKeySelective(jobWithBLOBs);
        if(count>0){
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse get(Integer id) {
        JobWithBLOBs jobWithBLOBs = jobMapper.selectByPrimaryKey(id);
        if(jobWithBLOBs!=null){
            return ServerResponse.createBySuccess(jobWithBLOBs);
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse shutOrOpenJob(Integer id,Integer isOn) {
        JobWithBLOBs jobWithBLOBs = new JobWithBLOBs();
        jobWithBLOBs.setId(id);
        jobWithBLOBs.setIsOn(isOn);
        int count = jobMapper.updateByPrimaryKeySelective(jobWithBLOBs);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse checkEnter(String userCode) {
        int count = enterpriseMapper.checkEnter(userCode);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }
}
