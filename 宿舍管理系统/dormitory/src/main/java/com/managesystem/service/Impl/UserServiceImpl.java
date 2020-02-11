package com.managesystem.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.managesystem.common.Const;
import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.dao.BedRoomMapper;
import com.managesystem.dao.BuildingMapper;
import com.managesystem.dao.RoleMenuMapper;
import com.managesystem.dao.UserMapper;
import com.managesystem.pojo.BedRoom;
import com.managesystem.pojo.Building;
import com.managesystem.pojo.RoleMenu;
import com.managesystem.pojo.User;
import com.managesystem.service.IUserService;
import com.managesystem.util.MD5Utils;
import com.managesystem.util.PublicUtil;
import com.managesystem.vo.StudentQueryVo;
import com.managesystem.vo.StudentVo;
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
    private BedRoomMapper bedRoomMapper;

    @Autowired
    private BuildingMapper buildingMapper;

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
    //根据userCode 找到用户
    public ServerResponse findUserByUserCode(String userCode) {

        User user = userMapper.findUserByUserCode(userCode);
        String bedRoomCode = user.getBedroomCode();
        BedRoom bedRoom = bedRoomMapper.findBedRoomByCode(bedRoomCode);
        user.setProvince(bedRoom.getBedroomTitle());//把用户里面的省市字段拿来做房间门牌号
        String buildingCode = bedRoom.getBuildingCode();
        Building building = buildingMapper.fingBuildingByCode(buildingCode);
        user.setCity(building.getBuildingName());//把用户里面的城市字段拿来做宿舍大楼的名字
        if (user != null) {
            return ServerResponse.createBySuccess("找到用户", user);
        } else {
            return ServerResponse.createByErrorMessage("未找到用户");
        }
    }
    //根据userCode找到用户对应的房间余额
    public ServerResponse findUserByUserCodeAndBalance(String userCode) {

        User user = userMapper.findUserByUserCode(userCode);
        String bedRoomCode = user.getBedroomCode();
        BedRoom bedRoom = bedRoomMapper.findBedRoomByCode(bedRoomCode);
        user.setProvince(bedRoom.getBedroomTitle());//把用户里面的省市字段拿来做房间门牌号
        user.setDistrict(String.valueOf(bedRoom.getBedroomBalance()));//把用户里面的区域字段拿来做房间余额
        String buildingCode = bedRoom.getBuildingCode();
        Building building = buildingMapper.fingBuildingByCode(buildingCode);
        user.setCity(building.getBuildingName());//把用户里面的城市字段拿来做宿舍大楼的名字
        if (user != null) {
            return ServerResponse.createBySuccess("找到用户", user);
        } else {
            return ServerResponse.createByErrorMessage("未找到用户");
        }

    }
    //重置密码管理员
    public ServerResponse rePasswordManageUser(Integer userId) {

        int count = userMapper.rePasswordManageUser(userId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("重置成功");
        } else {
            return ServerResponse.createByErrorMessage("重置失败");
        }
    }
    //删除管理员
    public ServerResponse manageDelete(Integer userId) {

        int count = userMapper.deleteByPrimaryKey(userId);
        if (count > 0) {
            return ServerResponse.createByErrorMessage("删除成功");
        } else {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
    }
    //管理员信息详情
    public ServerResponse manageDetail(Integer userId) {

        User user = userMapper.selectByPrimaryKey(userId);
        if (user != null) {
            return ServerResponse.createBySuccess("找到管理员", user);
        } else {
            return ServerResponse.createByErrorMessage("未找到该管理员");
        }
    }
    //管理员修改保存
    public ServerResponse manageModify(User user) {

        int count = userMapper.updateByPrimaryKeySelective(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        } else {
            return ServerResponse.createByErrorMessage("修改失败");
        }
    }
    //添加管理员
    public ServerResponse manageAdd(User user) {

        String userPassword = user.getUserPassword();
        String userPasswordMD5 = MD5Utils.MD5Encode(userPassword, "UTF-8");
        user.setUserPassword(userPasswordMD5);
        user.setUserCode(PublicUtil.setCode("M"));
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
    //根据角色类型找到用户
    public ServerResponse findManageByUserRole(Integer userRole) {

        List<User> userList = userMapper.findManageByUserRole(userRole);
        if (userList.size() > 0) {
            return ServerResponse.createBySuccess("找到角色人员", userList);
        } else {
            return ServerResponse.createByErrorMessage("暂无人员");
        }
    }
    //添加学生
    public ServerResponse studentAdd(User user) {
        String userPassword = user.getUserPassword();
        String userPasswordMD5 = MD5Utils.MD5Encode(userPassword, "UTF-8");
        user.setUserPassword(userPasswordMD5);
        user.setUserCode(PublicUtil.setCode("S"));
        user.setUserCreateTime(new Date());
        user.setUserRole(0);//角色类型
        user.setUserState(1);//刚创建的学校状态是1 是未入住
        //配置学生默认菜单
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
    //未入住且对应的学院学生列表
    public LayUiPageResponse checkInStudentList(String userFaculty,String studentSex, Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<User> userList = userMapper.finduserFacultyStudent(userFaculty,studentSex);
        if (userList.size() > 0) {
            PageInfo pageInfo = new PageInfo(userList);
            return LayUiPageResponse.createBySuccess(userList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }

    }
    //找到房间里面住的学生
    public LayUiPageResponse findBedRoomStudent(Integer bedroomId, Integer page, Integer limit) {

        BedRoom bedRoom = bedRoomMapper.selectByPrimaryKey(bedroomId);
        String bedRoomCode = bedRoom.getBedroomCode();
        PageHelper.startPage(page, limit);
        List<User> userList = userMapper.findStudentByBedRoomCode(bedRoomCode);
        if (userList.size() > 0) {
            PageInfo pageInfo = new PageInfo(userList);
            return LayUiPageResponse.createBySuccess(userList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无学生");
        }
    }
    //学生列表根据条件查询
    public LayUiPageResponse studentList(StudentQueryVo studentQueryVo, Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<User> userList = userMapper.getStudentList(studentQueryVo);
        List<StudentVo> studentVoList = Lists.newArrayList();
        if (userList.size() > 0) {
            for (int i = 0; i < userList.size(); i++) {
                StudentVo studentVo = new StudentVo();
                User user = userList.get(i);
                String bedRoomCode = user.getBedroomCode();//房间编号
                if (!(bedRoomCode.isEmpty())) {
                    BedRoom bedRoom = bedRoomMapper.findBedRoomByCode(bedRoomCode);
                    String buildingCode = bedRoom.getBuildingCode();//大楼编号
                    Building building = buildingMapper.fingBuildingByCode(buildingCode);
                    studentVo.setBedroomTitle(bedRoom.getBedroomTitle());
                    studentVo.setBuildingName(building.getBuildingName());
                }
                studentVo.setUserId(user.getUserId());
                studentVo.setUserCode(user.getUserCode());
                studentVo.setUserName(user.getUserName());
                studentVo.setUserPhone(user.getUserPhone());
                studentVo.setUserCreateTime(user.getUserCreateTime());
                studentVo.setUserFaculty(user.getUserFaculty());
                studentVo.setUserState(user.getUserState());
                studentVo.setHeadimg(user.getHeadimg());
                studentVoList.add(studentVo);
            }
            PageInfo pageInfo = new PageInfo(userList);
            return LayUiPageResponse.createBySuccess(studentVoList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("没有数据");
        }


    }

}
