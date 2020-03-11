package com.manage.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.manage.common.Const;
import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.dao.RoomMapper;
import com.manage.dao.UserMapper;
import com.manage.pojo.Room;
import com.manage.pojo.User;
import com.manage.service.IRoomService;
import com.manage.util.PublicUtil;
import com.manage.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * RoomServiceImpl
 *
 * @author {zhulimin}
 * @date 2020/2/26 0026 下午 17:42
 */
@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse addRoom(HttpServletRequest request, Room room) {

        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);

        User user1 = userMapper.findUserByUserCode(room.getTenantCode());
        if (user1.getUserFindPassword() == null) {
            return ServerResponse.createByErrorMessage("该房东还未实名");
        }
        room.setTenantName(user1.getHeadimg());
        room.setUploadCode(user.getUserCode());
        room.setUploadName(user.getHeadimg());
        room.setRoomCode(PublicUtil.setCode("R"));
        room.setRoomCreateTime(new Date());
        int count = roomMapper.insertSelective(room);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("添加成功");
        } else {
            return ServerResponse.createByErrorMessage("添加失败");
        }
    }

    @Override
    public ServerResponse updateRoomState(Integer roomId, Integer roomState) {
        Room room = roomMapper.selectByPrimaryKey(roomId);
        room.setRoomState(roomState);
        room.setRoomUpdateTime(new Date());
        int count = roomMapper.updateByPrimaryKeySelective(room);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更新成功");
        } else {
            return ServerResponse.createByErrorMessage("更新失败");
        }
    }

    @Override
    public ServerResponse getRoom(Integer roomId) {
        Room room = roomMapper.selectByPrimaryKey(roomId);
        return ServerResponse.createBySuccess("找到房源", room);
    }

    @Override
    public ServerResponse roomSave(Room room) {
        int count = roomMapper.updateByPrimaryKeySelective(room);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("保存成功");
        } else {
            return ServerResponse.createByErrorMessage("保存失败");
        }
    }

    @Override
    public ServerResponse deleteRoom(Integer roomId) {
        int count = roomMapper.deleteByPrimaryKey(roomId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }

    @Override
    public ServerResponse portalRoomList(String roomSimpleRemark) {
        RoomQueryVo roomQueryVo = new RoomQueryVo();
        roomQueryVo.setRoomSimpleRemark(roomSimpleRemark);
        roomQueryVo.setRoomState("1");

        List<Room> roomList = roomMapper.getRoomList(roomQueryVo);
        List<ContentVo> content = Lists.newArrayList();
        if (roomList.size() > 0) {
            RoomVo roomVo = new RoomVo();
            MenuVo1 menu = new MenuVo1();
            MilkVo milk = new MilkVo();
            String photoPath = "http://127.0.0.1:8080/upload/";
            for (int i = 0; i < roomList.size(); i++) {
                Room room = roomList.get(i);
                ContentVo contentVo = new ContentVo();
                //照片
                contentVo.setImg(photoPath + room.getRoomImg());
                //简述
                contentVo.setTitle(room.getRoomSimpleRemark());
                //房间数量
                contentVo.setRoomNumber(room.getRoomNumber());
                //床数量
                contentVo.setRoomBedNumber(room.getRoomBedNumber());
                //浴室数量
                contentVo.setRoomBathNumber(room.getRoomBathNumber());
                //最大数量
                contentVo.setRoomMaxCustomerNumber(room.getRoomMaxCustomerNumber());
                //厕所数量
                contentVo.setRoomWcNumber(room.getRoomWcNumber());
                //主键
                contentVo.setRoomId(room.getRoomId());
                //交易价
                contentVo.setPri(room.getRoomRelPrice());
                //参考价
                contentVo.setDelpri(room.getRoomReferencePrice());
                //主题
                contentVo.setRoomTitle(room.getRoomTitle());

                content.add(contentVo);
            }
            milk.setContent(content);
            menu.setMilk(milk);
            roomVo.setStatus(0);
            roomVo.setMenu(menu);
            roomVo.setCount(roomList.size());
            return ServerResponse.createBySuccess("找到房源", roomVo);
        }else {
            return ServerResponse.createByErrorMessage("没有数据");
        }
    }

    @Override
    public LayUiPageResponse roomList(HttpServletRequest request,RoomQueryVo roomQueryVo, Integer page, Integer limit) {
        User user1 = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);

        if (user1.getUserRole() == Const.Role.ROLE_TENANT) {
            roomQueryVo.setTenantCode(user1.getUserCode());
        }
        PageHelper.startPage(page, limit);
        List<Room> roomList = roomMapper.getRoomList(roomQueryVo);
        String photoPath = "http://127.0.0.1:8080/upload/";

        if (roomList.size() > 0) {
            for (int i = 0; i < roomList.size(); i++) {
                roomList.get(i).setRoomImg(photoPath + roomList.get(i).getRoomImg());
            }
            PageInfo pageInfo = new PageInfo(roomList);
            return LayUiPageResponse.createBySuccess(roomList, pageInfo.getTotal(), page, limit);
        }else{
            return LayUiPageResponse.createByErrorMessage("暂无数据！");
        }
    }
}
