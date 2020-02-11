package com.manage.dao;

import com.manage.pojo.Room;
import com.manage.pojo.RoomImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomImgMapper {
    int deleteByPrimaryKey(Integer imgId);

    int insert(RoomImg record);

    int insertSelective(RoomImg record);

    RoomImg selectByPrimaryKey(Integer imgId);

    int updateByPrimaryKeySelective(RoomImg record);

    int updateByPrimaryKey(RoomImg record);



    //找到房源对应的房内照片
    List<RoomImg> findRoomImg(@Param("roomCode") String roomCode);

    //删除多张照片
    int deleteManyRoomImg(@Param("idList") List<Integer> idList);


}