package com.project.controller.backend;

import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.OfficeMessage;
import com.project.pojo.User;
import com.project.service.IOfficeMessageService;
import com.project.util.DateUtil;
import com.project.util.ImageCompression;
import com.project.util.UuidUtil;
import com.project.vo.OfficeMessageVo;
import org.apache.commons.io.FileUtils;
import org.redisson.api.annotation.REntity;
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
@RequestMapping("/manage/office/")
public class OfficeMessageController {

    @Autowired
    private IOfficeMessageService iOfficeMessageService;

    //机构基本信息获取
    @RequestMapping("getAllOfficeMessage")
    @ResponseBody
    public LayUiPageResponse getAllOfficeMessage(Integer page, Integer limit, OfficeMessageVo officeMessageVo) {
        return iOfficeMessageService.getAllOfficeMessage(page, limit, officeMessageVo);
    }

    //获取机构所有信息（已经启用）
    @RequestMapping("getOfficeMessage")
    @ResponseBody
    public ServerResponse getOfficeMessage() {
        return iOfficeMessageService.getOfficeMessage();
    }

    //获取机构视频宣传
    @RequestMapping("getOfficeVideo")
    @ResponseBody
    public ServerResponse getOfficeVideo() {
        return iOfficeMessageService.getOfficeVideo();
    }

    //修改机构启用状态
    @RequestMapping("updateOfficeMessageStage")
    @ResponseBody
    public ServerResponse updateOfficeMessageStage(OfficeMessage officeMessage) {
        return iOfficeMessageService.updateOfficeMessageStage(officeMessage);
    }

    //机构信息详情
    @RequestMapping("detailOfficeMessage")
    @ResponseBody
    public ServerResponse detailOfficeMessage(Integer messageId) {
        return iOfficeMessageService.detailOfficeMessage(messageId);
    }

    //机构信息保存
    @RequestMapping("saveOfficeMessage")
    @ResponseBody
    public ServerResponse saveOfficeMessage(OfficeMessage officeMessage) {
        return iOfficeMessageService.saveOfficeMessage(officeMessage);
    }

    //删除机构信息
    @RequestMapping("deleteOfficeMessage")
    @ResponseBody
    public ServerResponse deleteOfficeMessage(Integer messageId) {
        return iOfficeMessageService.deleteOfficeMessage(messageId);
    }

    //更换机构视频简介
    @RequestMapping("updateOfficeVideo")
    @ResponseBody
    public ServerResponse updateOfficeVideo(String officeVideo) {
        return iOfficeMessageService.updateOfficeVideo(officeVideo);
    }

    //添加机构基本信息
    @RequestMapping("addOfficeMessage")
    @ResponseBody
    public ServerResponse addOfficeMessage(OfficeMessage officeMessage) {
        return iOfficeMessageService.addOfficeMessage(officeMessage);
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
    //上传视频
    @RequestMapping("uploadVideo")
    @ResponseBody
    public ServerResponse uploadVideo(HttpServletRequest request,
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

    /*******************************/
    //跳转机构基本信息列表界面
    @RequestMapping("jumpOfficeMessageAll.html")
    public String jumpOfficeMessageAllHtml() {
        return "officemessage/officeMessage_list";
    }

    //跳转机构基本信息详情
    @RequestMapping("jumpOfficeMessageDetail.html")
    public String jumpOfficeMessageDetailHtml() {
        return "officemessage/officeMessgae_detail";
    }

    //跳转视频简介管理界面
    @RequestMapping("jumpOfficeMessageVideoChange.html")
    public String jumpOfficeMessageVideoChangeHtml() {
        return "officemessage/officeMessage_video_change";
    }

    //打开添加机构基本信息页面
    @RequestMapping("openOfficeMessageAdd.html")
    public String openOfficeMessageAddHtml() {
        return "officemessage/officeMessage_add";
    }
}
