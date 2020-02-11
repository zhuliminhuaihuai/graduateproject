package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Room;
import com.project.vo.ClassRoomQueryVo;

public interface IRoomService {


    //添加教室
    ServerResponse addRoom(Room room);

    //教室列表带查询条件
    LayUiPageResponse getRoomListByCondition(Integer page, Integer limit, ClassRoomQueryVo classRoomQueryVo);

    //修改1-2节课的状态
    ServerResponse  updateRoomSelection1State(Room room);

    //修改3-4节课的状态
    ServerResponse  updateRoomSelection2State(Room room);

    //修改5-6节课的状态
    ServerResponse  updateRoomSelection3State(Room room);

    //修改7-8节课的状态
    ServerResponse  updateRoomSelection4State(Room room);

    //修改教室的状态
    ServerResponse updateRoomState(Room room);

    //教师详情
    ServerResponse detailRoom(Integer roomId);

    //教师保存
    ServerResponse saveRoom(Room room);

    //教室删除
    ServerResponse deleteRoom(Integer roomId);
}
