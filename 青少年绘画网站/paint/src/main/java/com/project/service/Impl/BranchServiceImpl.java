package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.BranchMapper;
import com.project.dao.UserMapper;
import com.project.pojo.Branch;
import com.project.pojo.User;
import com.project.service.IBranchService;
import com.project.util.MD5Utils;
import com.project.util.PublicUtil;
import com.project.vo.CommonVo;
import com.sun.prism.impl.paint.PaintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BranchServiceImpl implements IBranchService {

    @Autowired
    private BranchMapper branchMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public LayUiPageResponse<List<Branch>> branchList(CommonVo commonVo, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Branch> branchList = branchMapper.branchList(commonVo);
        if(branchList.size()==0){
            return LayUiPageResponse.createByErrorMessage("暂无机构");
        }
        PageInfo pageInfo = new PageInfo(branchList);
        return LayUiPageResponse.createBySuccess(branchList,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }

    @Override
    public ServerResponse insert(Branch branch,User user) {
        if(branchMapper.checkBranchName(branch.getBranchName())>0){
            return ServerResponse.createByErrorMessage("机构名已存在");
        }
        if(userMapper.checkUserName(user.getUserName())>0){
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        String userCode = PublicUtil.setCode("B");//设置编号
        branch.setBranchCode(userCode);//机构编号
        branch.setCreateTime(new Date());//设置创建时间为当前时间
        user.setUserCode(userCode);//这里机构编号和用户编号相同
        user.setCreateTime(new Date());//用户当前创建时间
        String pass = MD5Utils.MD5Encode(user.getPassword(),"utf-8");
        user.setPassword(pass);
        if(branchMapper.insertSelective(branch)>0&&userMapper.insertSelective(user)>0){
            return ServerResponse.createBySuccessMessage("创建成功");
        }
        return ServerResponse.createByErrorMessage("创建失败");
    }

    @Override
    public ServerResponse delete(Integer id,String userCode) {
        if(branchMapper.deleteByPrimaryKey(id)>0&&userMapper.deleteByUserCode(userCode)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse edit(Branch branch) {
        String branchName = branch.getBranchName();
        int id = branch.getId();
        if(branchMapper.checkbranchNameExSelf(branchName,id)>0){
            return ServerResponse.createByErrorMessage("机构名已存在");
        }
        if(branchMapper.updateByPrimaryKeySelective(branch)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse get(Integer id) {
        Branch branch  = branchMapper.selectByPrimaryKey(id);
        if(branch!=null){
            return ServerResponse.createBySuccess(branch);
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse selectBranchList(CommonVo commonVo) {
        List<Branch> branchList = branchMapper.branchList(commonVo);
        return ServerResponse.createBySuccess(branchList);
    }
}
