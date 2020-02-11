package com.manage.dao;

import com.manage.pojo.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomMapper {
    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomId);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    //批量删除房源
    int deleteSomeRoom(@Param("idList") List<Integer> idList);

    //修改房源启用状态
    int updateRoomIsUseState(@Param("roomId") Integer roomId, @Param("roomIsUse") Integer roomIsUse);

    //找到所有房源并且根据条件查询
    List<Room> findAllRoomByCondition(Room room);

    //找到所有空闲房源的封面照
    List<Room> findAllFreedomRoom(@Param("roomTitle") String roomTitle);

    //根据code查出room
    Room findRoomByRoomCode(@Param("roomCode") String roomCode);

}