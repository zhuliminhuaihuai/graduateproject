package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.EmployInfo;
import com.project.pojo.User;
import com.project.vo.CommonVo;

import java.util.List;

public interface IThreeService {

    //分页三方列表
    LayUiPageResponse<List<EmployInfo>> employList(CommonVo commonVo, int page, int limit );


    //生成三方协议
    ServerResponse insert(EmployInfo employInfo);
}
