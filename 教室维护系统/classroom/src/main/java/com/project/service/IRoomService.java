package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Room;
import com.project.vo.ClassRoomQueryVo;

public interface IRoomService {


    /**
     * 添加教室
     * @param room
     * @return
     */
    ServerResponse addRoom(Room room);


    /**
     * 教室列表带查询条件
     * @param page
     * @param limit
     * @param classRoomQueryVo
     * @return
     */
    LayUiPageResponse getRoomListByCondition(Integer page, Integer limit, ClassRoomQueryVo classRoomQueryVo);
//
//    //修改1-2节课的状态
//    ServerResponse  updateRoomSelection1State(Room room);
//
//    //修改3-4节课的状态
//    ServerResponse  updateRoomSelection2State(Room room);
//
//    //修改5-6节课的状态
//    ServerResponse  updateRoomSelection3State(Room room);
//
//    //修改7-8节课的状态
//    ServerResponse  updateRoomSelection4State(Room room);
//
    /**
     * @param room room信息
     * @return
     */
    ServerResponse updateRoomState(Room room);


    /**
     * 教室详情
     * @param roomId 教室主键
     * @return
     */
    ServerResponse detailRoom(Integer roomId);


    /**
     * 教室保存
     * @param room 教室信息
     * @return
     */
    ServerResponse saveRoom(Room room);

    /**
     * @param roomId 教室主键
     * @return
     */
    ServerResponse deleteRoom(Integer roomId);
}
