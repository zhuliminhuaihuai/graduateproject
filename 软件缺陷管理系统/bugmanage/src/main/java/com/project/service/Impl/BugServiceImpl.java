package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.*;
import com.project.pojo.Bug;
import com.project.pojo.BugClassification;
import com.project.pojo.Project;
import com.project.pojo.User;
import com.project.service.IBugService;
import com.project.vo.BugVo;
import com.project.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BugServiceImpl implements IBugService {

    @Autowired
    private BugMapper bugMapper;

    @Autowired
    private BugClassificationMapper bugClassificationMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    /**
     *
     * @param commonVo 模糊查询条件实体
     * @param page 当前页
     * @param limit  每页最大数
     * @return
     */
    public LayUiPageResponse<List<BugVo>> bugList(CommonVo commonVo, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<BugVo> bugList = bugMapper.bugList(commonVo);
        if(bugList.size()==0){
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
        PageInfo pageInfo = new PageInfo(bugList);
        return LayUiPageResponse.createBySuccess(bugList,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }

    @Override
    public LayUiPageResponse<List<BugClassification>> bugClassList(CommonVo commonVo, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<BugClassification> bugClassificationList = bugClassificationMapper.bugClassList(commonVo);
        if(bugClassificationList.size()==0){
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
        PageInfo pageInfo = new PageInfo(bugClassificationList);
        return LayUiPageResponse.createBySuccess(bugClassificationList,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }

    @Override
    public ServerResponse selectBugClass() {
        List<BugClassification> bugClassificationList = bugClassificationMapper.selectBugClass();
        if(bugClassificationList.size()>0){
            return ServerResponse.createBySuccess(bugClassificationList);
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse insertBugClassfication(BugClassification bugClassification) {
        String bugName = bugClassification.getBugName();
        if(bugClassificationMapper.checkBugName(bugName)>0){
            return ServerResponse.createByErrorMessage("该分类名称已存在");
        }
        bugClassification.setCreateTime(new Date());
        int count = bugClassificationMapper.insertSelective(bugClassification);
        if(count>0){
            return ServerResponse.createBySuccessMessage("生成成功");
        }
        return ServerResponse.createByErrorMessage("生成失败");
    }

    @Override
    public ServerResponse deleteBugClass(int id) {
        int count = bugClassificationMapper.deleteByPrimaryKey(id);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse deleteBug(int id) {
        int count = bugMapper.deleteByPrimaryKey(id);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse projectByUser(int userId) {
        List<Integer> projectIds = teamMapper.projectIdList(userId);
        if(projectIds.size()>0){
            List<Project> projectList = projectMapper.projectByProjectIds(projectIds);
            if(projectList.size()>0){
                return ServerResponse.createBySuccess(projectList);
            }
            return ServerResponse.createByErrorMessage("没有对应的项目，项目是否被删");
        }
        return ServerResponse.createByErrorMessage("该用户还未分配项目");
    }

    @Override
    public ServerResponse insertBug(Bug bug) {
        bug.setCreateTime(new Date());
        bug.setStatus(0);
        if(bugMapper.insertSelective(bug)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse getBugDetail(int id) {
        BugVo bugVo = bugMapper.selectById(id);
        if(bugVo!=null){
            return ServerResponse.createBySuccess(bugVo);
        }
        return ServerResponse.createByErrorMessage("没有对应的缺陷");
    }

    @Override
    public ServerResponse returnWithdrawReason(Bug bug) {
        if(bugMapper.updateByPrimaryKeySelective(bug)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse returnBugResult(Bug bug) {
        if(bugMapper.updateByPrimaryKeySelective(bug)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse projectTechnologyList(int projectId) {
        List<Integer> userIds = teamMapper.teamList(projectId);
        if(userIds.size()>0){
            List<User> users = userMapper.projectTechnologyList(userIds);
            return ServerResponse.createBySuccess(users);
        }
        return ServerResponse.createByErrorMessage("该项目暂无成员");
    }

    @Override
    public ServerResponse saveTechnology(Bug bug) {
        bug.setStatus(3);//设为3 待技术处理
        if(bugMapper.updateByPrimaryKeySelective(bug)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse technologyReceiveBug(Bug bug) {
        bug.setStatus(5);//设为5 技术处理中
        if(bugMapper.updateByPrimaryKeySelective(bug)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse finishBug(Bug bug) {
        bug.setStatus(7);//设为7 测试确认完成
        bug.setEndTime(new Date());
        if(bugMapper.updateByPrimaryKeySelective(bug)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse editBug(Bug bug) {
        if(bugMapper.updateByPrimaryKeySelective(bug)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }
}

