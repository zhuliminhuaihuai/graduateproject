package com.project.controller.backend;

import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Project;
import com.project.pojo.User;
import com.project.service.IProjectService;
import com.project.vo.CommonVo;
import com.project.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/manage/project/")
public class ProjectController {

    @Autowired
    private IProjectService iProjectService;
    //进入添加列表页
    @RequestMapping(value = "project_list")
    public String project_list(){
        return "/project/project_list";
    }

    //请求列表
    @RequestMapping(value="projectList")
    @ResponseBody
    public LayUiPageResponse<List<Project>> projectList(CommonVo commonVo, int page, int limit,HttpServletRequest request){
        User user = (User)request.getSession().getAttribute(Const.ManagerToken.SESSION);
        commonVo.setRole(user.getRole().toString());
        commonVo.setUserId(user.getUserId());
        return iProjectService.projectList(commonVo,page,limit);
    }

    //进入添加项目页
    @RequestMapping(value = "project_add")
    public String user_add(){
        return "/project/project_add";
    }
    //生成项目
    @RequestMapping(value="addProject")
    @ResponseBody
    public ServerResponse addProject(Project project, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        project.setUserId(user.getUserId());
        project.setUserName(user.getRealName());
        return iProjectService.insert(project);
    }
    //删除
    @RequestMapping(value="deleteProject")
    @ResponseBody
    public ServerResponse deleteProject(int id){
        return iProjectService.delete(id);
    }

    //进入项目设置成员界面
    @RequestMapping(value = "project_user_setup")
    public String project_user_setup(){
        return "project/project_user_setup";
    }

    //渲染所有成员列表 （研发和测试）
    @RequestMapping(value="projectUserList")
    @ResponseBody
    public List<MenuVo> projectUserList(int projectId){
        return iProjectService.getUser(projectId);
    }

    //生成项目成员
    @RequestMapping(value="projectUserAdd")
    @ResponseBody
    public ServerResponse projectUserList(int[] userIds,int projectId){
        return iProjectService.projectUserAdd(userIds,projectId);
    }

    //根据项目ID查询成员
    //请求用户列表
    @RequestMapping(value="userList")
    @ResponseBody
    public LayUiPageResponse<List<User>> userList(CommonVo commonVo, int page, int limit){
        return iProjectService.userList(commonVo,page,limit);
    }
    //进入项目成员列表界面
    @RequestMapping(value = "project_user")
    public String project_user(){
        return "project/project_user";
    }

}
