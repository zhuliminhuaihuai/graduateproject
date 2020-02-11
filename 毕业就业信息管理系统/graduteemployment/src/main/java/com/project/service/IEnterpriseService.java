package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.EmployInfo;
import com.project.pojo.Enterprise;
import com.project.vo.CommonVo;

import java.util.List;

public interface IEnterpriseService {

    //公司列表
    LayUiPageResponse<List<Enterprise>> enterpriseList(CommonVo commonVo, int page, int limit);

    //添加公司
    ServerResponse insert(Enterprise enterprise);
    //修改
    ServerResponse edit(Enterprise enterprise);
    //删除
    ServerResponse delete(Integer id);
    //获取公司详情
    ServerResponse get(Integer id);
    //检测用户是否能提交公司企业信息
    ServerResponse checkEnterprise(String userCode);
    //审核企业公司
    ServerResponse approvalEnterprise(Integer id, Integer isCheck,String checkResult);
}
