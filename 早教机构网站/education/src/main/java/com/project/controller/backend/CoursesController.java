package com.project.controller.backend;

import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.LayUiResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Courses;
import com.project.pojo.User;
import com.project.service.ICoursesService;
import com.project.util.DateUtil;
import com.project.util.ImageCompression;
import com.project.util.UuidUtil;
import com.project.vo.CoursesQueryVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
import java.util.Map;

@Controller
@RequestMapping("/manage/courses/")
public class CoursesController {

    @Autowired
    private ICoursesService iCoursesService;


    //添加新课程
    @RequestMapping("addCourses")
    @ResponseBody
    public ServerResponse addCourses(Courses courses) {
        return iCoursesService.addCourses(courses);
    }
    //所开设的所有课程学生看得见的
    @RequestMapping("getCoursesListAndSee")
    @ResponseBody
    public LayUiResponse getCoursesListAndSee(int pageSize, int currentPage) {
        return iCoursesService.getCoursesListAndSee(pageSize,currentPage);
    }

    //课程列表
    @RequestMapping("getCoursesList")
    @ResponseBody
    public LayUiPageResponse getCoursesList(Integer page, Integer limit, CoursesQueryVo coursesQueryVo) {
        return iCoursesService.getCoursesList(page, limit, coursesQueryVo);
    }

    //根据课程名查找现有的课程
    @RequestMapping("getCoursesListBycoursesTitle")
    @ResponseBody
    public ServerResponse getCoursesListBycoursesTitle(String coursesTitle) {
        return iCoursesService.getCoursesListBycoursesTitle(coursesTitle);
    }
    //修改课程状态
    @RequestMapping("updateCoursesState")
    @ResponseBody
    public ServerResponse updateCoursesState(Courses courses) {
        return iCoursesService.updateCoursesState(courses);
    }

    //课程详情
    @RequestMapping("detailCourses")
    @ResponseBody
    public ServerResponse detailCourses(Integer coursesId) {
        return iCoursesService.detailCourses(coursesId);
    }

    //保存课程
    @RequestMapping("saveCourses")
    @ResponseBody
    public ServerResponse saveCourses(Courses courses) {
        return iCoursesService.saveCourses(courses);
    }

    //删除课程
    @RequestMapping("deleteCourses")
    @ResponseBody
    public ServerResponse deleteCourses(Integer coursesId) {
        return iCoursesService.deleteCourses(coursesId);
    }
    //上传图片
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

    /***************************************/
    //跳转添加课程界面
    @RequestMapping("jumpAddCouses.html")
    public String jumpAddCousesHtml() {
        return "courses/courses_add";
    }

    //跳转课程列表
    @RequestMapping("jumpCoursesList.html")
    public String jumpCoursesListHtml() {
        return "courses/courses_list";
    }

    @RequestMapping("jumpCoursesDetail.html")
    public String jumpCoursesDetailHtml() {
        return "courses/courses_detail";
    }
}
