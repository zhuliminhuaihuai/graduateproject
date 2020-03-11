package com.manage.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.common.Const;
import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.dao.UserMapper;
import com.manage.pojo.User;
import com.manage.service.IUserService;
import com.manage.util.MD5Utils;
import com.manage.util.PublicUtil;
import com.manage.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    //登录
    @Override
    public ServerResponse<User> login(String username, String password) {
        int userCount = userMapper.checkUserName(username);
        if (userCount == 0) {
            return ServerResponse.createByErrorMessage("该用户不存在！");
        }
        String passwordMD5 = MD5Utils.MD5Encode(password, "UTF-8");

        User user = userMapper.login(username, passwordMD5);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误！");
        }
        user.setUserPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功！", user);
    }

    //用户注册
    @Override
    public ServerResponse register(String userName, String userPassword, String userPhone, Integer userRole) {
        int userCount = userMapper.checkUserName(userName);
        if (userCount > 0) {
            return ServerResponse.createByErrorMessage("该用户名已被注册");
        }
        String passwordMD5 = MD5Utils.MD5Encode(userPassword, "UTF-8");
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(passwordMD5);
        user.setUserPhone(userPhone);
        user.setUserRole(userRole);
        user.setUserCode(PublicUtil.setCode("U"));
        user.setUserCreateTime(new Date());
        user.setUserProvice("0");

        int count = userMapper.insertSelective(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("注册成功");
        } else {
            return ServerResponse.createByErrorMessage("注册失败");
        }
    }
    //用户列表
    @Override
    public LayUiPageResponse userList(UserVo userVo, Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<User> userList = userMapper.getUserList(userVo);
        if (userList.size() > 0) {
            PageInfo pageInfo = new PageInfo(userList);
            return LayUiPageResponse.createBySuccess(userList, pageInfo.getTotal(), page, limit);
        }else{
            return LayUiPageResponse.createByErrorMessage("暂无数据！");
        }


    }
    //添加用户
    @Override
    public ServerResponse addUser(User user) {

        String passwordMD5 = MD5Utils.MD5Encode(user.getUserPassword(), "UTF-8");
        user.setUserPassword(passwordMD5);
        user.setUserCode(PublicUtil.setCode("U"));
        user.setUserCreateTime(new Date());
        int count = userMapper.insertSelective(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("添加成功");
        } else {
            return ServerResponse.createByErrorMessage("添加失败");
        }
    }
    //删除用户
    @Override
    public ServerResponse deleteUser(Integer userId) {

        int count = userMapper.deleteByPrimaryKey(userId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }
    //批量删除用户
    @Override
    public ServerResponse someDeleteUser(String ids) {

        int i = ids.indexOf("[");
        int j = ids.indexOf("]");
        String s1 = ids.substring(i + 1, j);
        String[] idsArray= s1.split(",");
        List<Integer> idList =new ArrayList();
        for(String s : idsArray){
            Integer k = Integer.parseInt(s);
            idList.add(k);
        }
        int count = userMapper.deleteSomeUser(idList);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }
    //用户详情
    public ServerResponse detailUser(Integer userId) {

        User user = userMapper.selectByPrimaryKey(userId);
        if (user != null) {
            return ServerResponse.createBySuccess("找到用户", user);
        } else {
            return ServerResponse.createByErrorMessage("未找到用户");
        }
    }

    @Override
    public ServerResponse isHaveRealName(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        User user1 = userMapper.selectByPrimaryKey(user.getUserId());
        if (user1.getUserFindPassword() == null) {
            return ServerResponse.createByErrorMessage("您还未实名");
        } else {
            return ServerResponse.createBySuccessMessage("已经实名");
        }
    }

    //保存用户
    @Override
    public ServerResponse saveUser(HttpServletRequest request, User user) {

        User user1 = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        HttpSession session = request.getSession();

        if (!user1.getUserName().equals(user.getUserName())) {
            int checkCount = userMapper.checkUserName(user.getUserName());
            if (checkCount > 0) {
                return ServerResponse.createByErrorMessage("用户名已存在，请重新选择");
            }
        }
        user.setUserUpdateTime(new Date());
        int count = userMapper.updateByPrimaryKeySelective(user);
        if (count > 0) {
            User user2 = userMapper.selectByPrimaryKey(user1.getUserId());
            session.setAttribute(Const.ManagerToken.SESSION, user2);
             return ServerResponse.createBySuccessMessage("保存成功");
        } else {
            return ServerResponse.createByErrorMessage("保存失败");
        }

    }

    @Override
    public ServerResponse findTenant(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        List<User> userList = new ArrayList<>();

        if (user.getUserRole() == Const.Role.ROLE_ADMIN) {
            userList = userMapper.getTenant(0);
            if (userList.size() == 0) {
                return ServerResponse.createByErrorMessage("暂无房东");
            } else {
                return ServerResponse.createBySuccess("找到房东", userList);
            }
        } else {
            userList.add(user);
            return ServerResponse.createBySuccess("找到房东", userList);
        }

    }

    //重置密码
    public ServerResponse rePassword(Integer userId) {

        User user = userMapper.selectByPrimaryKey(userId);
        user.setUserPassword("202cb962ac59075b964b07152d234b70");
        int count = userMapper.updateByPrimaryKeySelective(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("重置成功");
        } else {
            return ServerResponse.createByErrorMessage("重置失败");
        }
    }
    @Override
    public ServerResponse editPass(Integer userId,String oldPass,String newPass) {
        String oPass = MD5Utils.MD5Encode(oldPass,"utf-8");
        int pcount = userMapper.checkUserPass(oPass,userId);
        if(pcount==0){
            return ServerResponse.createByErrorMessage("密码不正确");
        }
        String pass = MD5Utils.MD5Encode(newPass,"utf-8");
        User user = new User();
        user.setUserId(userId);
        user.setUserPassword(pass);
        int count = userMapper.updateByPrimaryKeySelective(user);
        if(count>0){
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }
}
