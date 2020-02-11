package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Bug;
import com.project.pojo.BugClassification;
import com.project.pojo.User;
import com.project.vo.BugVo;
import com.project.vo.CommonVo;

import java.util.List;

public interface IBugService {

    //分页bug列表
    LayUiPageResponse<List<BugVo>> bugList(CommonVo commonVo, int page, int limit );

    //分页bug分类列表
    LayUiPageResponse<List<BugClassification>> bugClassList(CommonVo commonVo, int page, int limit );

    // 请求所有缺陷分类  为了渲染下拉框
    ServerResponse selectBugClass();

    //插入
    ServerResponse insertBugClassfication(BugClassification bugClassification);

    //删除分类
    ServerResponse deleteBugClass(int id);

    //删除bug
    ServerResponse deleteBug(int id);

    //根据当前用户请求项目列表
    ServerResponse projectByUser(int userId);
    //生成缺陷
     ServerResponse insertBug(Bug bug);
    //请求bug缺陷详情
    ServerResponse getBugDetail(int id);

    //填写撤回信息
    ServerResponse returnWithdrawReason(Bug bug);

    //填写结果信息
    ServerResponse returnBugResult(Bug bug);

    //根据项目ID查询成员
    ServerResponse projectTechnologyList(int projectId);

    //转移技术
    ServerResponse saveTechnology(Bug bug);

    //技术接收缺陷
    ServerResponse technologyReceiveBug(Bug bug);

    //测试确认完成缺陷
    ServerResponse finishBug(Bug bug);

    //重新编辑缺陷
    ServerResponse editBug(Bug bug);
}
