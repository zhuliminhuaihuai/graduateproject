package com.managesystem.service;

import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.BedRoom;
import com.managesystem.pojo.Building;
import com.managesystem.vo.BuildingVo;

public interface IBuildingService {

    //根据条件获取所有的宿舍楼
    LayUiPageResponse getBuildingList(BuildingVo buildingVo, Integer page, Integer limit);

    //创建新宿舍楼
    ServerResponse addBuilding(Building building);

    //宿舍楼详情
    ServerResponse detailBuilding(Integer buildingId);

    //修改宿舍楼
    ServerResponse modifyBuilding(Building building);

    //获取所有宿舍楼
    ServerResponse getAllBuilding();

    //验证宿舍大楼名字是否存在
    ServerResponse checkBuildingName(String buildingName);

    //删除宿舍楼
    ServerResponse deleteBuilding(Integer buildingId);

    //宿舍楼房间信息详情
    LayUiPageResponse buildingBedRoomDetail(BedRoom bedRoom, Integer page, Integer limit);
}
