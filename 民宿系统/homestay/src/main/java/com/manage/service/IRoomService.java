package com.manage.service;

import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.pojo.Room;
import com.manage.vo.RoomQueryVo;

import javax.servlet.http.HttpServletRequest;

/**
 * IRoomService
 *
 * @author {zhulimin}
 * @date 2020/2/26 0026 下午 17:41
 */
public interface IRoomService {

    ServerResponse addRoom(HttpServletRequest request, Room room);

    ServerResponse updateRoomState(Integer roomId, Integer roomState);

    ServerResponse getRoom(Integer roomId);

    ServerResponse roomSave(Room room);

    ServerResponse deleteRoom(Integer roomId);

    ServerResponse portalRoomList(String roomSimpleRemark);

    LayUiPageResponse roomList(HttpServletRequest request,RoomQueryVo roomQueryVo, Integer page, Integer limit);
}
