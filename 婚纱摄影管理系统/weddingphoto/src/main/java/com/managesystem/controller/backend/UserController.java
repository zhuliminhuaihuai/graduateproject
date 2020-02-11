package com.managesystem.controller.backend;
import com.managesystem.common.Const;
import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.User;
import com.managesystem.service.IUserService;
import com.managesystem.util.DateUtil;
import com.managesystem.util.ImageCompression;
import com.managesystem.util.UuidUtil;
import com.managesystem.vo.UserVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manage/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;


    //用户登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse login(HttpServletRequest request, String username, String password) {
        System.out.println("进入验证用户名与密码后台---");
        HttpSession session = request.getSession();
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            User user = response.getData();
            if (user == null) {
                return ServerResponse.createByErrorMessage("用户名或者密码错误");
            }
            if (user.getUserRole() == Const.Role.ROLE_ADMIN) {
                session.setAttribute(Const.ManagerToken.SESSION, user);
                session.setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
                return ServerResponse.createBySuccessMessage("登陆成功");
            } else if (user.getUserRole() == Const.Role.ROLE_CUSTOMER) {
                session.setAttribute(Const.ManagerToken.SESSION, user);
                session.setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
                return ServerResponse.createBySuccessMessage("登陆成功");
            } else if (user.getUserRole() == Const.Role.ROLE_PHOTOGRAPHER) {
                session.setAttribute(Const.ManagerToken.SESSION, user);
                session.setMaxInactiveInterval(Const.ManagerToken.MANAGER_SESSION_EXTIME);
                return ServerResponse.createBySuccessMessage("登陆成功");
            }else {
                return ServerResponse.createByErrorMessage("不是系统人员,无法登录");
            }
        } else {
            return ServerResponse.createByErrorMessage("用户名或者密码错误");
        }
    }

    //修改密码
    @RequestMapping("modifyPassword")
    @ResponseBody
    public ServerResponse modifyPassword(HttpServletRequest request, String oldpassword, String newpassword) {
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        String userCode = user.getUserCode();
        return iUserService.modifyPassword(userCode, oldpassword, newpassword);
    }

    //用户列表
    @RequestMapping("getUserList")
    @ResponseBody
    public LayUiPageResponse<List<User>> getUserList(UserVo userVo, Integer page, Integer limit) {
        return iUserService.getUserList(userVo, page, limit);
    }

    //添加新用户
    @RequestMapping("addUser")
    @ResponseBody
    public ServerResponse addUser(User user ,String userBirthday1) throws Exception {
        user.setUserBirthday(DateUtil.stringToDate(userBirthday1,"yyyy-MM-dd"));
        return iUserService.addUser(user);
    }

    //简单注册
    @RequestMapping("register")
    @ResponseBody
    public ServerResponse register(User user) {
        return iUserService.register(user);
    }
    //获取当前登陆系统的人员信息
    @RequestMapping("findCurrentUser")
    @ResponseBody
    public ServerResponse findCurrentUser(String userCode) {
        return iUserService.findCurrentUser(userCode);
    }
    //根据角色类型查找用户
    @RequestMapping("findUserListByRole")
    @ResponseBody
    public ServerResponse findUserListByRole(Integer userRole) {
        return iUserService.findUserListByRole(userRole);
    }

    //根据id查询user(详情)
    @RequestMapping("userDetail")
    @ResponseBody
    public ServerResponse userDetail(Integer userId) {
        return iUserService.userDetail(userId);
    }

    //查找出所有的摄影师
    @RequestMapping("findAllPhotographer")
    @ResponseBody
    public ServerResponse findAllPhotographer() {
        return iUserService.findAllPhotographer();
    }
    //上传头像
    @RequestMapping("uploadImg")
    @ResponseBody
    public ServerResponse uploadImg(HttpServletRequest request,
                                    HttpSession session) throws IOException {
        User user = (User) session.getAttribute(Const.ManagerToken.SESSION);
        // 转型为MultipartHttpServletRequest
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获取文件到map容器中
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        StringBuffer sb = new StringBuffer();
        String photo = "/AllImg/BranchImg/";
        String pictureSaveFilePath = request.getSession().getServletContext().getRealPath("upload");
        if (fileMap != null) {
            for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
                MultipartFile file = entity.getValue();
                if (file != null && !file.isEmpty()) {
                    String tpid = UuidUtil.get32UUID();
                    // 扩展名格式：
                    String extName = "";
                    if (file.getOriginalFilename().lastIndexOf(".") >= 0) {
                        extName = file.getOriginalFilename().substring(
                                file.getOriginalFilename().lastIndexOf("."));
                    }
                    String days = DateUtil.getDays();
                    // 多张图片上传
                    this.copyFile(file.getInputStream(),
                            pictureSaveFilePath + photo + days ,
                            tpid + extName).replaceAll("-", "");

                    sb.append(photo + days + "/" +   tpid
                            + extName);

                    // ----图片压缩 s-m-l 型
                    String imgSrc = pictureSaveFilePath + photo + days + "/"
                            + tpid + extName;
                    String imgS = photo + days + "/" + tpid + "_s"
                            + extName;
                    String imgM = photo + days + "/"  + tpid + "_m"
                            + extName;
                    String imgL = photo + days + "/"  + tpid + "_l"
                            + extName;

                    // ----获取图片的宽和高
                    File picture = new File(imgSrc);
                    BufferedImage sourceImg = ImageIO.read(picture);
                    float width = sourceImg.getWidth();
                    float height = sourceImg.getHeight();
                    // -----设置图片的压缩百分比
                    int scale = 0;
                    if (width <= 120 || height <= 64) {
                        scale = 100;
                    } else {
                        scale = (int) (120 / width * 100);
                    }
                    ImageCompression.scaleImage(imgSrc, pictureSaveFilePath
                            + imgS, scale);
                    if (width <= 240 || height <= 100) {
                        scale = 100;
                    } else {
                        scale = (int) (240 / width * 100);
                    }
                    ImageCompression.scaleImage(imgSrc, pictureSaveFilePath
                            + imgM, scale);
                    if (width <= 480 || height <= 120) {
                        scale = 100;
                    } else {
                        scale = (int) (480 / width * 100);
                    }
                    ImageCompression.scaleImage(imgSrc, pictureSaveFilePath
                            + imgL, scale);

                } else {
                    sb.append("");
                }
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uri", sb.toString());
        System.out.println("map:" + map);
        return ServerResponse.createBySuccess(map);
    }
    /**
     * 写文件到当前目录的upload目录中
     *
     * @param
     * @param
     * @throws IOException
     */
    private String copyFile(InputStream in, String dir, String realName)
            throws IOException {
        File file = new File(dir, realName);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        FileUtils.copyInputStreamToFile(in, file);
        return realName;
    }

    //修改用户信息
    @RequestMapping("userModify")
    @ResponseBody
    public ServerResponse userModify(User user,String userBirthday1) {
        user.setUserBirthday(DateUtil.stringToDate(userBirthday1, DateUtil.DF_DATE));
        return iUserService.userModify(user);
    }

    //删除用户
    @RequestMapping("userDelete")
    @ResponseBody
    public ServerResponse userDelete(Integer userId) {
        return iUserService.userDelete(userId);
    }

    //重置用户密码
    @RequestMapping("userRePassword")
    @ResponseBody
    public ServerResponse userRePassword(Integer userId) {
        return iUserService.userRePassword(userId);
    }

    /***********************跳转页面或者打开界面*********************************/
    //跳转修改密码界面
    @RequestMapping("jumpModifyPassword.html")
    public String jumpModifyPasswordHtml() {
        return "user/modify_password";
    }

    //跳转index页面
    @RequestMapping("jumpIndex.html")
    public String jumpIndexHtml() {
        return "index";
    }

    //打开右侧界面
    @RequestMapping("openMain.html")
    public String openMainHtml() {
        return "main";
    }

    //退出
    @RequestMapping("jumpLogin.html")
    public String jumpLoginHtml() {
        return "login";
    }

    //跳转打开用户管理页面
    @RequestMapping("jumpUserManage.html")
    public String jumpUserManageHtml() {
        return "user/user_manage";
    }

    //打开添加新用户界面
    @RequestMapping("openAddUser.html")
    public String openAddUserHtml() {
        return "user/user_add";
    }
    //打开用户详情
    @RequestMapping("openUserDetail.html")
    public String openUserDetailHtml() {
        return "user/user_detail";
    }

    //打开用户修改
    @RequestMapping("openUserModify.html")
    public String openUserModifyHtml() {
        return "user/user_modify";
    }

    //打开当前登陆者的个人资料
    @RequestMapping("openUserPersonalMessage.html")
    public String openUserPersonalMessageHtml() {
        return "user/user_personal_message";
    }









}
