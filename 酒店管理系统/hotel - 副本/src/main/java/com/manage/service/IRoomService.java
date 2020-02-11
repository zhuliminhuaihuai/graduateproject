package com.manage.service;

import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.pojo.Room;
import org.apache.ibatis.annotations.Param;

public interface IRoomService {


    //添加房源
    ServerResponse addRoom(Room room, String imgMany);

    //找到房源列表
    LayUiPageResponse roomList(Room room, Integer page, Integer limit);

    //根据id查询房源的详情照片
    ServerResponse roomPhotoDetail(Integer roomId);

    //根据id查询房源的详情照片 返回特定json
    ServerResponse roomPhotoCallBackData(Integer roomId);

    //上传房内照片
    ServerResponse addRoomImg(Integer roomId, String photoImg);

    //删除单张照片
    ServerResponse deleteRoomImg(Integer imgId);

    //删除多张照片
    ServerResponse deleteManyRoomImg(@Param("photoIds") String photoIds);

    //修改房源启用状态
    ServerResponse modifyRoomIsUseState(Integer roomId, Integer roomIsUse);

    //删除房源
    ServerResponse deleteRoom(Integer roomId);

    //批量删除房源
    ServerResponse deleteSomeRoom(String ids);

    //房内基本设施详情
    ServerResponse roomMessageDetail(Integer roomId);

    //保存修改房内基本设施
    ServerResponse saveModifyRoomMessage(Room room);

    //查看预约或入住该房源的客户基本信息
    ServerResponse seeUser(Integer roomId);
}
