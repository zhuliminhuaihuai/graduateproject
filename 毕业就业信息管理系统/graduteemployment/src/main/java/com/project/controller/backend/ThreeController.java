package com.project.controller.backend;

import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.EmployInfo;
import com.project.pojo.User;
import com.project.service.IThreeService;
import com.project.util.UuidUtil;
import com.project.vo.CommonVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manage/three/")
public class ThreeController {

    @Autowired
    private IThreeService iThreeService;


    //进入三方列表页面
    @RequestMapping("three_list")
    public String three_list(){
        return "/three/three_list";
    }

    //请求三方 根据角色 学生只看到自己  管理员看到所有
    @RequestMapping(value="threeList")
    @ResponseBody
    public LayUiPageResponse<List<EmployInfo>> threeList(CommonVo commonVo, int page, int limit, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute(Const.ManagerToken.SESSION);
        if(user.getRole()==1){
            commonVo.setRole("1");
            commonVo.setUserCode(user.getUserCode());
        }
        return iThreeService.employList(commonVo,page,limit);
    }

    //进入三方列表页面
    @RequestMapping("three_add")
    public String three_add(){
        return "/three/three_add";
    }

    //提交上方协议
    @RequestMapping(value="threeAdd")
    @ResponseBody
    public ServerResponse threeAdd(EmployInfo employInfo, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute(Const.ManagerToken.SESSION);
        employInfo.setUserName(user.getRealName());
        employInfo.setUserCode(user.getUserCode());
        employInfo.setUserId(user.getUserId());
        if(user.getSex()==1){
            employInfo.setSex("男");
        }else if(user.getSex()==2){
            employInfo.setSex("女");
        }else {
            employInfo.setSex("未知");
        }
        return iThreeService.insert(employInfo);
    }

    //上传三方协议
    @RequestMapping("uploadFile")
    @ResponseBody
    public ServerResponse uploadFile(HttpServletRequest request,
                                           HttpSession session) throws IOException {
        // 转型为MultipartHttpServletRequest
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获取文件到map容器中
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        StringBuffer sb = new StringBuffer();
        String photo = "/AllWord/";
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
                    // 多张图片上传
                    this.copyFile(file.getInputStream(),
                            pictureSaveFilePath + photo + "/" ,
                            tpid + extName).replaceAll("-", "");

                    sb.append( photo +  "/" + tpid
                            + extName);
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
}
