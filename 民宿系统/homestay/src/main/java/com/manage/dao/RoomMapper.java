package com.manage.dao;

import com.manage.pojo.Room;
import com.manage.vo.RoomQueryVo;

import java.util.List;

public interface RoomMapper {
    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomId);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    List<Room> getRoomList(RoomQueryVo roomQueryVo);
}