package com.managesystem.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.dao.BedRoomMapper;
import com.managesystem.dao.BuildingMapper;
import com.managesystem.pojo.BedRoom;
import com.managesystem.pojo.Building;
import com.managesystem.service.IBuildingService;
import com.managesystem.util.PublicUtil;
import com.managesystem.vo.BuildingVo;
import net.sf.jsqlparser.schema.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;

@Service
public class BuildingServiceImpl implements IBuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Autowired
    private BedRoomMapper bedRoomMapper;

    //根据条件获取所有的宿舍楼
    public LayUiPageResponse getBuildingList(BuildingVo buildingVo, Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<Building> buildingList = buildingMapper.getBuildingList(buildingVo);
        String photoPath = "http://127.0.0.1:8080/upload/";
        if (buildingList.size() > 0) {
            for (int i = 0; i < buildingList.size(); i++) {
                buildingList.get(i).setBuildingImg(photoPath + buildingList.get(i).getBuildingImg());
            }
            PageInfo pageInfo = new PageInfo(buildingList);
            return LayUiPageResponse.createBySuccess(buildingList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }
    }
    //创建新宿舍楼
    public ServerResponse addBuilding(Building building) {
        building.setBuildingCode(PublicUtil.setCode("D"));
        building.setBuildingCreateTime(new Date());
        int count = buildingMapper.insertSelective(building);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("添加失败");
        } else {
            return ServerResponse.createByErrorMessage("添加失败");
        }
    }
    //宿舍楼详情
    public ServerResponse detailBuilding(Integer buildingId) {

        Building building = buildingMapper.selectByPrimaryKey(buildingId);
        if (building != null) {
            return ServerResponse.createBySuccess("找到宿舍楼", building);
        } else {
            return ServerResponse.createByErrorMessage("未找到该宿舍楼");
        }
    }
    //修改宿舍楼
    public ServerResponse modifyBuilding(Building building) {

        building.setBuildingUpdateTime(new Date());
        int count = buildingMapper.updateByPrimaryKeySelective(building);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        } else {
            return ServerResponse.createByErrorMessage("修改失败");
        }
    }
    //获取所有宿舍楼
    public ServerResponse getAllBuilding() {

        List<Building> buildingList = buildingMapper.getAllBuilding();
        if (buildingList.size() > 0) {
            return ServerResponse.createBySuccess("找到宿舍大楼", buildingList);
        } else {
            return ServerResponse.createByErrorMessage("暂无宿舍大楼");
        }
    }
    //验证宿舍大楼名字是否存在
    public ServerResponse checkBuildingName(String buildingName) {

        Building building = buildingMapper.checkBuildingName(buildingName);
        if (building == null) {
            return ServerResponse.createByErrorMessage("该宿舍楼不存在");
        } else {
            return ServerResponse.createBySuccessMessage("找到宿舍楼");
        }
    }

    //删除宿舍楼
    public ServerResponse deleteBuilding(Integer buildingId) {

        Building building = buildingMapper.selectByPrimaryKey(buildingId);
        if (building != null) {
            String buildingCode = building.getBuildingCode();
            //先删除宿舍楼底下的房间
            bedRoomMapper.deleteBuildingUnderBedRoom(buildingCode);
            int count = buildingMapper.deleteByPrimaryKey(buildingId);
            if (count > 0) {
                return ServerResponse.createBySuccessMessage("删除成功");
            } else {
                return ServerResponse.createByErrorMessage("删除失败");
            }
        } else {
            return ServerResponse.createByErrorMessage("未找到该宿舍楼");
        }
    }
    //宿舍楼房间信息详情
    public LayUiPageResponse buildingBedRoomDetail(BedRoom bedRoom, Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<BedRoom> bedRoomList = bedRoomMapper.getBedRoomListUnderBuilding(bedRoom);
        if (bedRoomList.size() > 0) {
            PageInfo pageInfo = new PageInfo(bedRoomList);
            return LayUiPageResponse.createBySuccess(bedRoomList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据");
        }


    }

}
