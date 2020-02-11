package com.managesystem.service;

import com.managesystem.common.ServerResponse;
import com.managesystem.vo.BedRoomVo;

public interface IBedRoomService {


    //一键生成房间
    ServerResponse addManyBedRoom(BedRoomVo bedRoomVo);

    //安排学生入住
    ServerResponse checkInBedRoom(String ids, Integer bedroomId);

}
