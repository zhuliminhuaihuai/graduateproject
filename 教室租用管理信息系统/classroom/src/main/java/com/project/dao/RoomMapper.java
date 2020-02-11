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

    //教室列表带查询条件
    List<Room> getRoomList(ClassRoomQueryVo classRoomQueryVo);

    //获取租借教室列表
    List<Room> getBorrowRoomList(ClassRoomQueryVo classRoomQueryVo);
}