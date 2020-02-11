package com.managesystem.controller.backend;

import com.managesystem.common.ServerResponse;
import com.managesystem.service.IBedRoomService;
import com.managesystem.vo.BedRoomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manage/bedroom/")
public class BedRoomController {


    @Autowired
    private IBedRoomService iBedRoomService;

    //一键生成房间
    @RequestMapping("addManyBedRoom")
    @ResponseBody
    public ServerResponse addManyBedRoom(BedRoomVo bedRoomVo) {
        return iBedRoomService.addManyBedRoom(bedRoomVo);
    }

    //安排学生入住
    @RequestMapping("checkInBedRoom")
    @ResponseBody
    public ServerResponse checkInBedRoom(String ids, Integer bedroomId) {
        return iBedRoomService.checkInBedRoom(ids, bedroomId);
    }
    /**************************************************/

    //跳转生成房间界面
    @RequestMapping("jumpBedRoomAddMany.html")
    public String jumpBedRoomAddManyHtml() {
        return "bedroom/bedroom_add_many";
    }

    //跳转选择学生入住
    @RequestMapping("jumpCheckInUserList.html")
    public String jumpCheckInUserListHtml() {
        return "bedroom/checkIn_user_list";
    }

    //跳转房间详情界面
    @RequestMapping("jumpBedRoomDetailStudent.html")
    public String jumpBedRoomDetailStudentHtml() {
        return "bedroom/bedroom_detai_student";
    }
}
