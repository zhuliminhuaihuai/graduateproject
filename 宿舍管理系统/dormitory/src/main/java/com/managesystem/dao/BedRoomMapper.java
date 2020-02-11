package com.managesystem.dao;

import com.managesystem.pojo.BedRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BedRoomMapper {
    int deleteByPrimaryKey(Integer bedroomId);

    int insert(BedRoom record);

    int insertSelective(BedRoom record);

    BedRoom selectByPrimaryKey(Integer bedroomId);

    int updateByPrimaryKeySelective(BedRoom record);

    int updateByPrimaryKey(BedRoom record);

    //删除宿舍楼底下的所有房间
    int deleteBuildingUnderBedRoom(@Param("buildingCode") String buildingCode);

    //宿舍楼详情所看到的房间列表 根据条件查询
    List<BedRoom> getBedRoomListUnderBuilding(BedRoom bedRoom);

    //根据bedRoomCode 找房间
    BedRoom findBedRoomByCode(@Param("bedRoomCode") String bedRoomCode);
}