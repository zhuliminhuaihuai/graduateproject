package com.project.controller.backend;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Room;
import com.project.service.IRoomService;
import com.project.vo.ClassRoomQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manage/room/")
public class RoomController {


    @Autowired
    private IRoomService iRoomService;

    //添加教室
    @RequestMapping("addRoom")
    @ResponseBody
    public ServerResponse addRoom(Room room) {
        return iRoomService.addRoom(room);
    }

    //教室列表带查询条件
    @RequestMapping("getRoomListByCondition")
    @ResponseBody
    public LayUiPageResponse getRoomListByCondition(Integer page, Integer limit, ClassRoomQueryVo classRoomQueryVo) {
        return iRoomService.getRoomListByCondition(page, limit, classRoomQueryVo);
    }

    //修改1-2节课的状态
    @RequestMapping("updateRoomSelection1State")
    @ResponseBody
    public ServerResponse updateRoomSelection1State(Room room) {
        return iRoomService.updateRoomSelection1State(room);
    }
    //修改3-4节课的状态
    @RequestMapping("updateRoomSelection2State")
    @ResponseBody
    public ServerResponse updateRoomSelection2State(Room room) {
        return iRoomService.updateRoomSelection2State(room);
    }
    //修改5-6节课的状态
    @RequestMapping("updateRoomSelection3State")
    @ResponseBody
    public ServerResponse updateRoomSelection3State(Room room) {
        return iRoomService.updateRoomSelection3State(room);
    }
    //修改7-8节课的状态
    @RequestMapping("updateRoomSelection4State")
    @ResponseBody
    public ServerResponse updateRoomSelection4State(Room room) {
        return iRoomService.updateRoomSelection4State(room);
    }
    //修改教室的状态
    @RequestMapping("updateRoomState")
    @ResponseBody
    public ServerResponse updateRoomState(Room room) {
        return iRoomService.updateRoomState(room);
    }


    //教室详情
    @RequestMapping("detailRoom")
    @ResponseBody
    public ServerResponse detailRoom(Integer roomId) {
        return iRoomService.detailRoom(roomId);
    }

    //教室保存
    @RequestMapping("saveRoom")
    @ResponseBody
    public ServerResponse saveRoom(Room room) {
        return iRoomService.saveRoom(room);
    }

    //教室删除
    @RequestMapping("deleteRoom")
    @ResponseBody
    public ServerResponse deleteRoom(Integer roomId) {
        return iRoomService.deleteRoom(roomId);
    }
    /********************************************/
    //跳转添加教室界面
    @RequestMapping("jumpAddRoom.html")
    public String jumpAddRoomHtml() {
        return "room/add_room";
    }

    //跳转教室列表
    @RequestMapping("jumpRoomList.html")
    public String jumpRoomListHtml() {
        return "room/room_list";
    }

    //打开教室详情页面
    @RequestMapping("openRoomDetail.html")
    public String openRoomDetailHtml() {
        return "room/detail_room";
    }


}
