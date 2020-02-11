package com.managesystem.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.managesystem.common.Const;
import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.dao.RoleMenuMapper;
import com.managesystem.dao.UserMapper;
import com.managesystem.pojo.RoleMenu;
import com.managesystem.pojo.User;
import com.managesystem.service.IUserService;
import com.managesystem.util.MD5Utils;
import com.managesystem.util.PublicUtil;
import com.managesystem.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    //登录
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

    //修改密码
    public ServerResponse modifyPassword(String userCode, String oldpassword, String newpassword) {

        //将密码加密后的字符串传入数据库判断密码是否正确
        String passwordMD5 = MD5Utils.MD5Encode(oldpassword, "UTF-8");
        int count = userMapper.checkPassword(userCode, passwordMD5);
        if (count > 0) {
            String newPasswordMD5 = MD5Utils.MD5Encode(newpassword, "UTF-8");
            int modifyCount = userMapper.modifyPassword(userCode, newPasswordMD5);
            if (modifyCount > 0) {
                return ServerResponse.createBySuccessMessage("密码修改成功！");
            } else {
                return ServerResponse.createByErrorMessage("密码修改失败！");
            }
        } else {
            return ServerResponse.createByErrorMessage("密码错误！");
        }
    }

    //用户列表
    public LayUiPageResponse<List<User>> getUserList(UserVo userVo, Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<User> userList = Lists.newArrayList();
        userList = userMapper.getUserList(userVo);
        if (userList.size() == 0) {
            LayUiPageResponse.createByErrorMessage("暂无数据");
        }
        PageInfo pageInfo = new PageInfo(userList);
        return LayUiPageResponse.createBySuccess(userList, pageInfo.getTotal(), page, limit);
    }

    //简单注册
    public ServerResponse register(User user) {

        int checkCount = userMapper.checkUserName(user.getUserName());
        if (checkCount > 0) {
            return ServerResponse.createByErrorMessage("用户名已存在");
        } else {
            user.setUserRole(Const.Role.ROLE_CUSTOMER);
            user.setUserCreateTime(new Date());
            user.setUserCode(PublicUtil.setCode("U"));
            user.setUserPassword(MD5Utils.MD5Encode(user.getUserPassword(), "UTF-8"));
            user.setUserFindPassword(MD5Utils.MD5Encode(user.getUserFindPassword(), "UTF-8"));
            int count = userMapper.insertSelective(user);
            if (count > 0) {
                //配置客户默认菜单
                int[] idsArray = Const.ManagerToken.DefaultPermissions;
                List<Integer> idList =new ArrayList();
                for(int s : idsArray){
                    idList.add(s);
                }
                for (int i = 0; i < idList.size(); i++) {
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setUserCode(user.getUserCode());
                    roleMenu.setMenuId(idList.get(i));
                    roleMenuMapper.insertSelective(roleMenu);
                }
                return ServerResponse.createBySuccessMessage("注册成功");
            } else {
                return ServerResponse.createByErrorMessage("注册失败");
            }
        }

    }

    //添加新用户
    public ServerResponse addUser(User user) {

        String userPassword = user.getUserPassword();
        String userFindPassword = user.getUserFindPassword();
        String userPasswordMD5 = MD5Utils.MD5Encode(userPassword, "UTF-8");
        String userFindPasswordMD5 = MD5Utils.MD5Encode(userFindPassword, "UTF-8");
        user.setUserPassword(userPasswordMD5);
        user.setUserFindPassword(userFindPasswordMD5);
        user.setUserCode(PublicUtil.setCode("U"));
        user.setUserCreateTime(new Date());
        int count = userMapper.checkUserName(user.getUserName());
        if (count > 0) {
            return ServerResponse.createByErrorMessage("用户名已存在");
        } else {
            int addCount = userMapper.insertSelective(user);
            if (addCount > 0) {
                return ServerResponse.createBySuccessMessage("添加成功！");
            } else {
                return ServerResponse.createByErrorMessage("添加失败！");
            }
        }

    }
    //获取当前登陆系统的人员信息
    public ServerResponse findCurrentUser(String userCode) {

        User user = userMapper.findUserByUserCode(userCode);
        if (user != null) {
            return ServerResponse.createBySuccess("找到用户！", user);
        } else {
            return ServerResponse.createByErrorMessage("没有此用户");
        }
    }

    //根据角色类型查找用户
    public ServerResponse findUserListByRole(Integer userRole) {
        List<User> userList = userMapper.findUserByRole(userRole);
        if (userList.size() > 0) {
            return ServerResponse.createBySuccess("找到人员", userList);
        } else {
            return ServerResponse.createByErrorMessage("未找到相应人员");
        }
    }

    //用户详情
    public ServerResponse userDetail(Integer userId) {

        User user = userMapper.selectByPrimaryKey(userId);
        if (user != null) {
            return ServerResponse.createBySuccess("找到该用户", user);
        } else {
            return ServerResponse.createByErrorMessage("暂无此用户");
        }

    }

    //修改用户信息
    public ServerResponse userModify(User user) {

        if (user == null) {
            return ServerResponse.createByErrorMessage("数据有误");
        } else {
            user.setUserUpdateTime(new Date());
            int count = userMapper.updateByPrimaryKeySelective(user);
            if (count > 0) {
                return ServerResponse.createBySuccessMessage("修改成功");
            } else {
                return ServerResponse.createByErrorMessage("修改失败");
            }
        }

    }

    //删除用户
    public ServerResponse userDelete(Integer userId) {
        int count = userMapper.deleteByPrimaryKey(userId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }

    //重置用户密码
    public ServerResponse userRePassword(Integer userId) {
        int count = userMapper.userRePassword(userId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("重置成功");
        } else {
            return ServerResponse.createByErrorMessage("重置失败");
        }


    }

    //查找出所有的摄影师
    public ServerResponse findAllPhotographer() {

        List<User> userList = userMapper.findAllPhotographer();
        if (userList.size() > 0) {
            return ServerResponse.createBySuccess("找到所有摄影师", userList);
        } else {
            return ServerResponse.createByErrorMessage("暂无摄影师");
        }
    }


}
