package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.EmployInfoMapper;
import com.project.pojo.EmployInfo;
import com.project.pojo.User;
import com.project.service.IThreeService;
import com.project.util.PublicUtil;
import com.project.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ThreeServiceImpl implements IThreeService {

    @Autowired
    private EmployInfoMapper employInfoMapper;
    @Override
    public LayUiPageResponse<List<EmployInfo>> employList(CommonVo commonVo, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<EmployInfo> employInfoList = employInfoMapper.employList(commonVo);
        if(employInfoList.size()==0){
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
        PageInfo pageInfo = new PageInfo(employInfoList);
        return LayUiPageResponse.createBySuccess(employInfoList,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }

    @Override
    public ServerResponse insert(EmployInfo employInfo) {
        employInfo.setEmpoloyCode(PublicUtil.setCode("E"));
        employInfo.setCreateTime(new Date());
        if(employInfoMapper.insertSelective(employInfo)>0){
            return ServerResponse.createBySuccessMessage("提交成功");
        }
        return ServerResponse.createByErrorMessage("提交失败");
    }
}
