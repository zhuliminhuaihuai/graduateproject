package com.project.controller.backend;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Branch;
import com.project.pojo.User;
import com.project.service.IBranchService;
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
@RequestMapping("/manage/branch/")
public class BranchController {
    @Autowired
    private IBranchService iBranchService;

    //进入机构列表
    @RequestMapping(value = "branch_list")
    public String branch_list(){
        return "branch/branch_list";
    }
    //请求机构列表
    @RequestMapping(value="branchList")
    @ResponseBody
    public LayUiPageResponse<List<Branch>> branchList(CommonVo commonVo, int page, int limit){
        return iBranchService.branchList(commonVo,page,limit);
    }

    //进入添加机构和用户
    @RequestMapping(value = "branch_add")
    public String branch_add(){
        return "/branch/branch_add";
    }
    //生成机构和用户
    @RequestMapping(value="addBranch")
    @ResponseBody
    public ServerResponse addBranch(Branch branch,User user, String birthdays,String branchCreateTimes)throws Exception{
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        if(birthdays.equals("")){
            user.setBirthday(simple.parse("1998-06-01"));
        }else {
            user.setBirthday(simple.parse(birthdays));
        }
        if(branchCreateTimes.equals("")){
            branch.setBranchCreateTime(simple.parse("1998-06-01"));
        }else {
            branch.setBranchCreateTime(simple.parse(branchCreateTimes));
        }
        return iBranchService.insert(branch,user);
    }

    //进入机构修改
    @RequestMapping(value = "branch_edit")
    public String branch_edit(){
        return "/branch/branch_edit";
    }
    //进入机构管理者修改
    @RequestMapping(value = "branch_user_edit")
    public String branch_user_edit(){
        return "/branch/branch_user_edit";
    }
    //获取机构信息
    @RequestMapping(value="getBranchInfo")
    @ResponseBody
    public ServerResponse getBranchInfo(Integer id){
        return iBranchService.get(id);
    }
    //修改
    @RequestMapping(value="editBranch")
    @ResponseBody
    public ServerResponse editBranch(Branch branch,String branchCreateTimes)throws Exception{
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        if(branchCreateTimes.equals("")){
            branch.setBranchCreateTime(simple.parse("1998-06-01"));
        }else {
            branch.setBranchCreateTime(simple.parse(branchCreateTimes));
        }
        return iBranchService.edit(branch);
    }

    //删除机构同时删除机构管理者
    @RequestMapping(value="deleteBranch")
    @ResponseBody
    public ServerResponse deleteBranch(Integer id,String userCode){
        return iBranchService.delete(id,userCode);
    }

    //获取所有机构渲染下拉框
    @RequestMapping(value="selectBranchList")
    @ResponseBody
    public ServerResponse selectBranchList(CommonVo commonVo){
        return iBranchService.selectBranchList(commonVo);
    }




    //上传视频和图片---通用接口
    @RequestMapping("uploadImg")
    @ResponseBody
    public ServerResponse uploadImg(HttpServletRequest request,
                                    HttpSession session) throws IOException {
        // 转型为MultipartHttpServletRequest
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获取文件到map容器中
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        StringBuffer sb = new StringBuffer();
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
                            pictureSaveFilePath  + "/" ,
                            tpid + extName).replaceAll("-", "");

                    sb.append( tpid
                            + extName);
                } else {
                    sb.append("");
                }
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uri", sb.toString());
        System.out.println("map:"+map);
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
