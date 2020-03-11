package com.manage.controller.backend;

import com.manage.common.Const;
import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.pojo.Room;
import com.manage.pojo.User;
import com.manage.service.IRoomService;
import com.manage.util.DateUtil;
import com.manage.util.ImageCompression;
import com.manage.util.UuidUtil;
import com.manage.vo.RoomQueryVo;
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
import java.util.HashMap;
import java.util.Map;

/**
 * RoomController
 *
 * @author {zhulimin}
 * @date 2020/2/26 0026 下午 17:41
 */
@Controller
@RequestMapping("/manage/room/")
public class RoomController {


    @Autowired
    private IRoomService iRoomService;


    //房源添加
    @RequestMapping("add")
    @ResponseBody
    public ServerResponse addRoom(HttpServletRequest request, Room room) {

        return iRoomService.addRoom(request, room);
    }

    //修改房源状态
    @RequestMapping("updateRoomState")
    @ResponseBody
    public ServerResponse updateRoomState(Integer roomId, Integer roomState) {
        return iRoomService.updateRoomState(roomId, roomState);
    }
    //房源列表
    @RequestMapping("roomList")
    @ResponseBody
    public LayUiPageResponse roomList(HttpServletRequest request,RoomQueryVo roomQueryVo, Integer page, Integer limit) {
        return iRoomService.roomList(request,roomQueryVo, page, limit);
    }

    //获取房源
    @RequestMapping("getRoom")
    @ResponseBody
    public ServerResponse getRoom(Integer roomId) {
        return iRoomService.getRoom(roomId);
    }

    //保存
    @RequestMapping("save")
    @ResponseBody
    public ServerResponse roomSave(Room room) {
        return iRoomService.roomSave(room);
    }

    //删除
    @RequestMapping("deleteRoom")
    @ResponseBody
    public ServerResponse deleteRoom(Integer roomId) {
        return iRoomService.deleteRoom(roomId);
    }

    //前端房源展示
    @RequestMapping("portalRoomList")
    @ResponseBody
    public ServerResponse portalRoomList(String roomSimpleRemark) {
        return iRoomService.portalRoomList(roomSimpleRemark);
    }
    /**************/
    //跳转添加房源界面
    @RequestMapping("jumpAddRoom.html")
    public String jumpAddRoomHtml() {
        return "room/room_add";
    }

    //打开房源列表
    @RequestMapping("jumpRoomList.html")
    public String jumpRoomListHtml() {
        return "room/room_list";
    }

    //打开房源详情
    @RequestMapping("openRoomDetail.html")
    public String openRoomDetailHtml() {
        return "room/room_detail";
    }

    //跳转网站房源详情页面
    @RequestMapping("jumpRoomDetail.html")
    public String jumpGoodsDetailHtml(@Param("roomId") Integer roomId, HttpServletRequest request) {
        System.out.println("id:" + roomId);
        request.setAttribute("roomId", roomId);
        return "room/portal_room_detail";
    }

    //跳转网站房源详情页面未登录
    @RequestMapping("jumpRoomDetailNoLogin.html")
    public String jumpGoodsDetailNoLoginHtml(@Param("roomId") Integer roomId, HttpServletRequest request) {
        System.out.println("id:" + roomId);
        request.setAttribute("roomId", roomId);
        return "room/portal_room_detail_nologin";
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
}
