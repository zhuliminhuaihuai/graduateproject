package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.RoomMapper;
import com.project.pojo.Room;
import com.project.service.IRoomService;
import com.project.util.PublicUtil;
import com.project.vo.ClassRoomQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private RoomMapper roomMapper;

    //添加教室
    public ServerResponse addRoom(Room room) {

        int x = room.getRoomPurpose().indexOf("[");
        int y = room.getRoomPurpose().indexOf("]");
        String roomPurposeString = room.getRoomPurpose().substring(x + 1, y);
        room.setRoomPurpose(roomPurposeString);
        room.setRoomCode(PublicUtil.setCode("R"));
        room.setRoomCreateTime(new Date());
        int count = roomMapper.insertSelective(room);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("添加成功!!!");
        } else {
            return ServerResponse.createByErrorMessage("添加失败!!!");
        }
    }
    //教室列表带查询条件
    public LayUiPageResponse getRoomListByCondition(Integer page, Integer limit, ClassRoomQueryVo classRoomQueryVo) {

        PageHelper.startPage(page, limit);
        List<Room> roomList = roomMapper.getRoomList(classRoomQueryVo);
        if (roomList.size() > 0) {
            PageInfo pageInfo = new PageInfo(roomList);
            return LayUiPageResponse.createBySuccess(roomList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无教室!!!");
        }
    }

    //修改1-2节课的状态
    public ServerResponse updateRoomSelection1State(Room room) {
        int count = roomMapper.updateByPrimaryKeySelective(room);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更改成功");
        } else {
            return ServerResponse.createByErrorMessage("更改失败");
        }
    }
    //修改3-4节课的状态
    public ServerResponse updateRoomSelection2State(Room room) {
        int count = roomMapper.updateByPrimaryKeySelective(room);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更改成功");
        } else {
            return ServerResponse.createByErrorMessage("更改失败");
        }
    }
    //修改5-6节课的状态
    public ServerResponse updateRoomSelection3State(Room room) {
        int count = roomMapper.updateByPrimaryKeySelective(room);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更改成功");
        } else {
            return ServerResponse.createByErrorMessage("更改失败");
        }
    }
    //修改7-8节课的状态
    public ServerResponse updateRoomSelection4State(Room room) {
        int count = roomMapper.updateByPrimaryKeySelective(room);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更改成功");
        } else {
            return ServerResponse.createByErrorMessage("更改失败");
        }
    }
    //修改教室的状态
    public ServerResponse updateRoomState(Room room) {
        int count = roomMapper.updateByPrimaryKeySelective(room);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更改成功");
        } else {
            return ServerResponse.createByErrorMessage("更改失败");
        }
    }
    //教师详情
    public ServerResponse detailRoom(Integer roomId) {

        Room room = roomMapper.selectByPrimaryKey(roomId);
        if (room != null) {
            return ServerResponse.createBySuccess("找到教室", room);
        } else {
            return ServerResponse.createByErrorMessage("未找到教室");
        }
    }
    //教师保存
    public ServerResponse saveRoom(Room room) {

        int x = room.getRoomPurpose().indexOf("[");
        int y = room.getRoomPurpose().indexOf("]");
        String roomPurposeString = room.getRoomPurpose().substring(x + 1, y);
        room.setRoomPurpose(roomPurposeString);
        int count = roomMapper.updateByPrimaryKeySelective(room);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("保存成功");
        } else {
            return ServerResponse.createByErrorMessage("保存失败");
        }
    }
    //教室删除
    public ServerResponse deleteRoom(Integer roomId) {

        int count = roomMapper.deleteByPrimaryKey(roomId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功!!!");
        } else {
            return ServerResponse.createByErrorMessage("删除失败!!!");
        }
    }





}
