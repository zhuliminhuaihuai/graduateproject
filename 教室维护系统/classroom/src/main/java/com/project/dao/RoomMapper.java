package com.project.dao;

import com.project.pojo.Room;
import com.project.vo.ClassRoomQueryVo;

import java.util.List;

public interface RoomMapper {
    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomId);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    List<Room> getRoomList(ClassRoomQueryVo classRoomQueryVo);
}