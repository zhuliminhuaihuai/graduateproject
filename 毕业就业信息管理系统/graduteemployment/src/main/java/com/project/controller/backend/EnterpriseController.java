package com.project.controller.backend;

import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Enterprise;
import com.project.pojo.JobWithBLOBs;
import com.project.pojo.Resume;
import com.project.pojo.User;
import com.project.service.IEnterpriseService;
import com.project.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/manage/enterprise/")
public class EnterpriseController {

    @Autowired
    private IEnterpriseService iEnterpriseService;
    //进入企业查看自身列表
    @RequestMapping("enterprise_list")
    public String enterprise_list(){
        return "/enterprise/enterprise_list";
    }
    //进入管理员查看所有企业
    @RequestMapping("enterprise_list_admin")
    public String enterprise_list_admin(){
        return "/enterprise/enterprise_list_admin";
    }
    //请求企业列表
    @RequestMapping(value="enterpriseList")
    @ResponseBody
    public LayUiPageResponse<List<Enterprise>> enterpriseList(CommonVo commonVo, int page, int limit, HttpServletRequest request){
        User user  = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        commonVo.setUserCode(user.getUserCode());
        commonVo.setRole(user.getRole().toString());//传角色role到mapper层 判断不同角色显示对应的数据
        return iEnterpriseService.enterpriseList(commonVo,page,limit);
    }
    //进入企业添加页
    @RequestMapping("enterprise_add")
    public String enterprise_add(){
        return "/enterprise/enterprise_add";
    }
    //添加
    @RequestMapping(value="addEnterprise")
    @ResponseBody
    public ServerResponse addEnterprise(Enterprise enterprise,HttpServletRequest request){
        User user  = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        enterprise.setUserCode(user.getUserCode());
        enterprise.setEnterpriseCode(user.getUserCode());
        return iEnterpriseService.insert(enterprise);
    }

    //删除
    @RequestMapping(value="deleteEnterprise")
    @ResponseBody
    public ServerResponse deleteResume(Integer id){
        return iEnterpriseService.delete(id);
    }
    //进入企业详情页
    @RequestMapping("enterprise_edit")
    public String enterprise_edit(){
        return "/enterprise/enterprise_edit";
    }
    //公司信息
    @RequestMapping(value="getEnterprise")
    @ResponseBody
    public ServerResponse getEnterprise(Integer id){
        return iEnterpriseService.get(id);
    }
    //修改
    @RequestMapping(value="editEnterprise")
    @ResponseBody
    public ServerResponse editEnterprise(Enterprise enterprise){
        return iEnterpriseService.edit(enterprise);
    }

    //提交检测 一个用户只能有一个企业 待审批/审批通过不能提交 只有审核不通过才能再提交
    @RequestMapping(value="checkEnterprise")
    @ResponseBody
    public ServerResponse checkEnterprise(String userCode){
        return iEnterpriseService.checkEnterprise(userCode);
    }
    //进入企业审核页面
    @RequestMapping("enterprise_check_result")
    public String enterprise_check_result(){
        return "/enterprise/enterprise_check_result";
    }
    //审核企业 1待审核 2审核通过 3审核不通过
    @RequestMapping(value="approvalEnterprise")
    @ResponseBody
    public ServerResponse approvalEnterprise(Integer id, Integer isCheck,String checkResult){
        return iEnterpriseService.approvalEnterprise(id,isCheck,checkResult);
    }

}
