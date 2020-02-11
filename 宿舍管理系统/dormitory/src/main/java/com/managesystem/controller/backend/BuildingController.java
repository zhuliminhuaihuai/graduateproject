package com.managesystem.controller.backend;

import com.managesystem.common.Const;
import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.BedRoom;
import com.managesystem.pojo.Building;
import com.managesystem.pojo.User;
import com.managesystem.service.IBuildingService;
import com.managesystem.util.DateUtil;
import com.managesystem.util.ImageCompression;
import com.managesystem.util.UuidUtil;
import com.managesystem.vo.BuildingVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

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
@RequestMapping("/manage/building")
public class BuildingController {

    @Autowired
    private IBuildingService iBuildingService;

    //根据条件获取所有的宿舍楼
    @RequestMapping("getBuildingList")
    @ResponseBody
    public LayUiPageResponse getBuildingList(BuildingVo buildingVo, Integer page, Integer limit) {
        return iBuildingService.getBuildingList(buildingVo, page, limit);
    }
    //上传宿舍楼封面
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

    //创建新宿舍楼
    @RequestMapping("addBuilding")
    @ResponseBody
    public ServerResponse addBuilding(Building building) {
        return iBuildingService.addBuilding(building);
    }

    //宿舍楼详情
    @RequestMapping("detailBuilding")
    @ResponseBody
    public ServerResponse detailBuilding(Integer buildingId) {
        return iBuildingService.detailBuilding(buildingId);
    }

    //修改宿舍楼
    @RequestMapping("modifyBuilding")
    @ResponseBody
    public ServerResponse modifyBuilding(Building building) {
        return iBuildingService.modifyBuilding(building);
    }

    //获取所有宿舍楼
    @RequestMapping("getAllBuilding")
    @ResponseBody
    public ServerResponse getAllBuilding() {
        return iBuildingService.getAllBuilding();
    }

    //验证宿舍大楼名字是否存在
    @RequestMapping("checkBuildingName")
    @ResponseBody
    public ServerResponse checkBuildingName(String buildingName) {
        return iBuildingService.checkBuildingName(buildingName);
    }

    //删除宿舍楼
    @RequestMapping("deleteBuilding")
    @ResponseBody
    public ServerResponse deleteBuilding(Integer buildingId) {
        return iBuildingService.deleteBuilding(buildingId);
    }

    //宿舍楼房间信息详情
    @RequestMapping("buildingBedRoomDetail")
    @ResponseBody
    public LayUiPageResponse buildingBedRoomDetail(HttpServletRequest request, BedRoom bedRoom, Integer page, Integer limit) {
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        bedRoom.setBedroomFaculty(user.getUserFaculty());
        return iBuildingService.buildingBedRoomDetail(bedRoom, page, limit);
    }
    /**************************************************/
    //跳转宿舍楼列表界面
    @RequestMapping("jumpBuildingList.html")
    public String jumpBuildingListHtml() {
        return "building/building_list";
    }

    //跳转创建宿舍楼界面
    @RequestMapping("jumpBuildingAdd.html")
    public String jumpBuildingAddHtml() {
        return "building/building_add";
    }
    //跳转修改宿舍楼界面
    @RequestMapping("jumpBuildingModify.html")
    public String jumpBuildingModifyHtml() {
        return "building/building_modify";
    }

    //跳转宿舍楼详情页面
    @RequestMapping("jumpBuildingDetail.html")
    public String jumpBuildingDetailHtml() {
        return "building/building_detail";
    }
}
