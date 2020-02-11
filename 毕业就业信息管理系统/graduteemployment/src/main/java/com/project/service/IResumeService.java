package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.*;
import com.project.vo.CommonVo;

import java.util.List;

public interface IResumeService {

    //分页简历列表
    LayUiPageResponse<List<Resume>> resumeList(CommonVo commonVo, int page, int limit);

    //添加
    ServerResponse insert(Resume resume);

    //删除
    ServerResponse delete(Integer id);

    //获取个人简历信息
    ServerResponse get(Integer id);

    //修改
    ServerResponse edit(Resume resume);

    //简历投递情况列表
    LayUiPageResponse<List<ResumeRecord>> resumeRecordList(CommonVo commonVo, int page, int limit);

    //就业情况列表
    LayUiPageResponse<List<EmployInfo>> employInfoList(CommonVo commonVo, int page, int limit);

    //简历-添加项目
    ServerResponse insertProject(Project project);

    //简历-添加获奖经历
    ServerResponse insertWin(WinExperience winExperience);

    //获取我当前简历中的项目经历
    ServerResponse getResumeProject(String resumeCode);

    //获取我当前简历中的获奖经历
    ServerResponse getResumeWin(String resumeCode);

    //简历保存
    ServerResponse saveResume(Resume resume);

    //简历删除-文档
    ServerResponse deleteResumeWord(Resume resume);

    //投递简历
    ServerResponse insertResumeRecord(ResumeRecord resumeRecord);

    //设置默认简历
    ServerResponse setResumeDefault(Integer id,String userCode);
    //设置默认简历
    ServerResponse editStatus(ResumeRecord resumeRecord);
}
