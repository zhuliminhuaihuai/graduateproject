package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Branch;
import com.project.pojo.User;
import com.project.vo.CommonVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IBranchService {

    //分页列表
    LayUiPageResponse<List<Branch>> branchList(CommonVo commonVo, int page, int limit);
    //增
    ServerResponse insert(Branch branch,User user);
    //删
    ServerResponse delete(Integer id,String userCode);
    //改
    ServerResponse edit(Branch branch);
    //查 -根据ID
    ServerResponse get(Integer id);

    //获取所有机构列表
    ServerResponse selectBranchList(CommonVo commonVo);



}
