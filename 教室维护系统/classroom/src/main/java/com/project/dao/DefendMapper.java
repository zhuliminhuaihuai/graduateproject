package com.project.dao;

import com.project.pojo.Defend;
import com.project.vo.DefendQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DefendMapper {
    int deleteByPrimaryKey(Integer defendId);

    int insert(Defend record);

    int insertSelective(Defend record);

    Defend selectByPrimaryKey(Integer defendId);

    int updateByPrimaryKeySelective(Defend record);

    int updateByPrimaryKey(Defend record);

    List<Defend> getDefendList(DefendQueryVo defendQueryVo);

    List<Defend> findDefendByRoomCodeAndDefendState(@Param("roomCode") String roomCode, @Param("defendState") Integer defendState);

    int deleteByRoomId(Integer roomId);

}