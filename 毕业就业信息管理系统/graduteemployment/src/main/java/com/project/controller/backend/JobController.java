package com.project.controller.backend;

import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.*;
import com.project.service.IJobService;
import com.project.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/manage/job/")
public class JobController {

    @Autowired
    private IJobService iJobService;


    //进入公司列表
    @RequestMapping("job_list")
    public String enterprise_list(){
        return "/enterprise/job_list";
    }
    //进入职位列表
    @RequestMapping(value="jobList")
    @ResponseBody
    public LayUiPageResponse<List<JobWithBLOBs>> jobList(CommonVo commonVo, int page, int limit, HttpServletRequest request){
        User user  = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        commonVo.setUserCode(user.getUserCode());
        commonVo.setRole(user.getRole().toString());//传角色role到mapper层 判断不同角色显示对应的数据
        return iJobService.jobList(commonVo,page,limit);
    }
    //学生首页-职位列表
    @RequestMapping(value="jobListMain")
    @ResponseBody
    public LayUiPageResponse<List<JobWithBLOBs>> jobListMain(CommonVo commonVo, int page, int limit, HttpServletRequest request){
        return iJobService.jobListMain(commonVo,page,limit);
    }

    //添加
    @RequestMapping(value="addJob")
    @ResponseBody
    public ServerResponse addJob(JobWithBLOBs jobWithBLOBs,HttpServletRequest request){
        User user = (User)request.getSession().getAttribute(Const.ManagerToken.SESSION);
        jobWithBLOBs.setJobCreateCode(user.getUserCode());
        jobWithBLOBs.setJobCreateUser(user.getUserName());
        return iJobService.insert(jobWithBLOBs);
    }

    //删除
    @RequestMapping(value="deleteJob")
    @ResponseBody
    public ServerResponse deleteJob(Integer id){
        return iJobService.delete(id);
    }
    //企业信息
    @RequestMapping(value="getJob")
    @ResponseBody
    public ServerResponse getJob(Integer id){
        return iJobService.get(id);
    }
    //修改
    @RequestMapping(value="editJob")
    @ResponseBody
    public ServerResponse editJob(JobWithBLOBs jobWithBLOBs){
        return iJobService.edit(jobWithBLOBs);
    }

    //修改 职位是否开启
    @RequestMapping(value="shutOrOpenJob")
    @ResponseBody
    public ServerResponse shutOrOpenJob(Integer id,Integer isOn){
        return iJobService.shutOrOpenJob(id,isOn);
    }

    //进入添加职位页面
    @RequestMapping("job_add")
    public String job_add(){
        return "/enterprise/job_add";
    }
    //进入编辑职位页面
    @RequestMapping("job_edit")
    public String job_edit(){
        return "/enterprise/job_edit";
    }

    //添加职位前 验证企业是否通过审批
    @RequestMapping(value="checkEnter")
    @ResponseBody
    public ServerResponse checkEnter(String userCode){
        return iJobService.checkEnter(userCode);
    }
}
