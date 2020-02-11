package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.UserMapper;
import com.project.pojo.User;
import com.project.service.IUserService;
import com.project.util.MD5Utils;
import com.project.util.PublicUtil;
import com.project.vo.CommonVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse checkLogin(String userName, String password, HttpServletRequest request) {
        int resultCount = userMapper.checkUserName(userName);
        if(resultCount == 0 ){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        String md5Password = MD5Utils.MD5Encode(password, "UTF-8");
        User user  = userMapper.selectLogin(userName,md5Password);
        if(user == null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        request.getSession().setAttribute(Const.ManagerToken.SESSION,user);//存储用户session
        request.getSession().setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
        return ServerResponse.createBySuccess("登录成功",user);
    }

    @Override
    public LayUiPageResponse<List<User>> userList(CommonVo commonVo, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<User> studentList = userMapper.userList(commonVo);
        if(studentList.size()==0){
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
        PageInfo pageInfo = new PageInfo(studentList);
        return LayUiPageResponse.createBySuccess(studentList,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }

    @Override
    public ServerResponse insert(User user) {
        user.setUserCode(PublicUtil.setCode("S"));
        user.setCreateTime(new Date());
        String pass = MD5Utils.MD5Encode(user.getPassword(),"utf-8");
        user.setPassword(pass);
        String userName = user.getUserName();
        String mobile = user.getMobilePhone();
        int ucount  = userMapper.checkUserName(userName);
        if(ucount>0){
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        int mcount = userMapper.checkUserPhone(mobile);
        if(mcount>0){
            return ServerResponse.createByErrorMessage("手机已存在");
        }
        int count = userMapper.insertSelective(user);
        if(count>0){
            return ServerResponse.createBySuccessMessage("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }

    @Override
    public ServerResponse delete(Integer id) {
        int count = userMapper.deleteByPrimaryKey(id);
        if(count>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse edit(User user) {
        String userName = user.getUserName();
        String mobile = user.getMobilePhone();
        Integer userId = user.getUserId();
        int ucount  = userMapper.checkUserNameExSelf(userName,userId);
        if(ucount>0){
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        int mcount = userMapper.checkUserPhoneExSelf(mobile,userId);
        if(mcount>0){
            return ServerResponse.createByErrorMessage("手机已存在");
        }
        int count = userMapper.updateByPrimaryKeySelective(user);
        if(count>0){
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse get(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        if(user!=null){
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByError();
    }

   @Override
    public ServerResponse resetPass(Integer id) {
        String pass = MD5Utils.MD5Encode("123456","utf-8");
        User user = new User();
        user.setUserId(id);
        user.setPassword(pass);
        int count = userMapper.updateByPrimaryKeySelective(user);
        if(count>0){
            return ServerResponse.createBySuccessMessage("重置成功");
        }
        return ServerResponse.createByErrorMessage("重置失败");
    }

    @Override
    public ServerResponse editPass(Integer userId,String oldPass,String newPass) {
        String oPass = MD5Utils.MD5Encode(oldPass,"utf-8");
        int pcount = userMapper.checkUserPass(oPass,userId);
        if(pcount==0){
            return ServerResponse.createByErrorMessage("旧密码错误！请正确输入");
        }
        String pass = MD5Utils.MD5Encode(newPass,"utf-8");
        User user = new User();
        user.setUserId(userId);
        user.setPassword(pass);
        int count = userMapper.updateByPrimaryKeySelective(user);
        if(count>0){
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse getUserInfoByUserCode(String userCode) {
        User user = userMapper.selectByUserCode(userCode);
        if(user!=null){
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse selectTeacherList(int branchId) {
        List<User> users = userMapper.selectTeacherList(branchId);
        return ServerResponse.createBySuccess(users);
    }


}
