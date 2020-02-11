package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.EnterpriseMapper;
import com.project.pojo.EmployInfo;
import com.project.pojo.Enterprise;
import com.project.service.IEnterpriseService;
import com.project.util.PublicUtil;
import com.project.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EnterpriseServiceImpl implements IEnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public LayUiPageResponse<List<Enterprise>> enterpriseList(CommonVo commonVo, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Enterprise> enterpriseList = enterpriseMapper.enterpriseList(commonVo);
        if(enterpriseList.size()==0){
            return LayUiPageResponse.createByErrorMessage("还未注册");
        }
        PageInfo pageInfo = new PageInfo(enterpriseList);
        return LayUiPageResponse.createBySuccess(enterpriseList,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }

    @Override
    public ServerResponse insert(Enterprise enterprise) {
        enterprise.setCreateTime(new Date());
        enterprise.setIsCheck(1);
        String enterpriseName = enterprise.getEnterpriseName();
        int name = enterpriseMapper.chekcEName(enterpriseName);
        if(name>0){
            return ServerResponse.createBySuccessMessage("企业已存在");
        }
        int count = enterpriseMapper.insertSelective(enterprise);
        if(count>0){
            return ServerResponse.createBySuccessMessage("注册成功");
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse edit(Enterprise enterprise) {
        int count = enterpriseMapper.updateByPrimaryKeyWithBLOBs(enterprise);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse delete(Integer id) {
        int count = enterpriseMapper.deleteByPrimaryKey(id);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse get(Integer id) {
       Enterprise enterprise = enterpriseMapper.selectByPrimaryKey(id);
       if(enterprise!=null){
           return ServerResponse.createBySuccess(enterprise);
       }
       return ServerResponse.createByError();
    }

    @Override
    public ServerResponse checkEnterprise(String userCode) {
        List<Enterprise> enterpriseList = enterpriseMapper.enterpriseByUserCode(userCode);
        if(enterpriseList.size()>0){
            return ServerResponse.createByError();
        }
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse approvalEnterprise(Integer id, Integer isCheck,String checkResult) {
        Enterprise enterprise = new Enterprise();
        enterprise.setId(id);
        enterprise.setIsCheck(isCheck);
        enterprise.setCheckResult(checkResult);
        int count = enterpriseMapper.updateByPrimaryKeySelective(enterprise);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }
}
