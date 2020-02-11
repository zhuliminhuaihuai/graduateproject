package com.managesystem.controller.backend;


import com.managesystem.common.Const;
import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.User;
import com.managesystem.pojo.WedPhoto;
import com.managesystem.service.IPhotoService;
import com.managesystem.util.DateUtil;
import com.managesystem.util.ImageCompression;
import com.managesystem.util.UuidUtil;
import com.managesystem.vo.AddPhotoVo;
import com.managesystem.vo.PhotoVo;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/manage/photo/")
public class PhotoController {

    @Autowired
    private IPhotoService iPhotoService;


    //获取所有封面照片（封装的vo类）
    @RequestMapping("getMontherPhotoList")
    @ResponseBody
    public LayUiPageResponse getMontherPhotoList(PhotoVo photoVo, Integer page, Integer limit) {
        return iPhotoService.getMontherPhotoList(photoVo, page, limit);
    }

    //获取所有封面照片（客户）
    @RequestMapping("getMontherPhotoListAsCustonmer")
    @ResponseBody
    public LayUiPageResponse getMontherPhotoListAsCustonmer(String photoCode, String photoTitle, Integer page, Integer limit) {
        return iPhotoService.getMontherPhotoListAsCustonmer(photoCode, photoTitle, page, limit);
    }

    //修改相册是否启用状态
    @RequestMapping("modifyPhotoState")
    @ResponseBody
    public ServerResponse modifyPhotoState(WedPhoto wedPhoto) {
        return iPhotoService.modifyPhotoState(wedPhoto);
    }

    //摄影师成果图
    @RequestMapping("getphotographerphoto")
    @ResponseBody
    public ServerResponse getphotographerphoto(String userCode) {
        return iPhotoService.getphotographerphoto(userCode);
    }
    //上传婚纱套餐
    @RequestMapping("addPhoto")
    @ResponseBody
    public ServerResponse addPhoto(AddPhotoVo addPhotoVo) {
        return iPhotoService.addPhoto(addPhotoVo);
    }

    //删除相册包括相册内容
    @RequestMapping("deletePhoto")
    @ResponseBody
    public ServerResponse deletePhoto(String photoCode) {
        return iPhotoService.deletePhoto(photoCode);
    }

    //相册详情
    @RequestMapping("detailPhoto")
    @ResponseBody
    public ServerResponse detailPhoto(Integer photoId) {
        return iPhotoService.detailPhoto(photoId);
    }

    //上传相册套餐内容（子照片）
    @RequestMapping("addPhotoChildren")
    @ResponseBody
    public ServerResponse addPhotoChildren(String photoImg, String photoParentCode) {
        return iPhotoService.addPhotoChildren(photoImg, photoParentCode);
    }

    //删除相册套餐内容（子照片 单张）
    @RequestMapping("deletePhotoChildren")
    @ResponseBody
    public ServerResponse deletePhotoChildren(Integer photoId) {
        return iPhotoService.deletePhotoChildren(photoId);
    }

    //删除相册套餐内容（多张）
    @RequestMapping("deleteManyPhotoChildren")
    @ResponseBody
    public ServerResponse deleteManyPhotoChildren(@Param("photoIds") String photoIds) {
        return iPhotoService.deleteManyPhotoChildren(photoIds);
    }

    //相册基本信息详情
    @RequestMapping("detailPhotoMessage")
    @ResponseBody
    public ServerResponse detailPhotoMessage(Integer photoId) {
        return iPhotoService.detailPhotoMessage(photoId);
    }

    //修改相册套餐的基本信息
    @RequestMapping("modifyPhotoMessage")
    @ResponseBody
    public ServerResponse modifyPhotoMessage(WedPhoto wedPhoto) {
        return iPhotoService.modifyPhotoMessage(wedPhoto);
    }

    //上传相册封面
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
                            pictureSaveFilePath + photo + days,
                            tpid + extName).replaceAll("-", "");

                    sb.append(photo + days + "/" + tpid
                            + extName);

                    // ----图片压缩 s-m-l 型
                    String imgSrc = pictureSaveFilePath + photo + days + "/"
                            + tpid + extName;
                    String imgS = photo + days + "/" + tpid + "_s"
                            + extName;
                    String imgM = photo + days + "/" + tpid + "_m"
                            + extName;
                    String imgL = photo + days + "/" + tpid + "_l"
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

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setMaxInMemorySize(40960);
        resolver.setMaxUploadSize(50 * 1024 * 1024);//上传文件大小 50M 50*1024*1024
        return resolver;
    }

    //上传图片
    @RequestMapping(value = "uploadFile1.do")
    @ResponseBody
    public Object uploadFile(HttpServletRequest request, HttpSession session,
                             HttpServletResponse response) throws Exception {
        // 转型为MultipartHttpServletRequest
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获取文件到map容器中
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();

        // shiro管理的session
        User user = (User) session.getAttribute(Const.ManagerToken.SESSION);

        Integer uid = user.getUserId();
        StringBuffer sb = new StringBuffer();
        StringBuffer sbL = new StringBuffer();
        StringBuffer sbM = new StringBuffer();
        StringBuffer sbS = new StringBuffer();
        String photo = "/AllImg/BranchImg/";
        // 图片上传
        /*String pictureSaveFilePath = String.valueOf(Thread.currentThread()
                .getContextClassLoader().getResource(""))
                + "../../";
        pictureSaveFilePath = pictureSaveFilePath.substring(6);*/ // 去掉 'file:/'
        /*String servletPath = request.getServletPath();
        String pictureSaveFilePath = request.getSession().getServletContext()
                .getRealPath(servletPath);*/
        String pictureSaveFilePath = request.getSession().getServletContext().getRealPath("upload");
        System.out.println("路径是啥：" + pictureSaveFilePath);
        System.out.println(pictureSaveFilePath + photo);
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
                            pictureSaveFilePath + photo + days,
                            tpid + extName).replaceAll("-", "");

                    sb.append("#" + photo + days + "/" + tpid
                            + extName);

                    // ----图片压缩 s-m-l 型
                    String imgSrc = pictureSaveFilePath + photo + days + "/" + tpid + extName;
                    String imgS = photo + days + "/" + tpid + "_s" + extName;
                    String imgM = photo + days + "/" + tpid + "_m" + extName;
                    String imgL = photo + days + "/" + tpid + "_l" + extName;

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

                    sbL.append("#" + imgL);
                    sbM.append("#" + imgM);
                    sbS.append("#" + imgS);
                } else {
                    sb.append("");
                    sbL.append("");
                    sbM.append("");
                    sbS.append("");
                }
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("img", sb.toString());
        map.put("imgL", sbL.toString());
        map.put("imgM", sbM.toString());
        map.put("imgS", sbS.toString());
        return map;
    }

    /**
     * 删除图片
     */
    @RequestMapping(value = "/delimg", method = RequestMethod.POST)
    @ResponseBody
    public Object delimg(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", "success");
        return map;
    }

    /***************************************************/

    //跳转套餐列表
    @RequestMapping("jumpPhotoList.html")
    public String jumpPhotoListHtml() {
        return "photo/photo_list";
    }

    //跳转婚纱套餐上传
    @RequestMapping("jumpPhotoAdd.html")
    public String jumpPhotoAddHtml() {
        return "photo/photo_add";
    }

    //跳转婚纱套餐详情页面
    @RequestMapping("jumpPhotoDetail.html")
    public String jumpPhotoDetailHtml() {
        return "photo/photo_detail";
    }

    //打开修改婚纱套餐基本信息
    @RequestMapping("openPhotoModify.html")
    public String openPhotoModifyHtml() {
        return "photo/photo_modify";
    }

    //跳转婚纱照列表页面
    @RequestMapping("jumpPhotoListCustomer.html")
    public String jumpPhotoListCustomerHtml() {
        return "photo/photo_list_customer";
    }

    //跳转婚纱照套餐详情页面
    @RequestMapping("jumpPhotoDetailCustomer.html")
    public String jumpPhotoDetailCustomerHtml() {
        return "photo/photo_detail_customer";
    }

    //打开预约婚纱页面
    @RequestMapping("openPhotoAppointment.html")
    public String openPhotoAppointmentHtml() {
        return "photo/photo_appointment";
    }


}
