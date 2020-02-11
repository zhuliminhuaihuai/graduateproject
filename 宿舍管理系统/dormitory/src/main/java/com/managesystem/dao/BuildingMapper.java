package com.managesystem.dao;

import com.managesystem.pojo.Building;
import com.managesystem.vo.BuildingVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildingMapper {
    int deleteByPrimaryKey(Integer buildingId);

    int insert(Building record);

    int insertSelective(Building record);

    Building selectByPrimaryKey(Integer buildingId);

    int updateByPrimaryKeySelective(Building record);

    int updateByPrimaryKey(Building record);

    //根据条件获取所有的宿舍楼
    List<Building> getBuildingList(BuildingVo buildingVo);

    //获取所有宿舍楼
    List<Building> getAllBuilding();

    //验证宿舍大楼名字是否存在
    Building checkBuildingName(@Param("buildingName") String buildingName);

    //根据code查询大楼
    Building fingBuildingByCode(@Param("buildingCode") String buildingCode);


}