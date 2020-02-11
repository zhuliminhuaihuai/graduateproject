package com.manage.controller.backend;

import com.manage.common.Const;
import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.dao.RoomImgMapper;
import com.manage.dao.RoomMapper;
import com.manage.pojo.Room;
import com.manage.pojo.RoomImg;
import com.manage.pojo.User;
import com.manage.service.IRoomService;
import com.manage.util.DateUtil;
import com.manage.util.ImageCompression;
import com.manage.util.PublicUtil;
import com.manage.util.UuidUtil;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
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
import java.util.*;

@Controller
@RequestMapping("/manage/room/")
public class RoomController {

    @Autowired
    private IRoomService iRoomService;

    //添加房源
    @RequestMapping("addRoom")
    @ResponseBody
    public ServerResponse addRoom(Room room, String imgMany) {
        return iRoomService.addRoom(room, imgMany);
    }

    //找到房源列表
    @RequestMapping("roomList")
    @ResponseBody
    public LayUiPageResponse roomList(Room room, Integer page, Integer limit) {
        return iRoomService.roomList(room, page, limit);
    }

    //根据id查询房源的详情照片
    @RequestMapping("roomPhotoDetail")
    @ResponseBody
    public ServerResponse roomPhotoDetail(Integer roomId) {
        return iRoomService.roomPhotoDetail(roomId);
    }

    //根据id查询房源的详情照片 返回特定json
    @RequestMapping("roomPhotoCallBackData")
    @ResponseBody
    public ServerResponse roomPhotoCallBackData(Integer roomId) {
        return iRoomService.roomPhotoCallBackData(roomId);
    }

    //添加房内照片
    @RequestMapping("addRoomImg")
    @ResponseBody
    public ServerResponse addRoomImg(Integer roomId, String photoImg) {
        return iRoomService.addRoomImg(roomId, photoImg);
    }

    //删除单张照片
    @RequestMapping("deleteRoomImg")
    @ResponseBody
    public ServerResponse deleteRoomImg(Integer imgId) {
        return iRoomService.deleteRoomImg(imgId);
    }

    //删除多张照片
    @RequestMapping("deleteManyRoomImg")
    @ResponseBody
    public ServerResponse deleteManyRoomImg(@Param("photoIds") String photoIds) {
        return iRoomService.deleteManyRoomImg(photoIds);
    }

    //修改房源启用状态
    @RequestMapping("modifyRoomIsUseState")
    @ResponseBody
    public ServerResponse modifyRoomIsUseState(Integer roomId, Integer roomIsUse) {
        return iRoomService.modifyRoomIsUseState(roomId, roomIsUse);
    }

    //删除房源
    @RequestMapping("deleteRoom")
    @ResponseBody
    public ServerResponse deleteRoom(Integer roomId) {
        return iRoomService.deleteRoom(roomId);
    }

    //批量删除房源
    @RequestMapping("deleteSomeRoom")
    @ResponseBody
    public ServerResponse deleteSomeRoom(String ids) {
        return iRoomService.deleteSomeRoom(ids);
    }
    //房内基本设施详情
    @RequestMapping("roomMessageDetail")
    @ResponseBody
    public ServerResponse roomMessageDetail(Integer roomId) {
        return iRoomService.roomMessageDetail(roomId);
    }

    //保存修改房内基本设施
    @RequestMapping("saveModifyRoomMessage")
    @ResponseBody
    public ServerResponse saveModifyRoomMessage(Room room) {
        return iRoomService.saveModifyRoomMessage(room);
    }

    //查看预约或入住该房源的客户基本信息
    @RequestMapping("seeUser")
    @ResponseBody
    public ServerResponse seeUser(Integer roomId) {
        return iRoomService.seeUser(roomId);
    }
    //上传商品照片
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
    /****************************************************/
    //跳转添加房源
    @RequestMapping("jumpRoomAdd.html")
    public String jumpRoomAddHtml() {
        return "room/room_add";
    }

    //跳转房源列表
    @RequestMapping("jumpRoomList.html")
    public String jumpRoomListHtml() {
        return "room/room_list";
    }

    //跳转房内照片详情
    @RequestMapping("jumpRoomPhotoDetail.html")
    public String jumpRoomPhotoDetailHtml() {
        return "room/room_photo_detail";
    }

    //跳转房内基本设施详情
    @RequestMapping("jumpRoomMessageDetail.html")
    public String jumpRoomMessageDetailHtml() {
        return "room/room_message_detail";
    }

    //跳转查看客户信息的界面
    @RequestMapping("jumpRoomSeeUser.html")
    public String jumpRoomSeeUserHtml() {
        return "room/room_see_user";
    }
}
