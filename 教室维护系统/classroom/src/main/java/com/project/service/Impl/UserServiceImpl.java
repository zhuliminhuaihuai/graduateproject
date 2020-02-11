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
import com.project.vo.UserQueryVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    //用户登录
    @Override
    public ServerResponse login(HttpServletRequest request, String userName, String password) {

        int userCount = userMapper.checkUserName(userName);
        if (userCount == 0) {
            return ServerResponse.createByErrorMessage("该用户不存在！");
        }
        String passwordMD5 = MD5Utils.MD5Encode(password, "UTF-8");

        User user = userMapper.login(userName, passwordMD5);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误！");
        }
        user.setUserPassword(StringUtils.EMPTY);
        request.getSession().setAttribute(Const.ManagerToken.SESSION,user);//存储用户session
        request.getSession().setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
        return ServerResponse.createBySuccess("登录成功！", user);
    }
    //用户列表包含查询
    @Override
    public LayUiPageResponse getUserList(Integer page, Integer limit, UserQueryVo userQueryVo) {

        PageHelper.startPage(page, limit);
        List<User> userList = userMapper.getUserListByCondition(userQueryVo);
        if (userList.size() > 0) {
            PageInfo pageInfo = new PageInfo(userList);
            return LayUiPageResponse.createBySuccess(userList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无用户!!!");
        }
    }
    //添加学生
    @Override
    public ServerResponse addUser(User user) {

        int checkCount = userMapper.checkUserName(user.getUserName());
        if (checkCount > 0) {
            return ServerResponse.createByErrorMessage("该用户名已被注册!");
        }
        user.setUserRole(Const.Role.ROLE_SYSTEM);
        user.setUserPassword(MD5Utils.MD5Encode(user.getUserPassword(),"UTF-8"));
        user.setUserCode(PublicUtil.setCode("S"));
        user.setUserCreateTime(new Date());
        int count = userMapper.insertSelective(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("添加成功!");
        } else {
            return ServerResponse.createByErrorMessage("添加失败!");
        }
    }
    //用户详情
    @Override
    public ServerResponse detailUser(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user != null) {
            return ServerResponse.createBySuccess("找到用户", user);
        } else {
            return ServerResponse.createByErrorMessage("未找到用户");
        }
    }
    //用户保存
    @Override
    public ServerResponse saveUser(User user) {

        user.setUserUpdateTime(new Date());
        int count = userMapper.updateByPrimaryKeySelective(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("保存成功！");
        } else {
            return ServerResponse.createByErrorMessage("保存失败！");
        }
    }
    //重置密码
    @Override
    public ServerResponse reSetAgainPassword(Integer userId) {

        int count = userMapper.reSetAgainPassword(userId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("密码重置成功，重置为123");
        } else {
            return ServerResponse.createByErrorMessage("重置失败");
        }
    }
    //删除用户
    @Override
    public ServerResponse deleteUserByUserId(Integer userId) {

        int count = userMapper.deleteByPrimaryKey(userId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功!!");
        } else {
            return ServerResponse.createByErrorMessage("删除失败!!");
        }
    }
    //修改密码
    @Override
    public ServerResponse modifyUserPassword(String oldPssword, String newPassword, Integer userId) {


        String oldPasswordMD5 = MD5Utils.MD5Encode(oldPssword, "UTF-8");
        String newPasswordMD5 = MD5Utils.MD5Encode(newPassword, "UTF-8");

        int checkCount = userMapper.checkPassword(userId, oldPasswordMD5);
        if (checkCount > 0) {
            int count = userMapper.updatePassword(userId, newPasswordMD5);
            if (count > 0) {
                return ServerResponse.createBySuccessMessage("密码修改成功，请重新登录!!!");
            } else {
                return ServerResponse.createByErrorMessage("密码修改失败!!!");
            }
        } else {
            return ServerResponse.createByErrorMessage("密码输入错误!请重新输入");
        }


    }

}
