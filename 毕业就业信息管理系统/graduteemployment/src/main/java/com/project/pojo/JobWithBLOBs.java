package com.project.pojo;

import java.util.Date;

public class JobWithBLOBs extends Job {
    private String jobDetail;

    private String remark;

    public JobWithBLOBs(Integer id, String jobName, String jobPlace, Integer enterpriseId, String enterpriseCode, String jobSalary, String enterpriseName, String jobWelfare, String jobSkill, Date createTime, Date updateTime, Integer isOn, String jobType, Integer jobNum, String jobCreateUser, String jobCreateCode, String jobDetail, String remark) {
        super(id, jobName, jobPlace, enterpriseId, enterpriseCode, jobSalary, enterpriseName, jobWelfare, jobSkill, createTime, updateTime, isOn, jobType, jobNum, jobCreateUser, jobCreateCode);
        this.jobDetail = jobDetail;
        this.remark = remark;
    }

    public JobWithBLOBs() {
        super();
    }

    public String getJobDetail() {
        return jobDetail;
    }

    public void setJobDetail(String jobDetail) {
        this.jobDetail = jobDetail == null ? null : jobDetail.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}