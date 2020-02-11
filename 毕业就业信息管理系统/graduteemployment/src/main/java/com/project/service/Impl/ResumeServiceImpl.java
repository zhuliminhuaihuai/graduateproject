package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.*;
import com.project.pojo.*;
import com.project.service.IResumeService;
import com.project.util.PublicUtil;
import com.project.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResumeServiceImpl implements IResumeService {

    @Autowired
    private ResumeMapper resumeMapper;
    @Autowired
    private ResumeRecordMapper resumeRecordMapper;
    @Autowired
    private EmployInfoMapper  employInfoMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private WinExperienceMapper winExperienceMapper;


    @Override
    public LayUiPageResponse<List<Resume>> resumeList(CommonVo commonVo, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Resume> resumeList = resumeMapper.resumeList(commonVo);
        if(resumeList.size()==0){
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
        PageInfo pageInfo = new PageInfo(resumeList);
        return LayUiPageResponse.createBySuccess(resumeList,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }

    @Override
    public ServerResponse insert(Resume resume) {
        String resumeCode = PublicUtil.setCode("Re");
        resume.setResumeCode(resumeCode);
        resume.setCreateTime(new Date());
        int count = resumeMapper.insertSelective(resume);
        if(count>0){
            return ServerResponse.createBySuccess(resumeCode);
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse delete(Integer id) {
        int count = resumeMapper.deleteByPrimaryKey(id);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse get(Integer id) {
        Resume resume = resumeMapper.selectByPrimaryKey(id);
        if(resume!=null){
            return ServerResponse.createBySuccess(resume);
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse edit(Resume resume) {
        int count = resumeMapper.updateByPrimaryKeySelective(resume);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public LayUiPageResponse<List<ResumeRecord>> resumeRecordList(CommonVo commonVo, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<ResumeRecord> resumeRecordList = resumeRecordMapper.resumeRecordList(commonVo);
        if(resumeRecordList.size()==0){
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
        PageInfo pageInfo = new PageInfo(resumeRecordList);
        return LayUiPageResponse.createBySuccess(resumeRecordList,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }

    @Override
    public LayUiPageResponse<List<EmployInfo>> employInfoList(CommonVo commonVo, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<EmployInfo> employInfoList = employInfoMapper.employList(commonVo);
        if(employInfoList.size()==0){
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
        PageInfo pageInfo = new PageInfo(employInfoList);
        return LayUiPageResponse.createBySuccess(employInfoList,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }

    @Override
    public ServerResponse insertProject(Project project) {
        project.setCreateTime(new Date());
        int count = projectMapper.insertSelective(project);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse insertWin(WinExperience winExperience) {
        winExperience.setCreateTime(new Date());
        int count = winExperienceMapper.insertSelective(winExperience);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse getResumeProject(String resumeCode) {
        List<Project> projects = projectMapper.projectByResumeCode(resumeCode);
        if(projects.size()>0){
            return ServerResponse.createBySuccess(projects);
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse getResumeWin(String resumeCode) {
        List<WinExperience> winExperiences = winExperienceMapper.winExperienceList(resumeCode);
        if(winExperiences.size()>0){
            return ServerResponse.createBySuccess(winExperiences);
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse saveResume(Resume resume) {
        int count = resumeMapper.updateByResumeCode(resume);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse deleteResumeWord(Resume resume) {
        String res =null;
        resume.setResumeWord(res);
        int count = resumeMapper.updateByResumeCode(resume);
        if (count > 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse insertResumeRecord(ResumeRecord resumeRecord) {
        String userCode = resumeRecord.getUserCode();
        Resume resume = resumeMapper.resumeByUserCode(userCode);
        if(resume==null){
            return ServerResponse.createByErrorMessage("您还没有设置默认简历");
        }
        String jobName = resumeRecord.getJobName();
        int jcount = resumeRecordMapper.checkResumeRecord(jobName,userCode);
        if(jcount>0){
            return ServerResponse.createByErrorMessage("请勿重复投递");
        }
        resumeRecord.setResumeId(resume.getId());
        resumeRecord.setResumeCode(resume.getResumeCode());
        resumeRecord.setCreateTime(new Date());
        resumeRecord.setHireStatus(0);
        int count = resumeRecordMapper.insertSelective(resumeRecord);
        if (count > 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse setResumeDefault(Integer id,String userCode) {
        Resume resume = resumeMapper.selectByPrimaryKey(id);
        if(resume.getIsDefault()==1){
            return ServerResponse.createByErrorMessage("已经是默认简历，请不要重复设置");
        }else {
            Resume resume1 = resumeMapper.resumeByUserCode(userCode);
            int rcount=1;
            if(resume1!=null){
                resume1.setIsDefault(2); //设原默认简历为不默认
                rcount = resumeMapper.updateByPrimaryKeySelective(resume1);
            }
            resume.setIsDefault(1);//设新简历默认
            int count = resumeMapper.updateByPrimaryKeySelective(resume);
            if(count>0&&rcount>0){
                return ServerResponse.createBySuccessMessage("设置成功");
            }
            return ServerResponse.createByErrorMessage("设置失败");
        }
    }

    @Override
    public ServerResponse editStatus(ResumeRecord resumeRecord) {
        /*if(resumeRecord.getHireStatus()==3){//如果面试成功 3为成功则创建一条就业信息
            EmployInfo employInfo = new EmployInfo();
            employInfo.setCreateTime(new Date());
            employInfo.setUserCode();
        }*/
        int count = resumeRecordMapper.updateByPrimaryKeySelective(resumeRecord);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }
}
