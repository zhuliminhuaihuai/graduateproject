package com.manage.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.dao.RoomImgMapper;
import com.manage.dao.RoomMapper;
import com.manage.dao.UserMapper;
import com.manage.pojo.Room;
import com.manage.pojo.RoomImg;
import com.manage.pojo.User;
import com.manage.service.IRoomService;
import com.manage.util.PublicUtil;
import com.manage.vo.DataVo;
import com.manage.vo.PhotoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {


    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private RoomImgMapper roomImgMapper;
    @Autowired
    private UserMapper userMapper;

    //添加房源
    public ServerResponse addRoom(Room room, String imgMany) {
        String roomCode = PublicUtil.setCode("R");
        room.setRoomCode(roomCode);
        room.setRoomCreateTime(new Date());
        int count = roomMapper.insertSelective(room);
        int total = 0;
        if (count > 0) {
            String[] imgManyArray= imgMany.split("#");
            List<String> imgList =new ArrayList();
            for(String s : imgManyArray){
                imgList.add(s);
            }
            for (int i=0; i < imgList.size(); i++) {
                RoomImg roomImg = new RoomImg();
                roomImg.setRoomCode(roomCode);
                roomImg.setImgCode(imgList.get(i));
                roomImgMapper.insertSelective(roomImg);
                total++;
            }
            if (total == imgList.size()) {
                return ServerResponse.createBySuccessMessage("添加房源成功");
            } else {
                return ServerResponse.createByErrorMessage("添加房源失败");
            }
        } else {
            return ServerResponse.createByErrorMessage("添加房源失败");
        }
    }
    //找到房源列表
    public LayUiPageResponse roomList(Room room, Integer page, Integer limit) {

        System.out.println("窗户" + room.getRoomIsWindow());
        PageHelper.startPage(page, limit);
        List<Room> roomList = roomMapper.findAllRoomByCondition(room);
        String photoPath = "http://127.0.0.1:8080/upload/";

        if (roomList.size() > 0) {
            for (int i = 0; i < roomList.size(); i++) {
                roomList.get(i).setRomImg(photoPath + roomList.get(i).getRomImg());
            }
            PageInfo pageInfo = new PageInfo(roomList);
            return LayUiPageResponse.createBySuccess(roomList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据！！");
        }
    }
    //根据id查询房源的详情照片
    public ServerResponse roomPhotoDetail(Integer roomId) {

        Room room = roomMapper.selectByPrimaryKey(roomId);
        if (room != null) {
            String roomCode = room.getRoomCode();
            List<RoomImg> roomImgList = roomImgMapper.findRoomImg(roomCode);
            if (roomImgList.size() > 0) {
                return ServerResponse.createBySuccess("找到房源照片", roomImgList);
            } else {
                return ServerResponse.createByErrorMessage("未找到房源照片");
            }
        } else {
            return ServerResponse.createByErrorMessage("未找到该房源！");
        }
    }
    //根据id查询房源的详情照片 返回特定json
    public ServerResponse roomPhotoCallBackData(Integer roomId) {
        Room room = roomMapper.selectByPrimaryKey(roomId);
        if (room != null) {
            String roomCode = room.getRoomCode();
            List<RoomImg> roomImgList = roomImgMapper.findRoomImg(roomCode);
            String photoPath = "http://127.0.0.1:8080/upload/";

            PhotoVo photoVo = new PhotoVo();

            List<DataVo> dataVoList = Lists.newArrayList();
            if (roomImgList.size() > 0) {
                for (int i = 0; i < roomImgList.size(); i++) {
                    DataVo dataVo = new DataVo();
                    dataVo.setPid(String.valueOf(i));
                    dataVo.setAlt("照片" + (i + 1));
                    dataVo.setSrc(photoPath+roomImgList.get(i).getImgCode());
                    dataVo.setThumb(photoPath+roomImgList.get(i).getImgCode());
                    dataVoList.add(dataVo);
                }
                photoVo.setData(dataVoList);
                photoVo.setId(String.valueOf(1));
                photoVo.setStart(String.valueOf(0));
                photoVo.setTitle("照片相册");
                return ServerResponse.createBySuccess("找到房源照片", photoVo);
            } else {
                return ServerResponse.createByErrorMessage("未找到房源照片");
            }
        } else {
            return ServerResponse.createByErrorMessage("未找到该房源！");
        }

    }
    //上传房内照片
    public ServerResponse addRoomImg(Integer roomId, String photoImg) {

        Room room = roomMapper.selectByPrimaryKey(roomId);
        String roomCode = room.getRoomCode();
        RoomImg roomImg = new RoomImg();
        roomImg.setRoomCode(roomCode);
        roomImg.setImgCode(photoImg);
        int count = roomImgMapper.insertSelective(roomImg);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("上传成功");
        } else {
            return ServerResponse.createByErrorMessage("上传失败");
        }
    }
    //删除单张照片
    public ServerResponse deleteRoomImg(Integer imgId) {

        int count = roomImgMapper.deleteByPrimaryKey(imgId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }
    //删除多张照片
    public ServerResponse deleteManyRoomImg(@Param("photoIds") String photoIds) {

        int x = photoIds.indexOf("[");
        int y = photoIds.indexOf("]");
        String photoIdsString = photoIds.substring(x + 1, y );
        System.out.println(photoIdsString);
        String[] photoIdsStringArray= photoIdsString.split(",");
        List<Integer> idList =new ArrayList();
        for(String s : photoIdsStringArray){
            Integer i = Integer.parseInt(s);
            idList.add(i);
        }
        int count = roomImgMapper.deleteManyRoomImg(idList);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }
    //修改房源启用状态
    public ServerResponse modifyRoomIsUseState(Integer roomId, Integer roomIsUse) {

        int count = roomMapper.updateRoomIsUseState(roomId, roomIsUse);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        } else {
            return ServerResponse.createByErrorMessage("修改失败");
        }
    }
    //删除房源
    public ServerResponse deleteRoom(Integer roomId) {

        int count = roomMapper.deleteByPrimaryKey(roomId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }
    //批量删除房源
    public ServerResponse deleteSomeRoom(String ids) {

        int i = ids.indexOf("[");
        int j = ids.indexOf("]");
        String s1 = ids.substring(i + 1, j);
        String[] idsArray= s1.split(",");
        List<Integer> idList =new ArrayList();
        for(String s : idsArray){
            Integer k = Integer.parseInt(s);
            idList.add(k);
        }
        int count = roomMapper.deleteSomeRoom(idList);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }

    }
    //房内基本设施详情
    public ServerResponse roomMessageDetail(Integer roomId) {

        Room room = roomMapper.selectByPrimaryKey(roomId);
        if (room != null) {
            return ServerResponse.createBySuccess("找到房源", room);
        } else {
            return ServerResponse.createByErrorMessage("未找到该房源");
        }
    }
    //保存修改房内基本设施
    public ServerResponse saveModifyRoomMessage(Room room) {

        int count = roomMapper.updateByPrimaryKeySelective(room);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("保存成功");
        } else {
            return ServerResponse.createByErrorMessage("保存失败");
        }
    }
    //查看预约或入住该房源的客户基本信息
    public ServerResponse seeUser(Integer roomId) {

        Room room = roomMapper.selectByPrimaryKey(roomId);
        String userCode = room.getUserCode();
        User user = userMapper.findUserByUserCode(userCode);
        if (user != null) {
            return ServerResponse.createBySuccess("找到客户", user);
        } else {
            return ServerResponse.createByErrorMessage("未找到客户");
        }
    }
}
