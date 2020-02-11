package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.ProjectMapper;
import com.project.dao.TeamMapper;
import com.project.dao.UserMapper;
import com.project.pojo.Project;
import com.project.pojo.Team;
import com.project.pojo.User;
import com.project.service.IProjectService;
import com.project.vo.CommonVo;
import com.project.vo.MenuVo;
import com.project.vo.TeamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ProjectServiceImpl implements IProjectService {


    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public LayUiPageResponse<List<Project>> projectList(CommonVo commonVo, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Project> projectList = Lists.newArrayList();
        if(commonVo.getRole().equals("0")||commonVo.getRole().equals("1")){//当前角色为管理员和项目经理
            projectList = projectMapper.projectList(commonVo);
        }else {//当前角色为研发和测试
            List<Integer> projectIds = teamMapper.projectIdList(commonVo.getUserId());
            if(projectIds.size()>0){
                projectList = projectMapper.projectByProjectIds(projectIds);
            }
        }

        if(projectList.size()==0){
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
        PageInfo pageInfo = new PageInfo(projectList);
        return LayUiPageResponse.createBySuccess(projectList,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }

    @Override
    public ServerResponse insert(Project project) {
        String projectName = project.getProjectName();
        if(projectMapper.checkProjectName(projectName)>0){
            return ServerResponse.createByErrorMessage("项目已存在，请勿重复添加");
        }
        project.setCreateTime(new Date());
        if(projectMapper.insertSelective(project)>0){
            return ServerResponse.createBySuccessMessage("添加成功");
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse delete(Integer id) {
        if(teamMapper.selectTeamByProjectId(id)>0){//该项目下有成员 删除项目和成员
            if(projectMapper.deleteByPrimaryKey(id)>0&&teamMapper.deleteByProjectId(id)>0){
                return ServerResponse.createBySuccess();
            }
            return ServerResponse.createByError();
        }else {//如果项目下无成员 删除项目
            if(projectMapper.deleteByPrimaryKey(id)>0){
                return ServerResponse.createBySuccess();
            }
            return ServerResponse.createByError();
        }
    }

    @Override
    public List<MenuVo> getUser(int projectId) {
        List<Integer> integerList = teamMapper.teamList(projectId);
        List<MenuVo> menuVos = Lists.newArrayList();
        MenuVo menuVo1 = new MenuVo();
        menuVo1.setTitle("研发人员");
        menuVo1.setValue("2");
        menuVo1.setChecked(false);
        menuVo1.setDisabled(false);

        MenuVo menuVo2 = new MenuVo();
        menuVo2.setTitle("测试人员");
        menuVo2.setValue("3");
        menuVo2.setChecked(false);
        menuVo2.setDisabled(false);
        List<User> technologyUser = userMapper.userListByROle(2);//查出所有研发
        List<User> testyUser = userMapper.userListByROle(3);//查出所以测试
        List<MenuVo> userList1= Lists.newArrayList();
        List<MenuVo> userList2= Lists.newArrayList();
        List<MenuVo> testList = Lists.newArrayList();
        if(integerList.size()==0){//如果该项目还没设置过成员执行以下
            for (User user : technologyUser) {//遍历研发
                MenuVo menuVo = new MenuVo();
                menuVo.setTitle(user.getRealName());
                menuVo.setValue(user.getUserId().toString());
                menuVo.setChecked(false);
                menuVo.setDisabled(false);
                menuVo.setData(testList);
                userList1.add(menuVo);

            }
            for (User user : testyUser) {//遍历测试
                MenuVo menuVo = new MenuVo();
                menuVo.setTitle(user.getRealName());
                menuVo.setValue(user.getUserId().toString());
                menuVo.setChecked(false);
                menuVo.setDisabled(false);
                menuVo.setData(testList);
                userList2.add(menuVo);
            }
            menuVo1.setData(userList1);
            menuVo2.setData(userList2);
            menuVos.add(menuVo1);
            menuVos.add(menuVo2);
        }else {//如果已经设置成员 走以下方法
            for (User user : technologyUser) {//遍历研发
                MenuVo menuVo = new MenuVo();
                menuVo.setTitle(user.getRealName());
                menuVo.setValue(user.getUserId().toString());
                for (Integer integer : integerList) {
                    if(integer.intValue()==user.getUserId().intValue()){
                        menuVo.setChecked(true);
                        break;
                    }
                    menuVo.setChecked(false);
                }
                menuVo.setDisabled(false);
                menuVo.setData(testList);
                userList1.add(menuVo);

            }
            for (User user : testyUser) {//遍历测试
                MenuVo menuVo = new MenuVo();
                menuVo.setTitle(user.getRealName());
                menuVo.setValue(user.getUserId().toString());
                for (Integer integer : integerList) {
                    if(integer.intValue()==user.getUserId().intValue()){
                        menuVo.setChecked(true);
                        break;
                    }
                    menuVo.setChecked(false);
                }
                menuVo.setDisabled(false);
                menuVo.setData(testList);
                userList2.add(menuVo);
            }
            menuVo1.setData(userList1);
            menuVo2.setData(userList2);
            menuVos.add(menuVo1);
            menuVos.add(menuVo2);
        }
        return menuVos;
    }

    @Override
    public ServerResponse projectUserAdd(int[] userIds,int projectId) {
        //先删除
        if(userIds.length>0){
            teamMapper.deleteByProjectId(projectId);
        }
        //再插入
        Set<TeamVo> teamVoSet = Sets.newHashSet();
        for (int userId : userIds) {
            TeamVo teamVo = new TeamVo();
            teamVo.setProjectId(projectId);
            teamVo.setUserId(userId);
            teamVoSet.add(teamVo);
        }
        if(teamMapper.insertTeams(teamVoSet)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public LayUiPageResponse<List<User>> userList(CommonVo commonVo, int page, int limit) {
        List<Integer> userIds = teamMapper.teamList(commonVo.getProjectId());
        PageHelper.startPage(page,limit);
        if(userIds.size()>0){
            commonVo.setUserIds(userIds);
            List<User> users = userMapper.projectUserList(commonVo);
            PageInfo pageInfo = new PageInfo(users);
            return LayUiPageResponse.createBySuccess(users,pageInfo.getTotal(),page,limit);
        }
        return LayUiPageResponse.createByErrorMessage("该项目暂无成员");
    }

}
