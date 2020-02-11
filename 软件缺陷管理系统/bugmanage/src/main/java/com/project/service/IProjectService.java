package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Project;
import com.project.pojo.User;
import com.project.vo.CommonVo;
import com.project.vo.MenuVo;

import java.util.List;

public interface IProjectService {


    //分页列表
    LayUiPageResponse<List<Project>> projectList(CommonVo commonVo, int page, int limit );
    //增
    ServerResponse insert(Project project);
    //删
    ServerResponse delete(Integer id);

    //请求所有成员
    List<MenuVo> getUser(int projectId);

    //设置团队成员
    ServerResponse projectUserAdd(int[] userIds,int projectId);

    //根据项目ID查询成员
    LayUiPageResponse<List<User>> userList(CommonVo commonVo, int page, int limit );
}
