package com.project.controller.backend;

import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.*;
import com.project.service.IResumeService;
import com.project.util.DateUtil;
import com.project.util.UuidUtil;
import com.project.vo.CommonVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manage/resume/")
public class ResumeController {

    @Autowired
    private IResumeService iResumeService;

    //进入简历页面
    @RequestMapping("resume_list")
    public String resume_list() {
        return "/employ/resume_list";
    }

    //根据角色请求简历表
    @RequestMapping(value = "resumeList")
    @ResponseBody
    public LayUiPageResponse<List<Resume>> resumeList(CommonVo commonVo, int page, int limit, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        commonVo.setUserCode(user.getUserCode());
        commonVo.setRole(user.getRole().toString());//传角色role到mapper层 判断不同角色显示对应的数据
        return iResumeService.resumeList(commonVo, page, limit);
    }

    //进入简历设置
    @RequestMapping("resume_set")
    public String resume_set() {
        return "/employ/resume_set";
    }

    //简历添加
    @RequestMapping(value = "addResume")
    @ResponseBody
    public ServerResponse addResume(Resume resume, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        resume.setUserCode(user.getUserCode());
        resume.setUserName(user.getUserName());
        resume.setUserId(user.getUserId());
        return iResumeService.insert(resume);
    }

    //简历保存
    @RequestMapping(value = "saveResume")
    @ResponseBody
    public ServerResponse saveResume(Resume resume, HttpServletRequest request) {
        return iResumeService.saveResume(resume);
    }
    //简历删除文档
    @RequestMapping(value = "deleteResumeWord")
    @ResponseBody
    public ServerResponse deleteResumeWord(Resume resume) {
        return iResumeService.deleteResumeWord(resume);
    }

    //进入简历设置 添加项目
    @RequestMapping("resume_project_add")
    public String resume_project_add() {
        return "/employ/resume_project_add";
    }

    //请求我的简历项目经历
    @RequestMapping(value = "getResumeProject")
    @ResponseBody
    public ServerResponse getResumeProject(String resumeCode) {
        return iResumeService.getResumeProject(resumeCode);
    }

    //请求我的简历获奖经历
    @RequestMapping(value = "getResumeWin")
    @ResponseBody
    public ServerResponse getResumeWin(String resumeCode) {
        return iResumeService.getResumeWin(resumeCode);
    }

    //简历添加项目经历
    @RequestMapping(value = "addResumeProject")
    @ResponseBody
    public ServerResponse addResumeProject(Project project) {
        return iResumeService.insertProject(project);
    }

    //进入简历设置 添加获奖
    @RequestMapping("resume_win_add")
    public String resume_win_add() {
        return "/employ/resume_win_add";
    }

    //简历添加获奖经历
    @RequestMapping(value = "addResumeWin")
    @ResponseBody
    public ServerResponse addResumeWin(WinExperience winExperience) {
        return iResumeService.insertWin(winExperience);
    }

    //简历删除
    @RequestMapping(value = "deleteResume")
    @ResponseBody
    public ServerResponse deleteResume(Integer id) {
        return iResumeService.delete(id);
    }

    //简历设置默认 其他不默认
    @RequestMapping(value = "setResumeDefault")
    @ResponseBody
    public ServerResponse setResumeDefault(Integer id,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        return iResumeService.setResumeDefault(id,user.getUserCode());
    }

    //学生进入简历详情页面啊
    @RequestMapping("resume_detail")
    public String resume_detail() {
        return "/employ/resume_detail";
    }
    //企业进入简历详情页面啊
    @RequestMapping("resume_enter_detail")
    public String resume__enter_detail() {
        return "/employ/resume_enter_detail";
    }

    //获取个人简历
    @RequestMapping(value = "getResume")
    @ResponseBody
    public ServerResponse getResume(Integer id) {
        return iResumeService.get(id);
    }

    //简历修改
    @RequestMapping(value = "editResume")
    @ResponseBody
    public ServerResponse editResume(Resume resume) {
        return iResumeService.edit(resume);
    }

    //学生进入简历投递信息列表
    @RequestMapping("resume_record_list")
    public String resume_record_list() {
        return "/employ/resume_record_list";
    }

    //企业进入简历投递信息列表
    @RequestMapping("resume_record_enter_list")
    public String resume_record_enter_list() {
        return "/employ/resume_record_enter_list";
    }

    //简历投递列表
    @RequestMapping(value = "resumeRecordList")
    @ResponseBody
    public LayUiPageResponse<List<ResumeRecord>> resumeRecordList(CommonVo commonVo, int page, int limit, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        commonVo.setUserCode(user.getUserCode());
        commonVo.setRole(user.getRole().toString());//传角色role到mapper层 判断不同角色显示对应的数据
        return iResumeService.resumeRecordList(commonVo, page, limit);
    }
    //投递简历
    @RequestMapping(value = "insertResumeRecord")
    @ResponseBody
    public ServerResponse insertResumeRecord(ResumeRecord resumeRecord,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        resumeRecord.setUserCode(user.getUserCode());
        resumeRecord.setUserId(user.getUserId());
        if(!user.getRealName().equals("")){
            resumeRecord.setUserName(user.getRealName());
        }else {
            resumeRecord.setUserName(user.getUserName());
        }
        return iResumeService.insertResumeRecord(resumeRecord);
    }

    //进入就业信息列表
    @RequestMapping("employ_list")
    public String employ_list() {
        return "/employ/employ_list";
    }

    //学生就业情况列表
    @RequestMapping(value = "employInfoList")
    @ResponseBody
    public LayUiPageResponse<List<EmployInfo>> employInfoList(CommonVo commonVo, int page, int limit, HttpServletRequest request) {
        return iResumeService.employInfoList(commonVo, page, limit);
    }
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

        //下载文件
        @RequestMapping(value="download",method=RequestMethod.GET)
        public void download(@RequestParam(value="fileName")String fileName,
                             HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
            //模拟文件，myfile.txt为需要下载的文件
            String path = request.getSession().getServletContext().getRealPath("upload/"+fileName);
            //获取输入流
            InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
            //转码，免得文件名中文乱码
            fileName = URLEncoder.encode(fileName,"UTF-8");
            //设置文件下载头
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            while((len = bis.read()) != -1){
                out.write(len);
                out.flush();
            }
            out.close();
        }

        //修改简历状态
        @RequestMapping(value = "editStatus")
        @ResponseBody
        public ServerResponse editStatus(ResumeRecord resumeRecord) {
            return iResumeService.editStatus(resumeRecord);
        }


        //进入简历意见界面
        @RequestMapping("resume_return_result")
        public String resume_return_result() {
            return "/employ/resume_return_result";
        }
}
