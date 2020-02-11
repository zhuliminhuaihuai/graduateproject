package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.DefendMapper;
import com.project.dao.RoomMapper;
import com.project.pojo.Defend;
import com.project.pojo.Room;
import com.project.service.IDefendService;
import com.project.vo.DefendQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * DefendServiceImpl
 *
 * @author {zhulimin}
 * @date 2020/1/15 0015 上午 11:50
 */
@Service
public class DefendServiceImpl implements IDefendService {

    @Autowired
    private DefendMapper defendMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public LayUiPageResponse getDefendList(DefendQueryVo defendQueryVo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Defend> defendList = defendMapper.getDefendList(defendQueryVo);
        if (defendList.size() > 0) {
            PageInfo pageInfo = new PageInfo(defendList);
            return LayUiPageResponse.createBySuccess(defendList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无维护单!!!");
        }
    }

    /**
     * 维护完毕
     *
     * @param defendId
     * @return
     */
    @Override
    public ServerResponse defendOver(Integer defendId) {
        Defend defend = defendMapper.selectByPrimaryKey(defendId);
        defend.setDefendUpdateTime(new Date());
        defend.setDefendTime(new Date());
        defend.setDefendState(2);
        int count = defendMapper.updateByPrimaryKeySelective(defend);
        if (count > 0) {
            List<Defend> defendList = defendMapper.findDefendByRoomCodeAndDefendState(defend.getRoomCode(), 1);
            if (defendList.size() == 0) {
                Room room = roomMapper.selectByPrimaryKey(defend.getRoomId());
                room.setRoomUpdateTime(new Date());
                room.setRoomCheckState(1);
                roomMapper.updateByPrimaryKey(room);
            }
            return ServerResponse.createBySuccess("维护完毕成功", defend);
        } else {
            return ServerResponse.createByErrorMessage("维护完毕失败");
        }
    }
}
