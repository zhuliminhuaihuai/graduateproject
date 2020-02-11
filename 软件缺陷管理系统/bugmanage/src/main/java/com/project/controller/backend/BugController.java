package com.project.controller.backend;

import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Bug;
import com.project.pojo.BugClassification;
import com.project.pojo.User;
import com.project.service.IBugService;
import com.project.vo.BugVo;
import com.project.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/manage/bug/")
public class BugController {

    @Autowired
    private IBugService iBugService;

    //前往bug列表界面 bug == 软件缺陷
    @RequestMapping("bug_list")
    public String bug_list(){
        return "/bug/bug_list";
    }
    //前往bug分类列表界面
    @RequestMapping("bug_classfication_list")
    public String bug_calssfication_list(){
        return "/bug/bug_classfication_list";
    }
    //请求bug列表
    @RequestMapping(value="bugList")
    @ResponseBody
    public LayUiPageResponse<List<BugVo>> bugList(CommonVo commonVo, int page, int limit,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        /*if(user.getRole()==0){//管理员  0为管理员 1项目经理 2研发技术人员 3测试人员
            commonVo.setRole("0");
        }else if(user.getRole()==1){//项目经理
            commonVo.setRole("1");
        }else if(user.getRole()==2) {//研发
            commonVo.setRole("2");
        }else {//测试
            commonVo.setRole("3");
        }*/
        commonVo.setRole(user.getRole().toString());
        commonVo.setUserId(user.getUserId());//插入当前人的用户id
        return iBugService.bugList(commonVo,page,limit);
    }

    //请求分类列表
    @RequestMapping(value="bugCalssficationList")
    @ResponseBody
    public LayUiPageResponse<List<BugClassification>> bugCalssficationList(CommonVo commonVo, int page, int limit){
        return iBugService.bugClassList(commonVo,page,limit);
    }

    //渲染下拉框  所有缺陷分类
    @RequestMapping(value="selectBugClass")
    @ResponseBody
    public ServerResponse  selectBugClass(){
        return iBugService.selectBugClass();
    }

    //前往增加bug分类页面
    @RequestMapping("bug_classfication_add")
    public String bug_classfication_add(){
        return "/bug/bug_classfication_add";
    }
    //生成bug分类
    @RequestMapping(value="insertBugClassfication")
    @ResponseBody
    public ServerResponse insertBugClassfication(BugClassification bugClassification){
        return iBugService.insertBugClassfication(bugClassification);
    }

    //删除缺陷分类
    @RequestMapping(value="deleteBugClass")
    @ResponseBody
    public ServerResponse deleteBugClass(int id){
        return iBugService.deleteBugClass(id);
    }
    //删除bug缺陷
    @RequestMapping(value="deleteBug")
    @ResponseBody
    public ServerResponse deleteBug(int id){
        return iBugService.deleteBug(id);
    }
    //前往增加bug页面
    @RequestMapping("bug_add")
    public String bug_add(){
        return "/bug/bug_add";
    }

    //根据当前用户 请求所拥有的项目
    @RequestMapping(value="projectList")
    @ResponseBody
    public ServerResponse projectList(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute(Const.ManagerToken.SESSION);
        return iBugService.projectByUser(user.getUserId());
    }
    //添加缺陷
    @RequestMapping(value="insertBug")
    @ResponseBody
    public ServerResponse insertBug(Bug bug,HttpServletRequest request){
        User user = (User)request.getSession().getAttribute(Const.ManagerToken.SESSION);
        System.out.println("pro:"+bug.getProjectName());
        bug.setUserId(user.getUserId());
        return iBugService.insertBug(bug);
    }
    //进入缺陷详情页
    @RequestMapping("bug_detail")
    public String bug_detail(){
        return "/bug/bug_detail";
    }

    //根据当前用户 请求所拥有的项目
    @RequestMapping(value="getBugDetail")
    @ResponseBody
    public ServerResponse getBugDetail(int id){
        return iBugService.getBugDetail(id);
    }

    //进入撤回原因界面
    @RequestMapping("bug_withdraw")
    public String bug_withdraw(){
        return "/bug/bug_withdraw";
    }
    //进入填写结果界面
    @RequestMapping("bug_result")
    public String bug_result(){
        return "/bug/bug_result";
    }
    //转移技术界面
    @RequestMapping("bug_trun_newtechnology")
    public String bug_trun_newtechnology(){
        return "/bug/bug_trun_newtechnology";
    }
    //填写撤回原因
    @RequestMapping(value="returnWithdrawReason")
    @ResponseBody
    public ServerResponse returnWithdrawReason(Bug bug,HttpServletRequest request){
        User user = (User)request.getSession().getAttribute(Const.ManagerToken.SESSION);
        if(user.getRole()==1){
            bug.setStatus(1);//经理撤回
        }
        if(user.getRole()==2){
            bug.setStatus(4);//技术撤回
            bug.setTechnologyId(0);
            bug.setTechnologyName("/");
        }
        return iBugService.returnWithdrawReason(bug);
    }
    //填写结果原因
    @RequestMapping(value="returnBugResult")
    @ResponseBody
    public ServerResponse returnBugResult(Bug bug,HttpServletRequest request){

        User user = (User)request.getSession().getAttribute(Const.ManagerToken.SESSION);
        if(user.getRole()==1){
            bug.setStatus(2);//经理忽略
        }
        if(user.getRole()==2){
            bug.setStatus(6);//技术已解决
        }
        return iBugService.returnBugResult(bug);
    }
    //获取本项目所有研发
    @RequestMapping(value="projectTechnologyList")
    @ResponseBody
    public ServerResponse projectTechnologyList(int projectId){
        return iBugService.projectTechnologyList(projectId);
    }
    //填写结果原因
    @RequestMapping(value="saveTechnology")
    @ResponseBody
    public ServerResponse saveTechnology(Bug bug){
        return iBugService.saveTechnology(bug);
    }
    //技术接收缺陷
    @RequestMapping(value="technologyReceiveBug")
    @ResponseBody
    public ServerResponse technologyReceiveBug(Bug bug){
        return iBugService.technologyReceiveBug(bug);
    }
    //测试确认完成缺陷
    @RequestMapping(value="finishBug")
    @ResponseBody
    public ServerResponse finishBug(Bug bug){
        return iBugService.finishBug(bug);
    }

    //进入缺陷重新编辑页面
    @RequestMapping("bug_edit")
    public String bug_edit(){
        return "/bug/bug_edit";
    }
    //重新编辑缺陷
    @RequestMapping(value="editBug")
    @ResponseBody
    public ServerResponse editBug(Bug bug){
        return iBugService.editBug(bug);
    }
}
