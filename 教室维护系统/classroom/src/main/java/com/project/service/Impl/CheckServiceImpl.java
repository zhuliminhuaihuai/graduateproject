package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.CheckMapper;
import com.project.dao.DefendMapper;
import com.project.dao.RoomMapper;
import com.project.pojo.Check;
import com.project.pojo.Defend;
import com.project.pojo.Room;
import com.project.service.ICheckService;
import com.project.util.PublicUtil;
import com.project.vo.CheckQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * CheckServiceImpl
 *
 * @author {zhulimin}
 * @date 2020/1/13 0013 下午 17:40
 */
@Service
public class CheckServiceImpl implements ICheckService {


    @Autowired
    private CheckMapper checkMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private DefendMapper defendMapper;

    /**
     * @param check 检查单信息
     * @return
     */
    @Override
    public ServerResponse addCheck(Check check) {

        //查询教室信息
        Room room = roomMapper.selectByPrimaryKey(check.getRoomId());

        check.setCheckCode(PublicUtil.setCode("C"));
        check.setCheckCreateTime(new Date());
        //1.待反馈
        check.setCheckState(1);
        int count = checkMapper.insertSelective(check);
        if (count > 0) {
            //发起成功更改教室检查状态
            room.setRoomCheckState(2);
            room.setRoomCheckNumber(room.getRoomCheckNumber() + 1);
            room.setRoomUpdateTime(new Date());
            roomMapper.updateByPrimaryKeySelective(room);
            return ServerResponse.createBySuccessMessage("发起成功!");
        } else {
            return ServerResponse.createByErrorMessage("发起失败!");
        }
    }

    /**
     * 查询检查单
     *
     * @param checkQueryVo 查询条件
     * @param page         页码
     * @param limit        大小
     * @return
     */
    @Override
    public LayUiPageResponse getCheckList(CheckQueryVo checkQueryVo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Check> checkList = checkMapper.getCheckList(checkQueryVo);
        if (checkList.size() > 0) {
            PageInfo pageInfo = new PageInfo(checkList);
            return LayUiPageResponse.createBySuccess(checkList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无检查单!!!");
        }
    }

    /**
     * @param checkId 主键
     * @return
     */
    @Override
    public ServerResponse getCheck(Integer checkId) {
        Check check = checkMapper.selectByPrimaryKey(checkId);
        if (check != null) {
            return ServerResponse.createBySuccess("找到检查单", check);
        } else {
            return ServerResponse.createByErrorMessage("未找到检查单");
        }
    }

    /**
     * 反馈检查单
     * @param check 检查单信息
     * @return
     */
    @Override
    public ServerResponse addCheckMoreMessage(Check check,String defendObjectArray) {
        //查询表中检查单信息
        System.out.println(defendObjectArray);
        List<String> defendObjectList = Arrays.asList(defendObjectArray);
        Check check1 = checkMapper.selectByPrimaryKey(check.getCheckId());
        check.setCheckTime(new Date());
        check.setCheckState(2);
        int count = checkMapper.updateByPrimaryKeySelective(check);
        if (count > 0) {
            Room room = roomMapper.selectByPrimaryKey(check1.getRoomId());
            //发起维护单
            startDefend(check, defendObjectList, check1, room);
            room.setRoomUpdateTime(new Date());
            roomMapper.updateByPrimaryKeySelective(room);
            return ServerResponse.createBySuccess("反馈成功", check);
        } else {
            return ServerResponse.createByErrorMessage("反馈失败");
        }
    }

    private void startDefend(Check check, List<String> defendObjectList, Check check1, Room room) {
        System.out.println(defendObjectList);
        System.out.println(defendObjectList.size());
        if (defendObjectList.size() != 0) {
            boolean flag = false;

            //创建维护单基本信息
            Defend defend = new Defend();
            defend.setDefendCreateTime(new Date());
            defend.setRoomCode(check1.getRoomCode());
            defend.setRoomId(check1.getRoomId());
            defend.setCheckId(check1.getCheckId());
            defend.setCheckCode(check1.getCheckCode());
            defend.setDefendState(1);
            if (check.getRoomIsDamageWindow() == 1) {
                defend.setDefendCode(PublicUtil.setCode("D"));
                defend.setDefendObject("窗户");
                defend.setDefendNumber(check.getRoomDamageWindowNumber());
                defend.setDefendReason("无");
                defendMapper.insertSelective(defend);
            }
            if (check.getRoomIsDamageChair() == 1) {
                flag = true;
                defend.setDefendCode(PublicUtil.setCode("D"));
                defend.setDefendObject("座椅");
                defend.setDefendNumber(check.getRoomDamageChairNumber());
                defend.setDefendReason("无");
                defendMapper.insertSelective(defend);
            }
            if (check.getRoomIsNeedChalk() == 1) {
                flag = true;

                defend.setDefendCode(PublicUtil.setCode("D"));
                defend.setDefendObject("粉笔");
                defend.setDefendNumber(check.getRoomNeedChalkNumber());
                defend.setDefendReason("无");
                defendMapper.insertSelective(defend);
            }
            if (check.getRoomIsDamagePlatform() == 1) {
                flag = true;

                defend.setDefendCode(PublicUtil.setCode("D"));
                defend.setDefendObject("讲台");
                defend.setDefendNumber(1);
                defend.setDefendReason(check.getRoomDamagePlatformReason());
                defendMapper.insertSelective(defend);
            }
            if (check.getRoomIsDamageBlackboard() == 1) {
                flag = true;

                defend.setDefendCode(PublicUtil.setCode("D"));
                defend.setDefendObject("黑板");
                defend.setDefendNumber(1);
                defend.setDefendReason(check.getRoomDamageBlackboardReason());
                defendMapper.insertSelective(defend);
            }
            if (check.getRoomIsDamageMedia() == 1) {
                flag = true;

                defend.setDefendCode(PublicUtil.setCode("D"));
                defend.setDefendObject("多媒体");
                defend.setDefendNumber(1);
                defend.setDefendReason(check.getRoomDamageMediaReason());
                defendMapper.insertSelective(defend);
            }
            if (check.getRoomIsDamageMicrophone() == 1) {
                flag = true;

                defend.setDefendCode(PublicUtil.setCode("D"));
                defend.setDefendObject("麦克风");
                defend.setDefendNumber(1);
                defend.setDefendReason(check.getRoomDamageMicrophoneReason());
                defendMapper.insertSelective(defend);
            }
            if (check.getRoomIsDamageDoor() == 1) {
                flag = true;

                defend.setDefendCode(PublicUtil.setCode("D"));
                defend.setDefendObject("门");
                defend.setDefendNumber(check.getRoomDamageDoorNumber());
                defend.setDefendReason(check.getRoomDamageDoorReason());
                defendMapper.insertSelective(defend);
            }
            if (check.getRoomIsDamageSound() == 1) {
                flag = true;

                defend.setDefendCode(PublicUtil.setCode("D"));
                defend.setDefendObject("音响");
                defend.setDefendNumber(check.getRoomDamageSoundNumber());
                defend.setDefendReason(check.getRoomDamageSoundReason());
                defendMapper.insertSelective(defend);
            }
            if (check.getRoomIsDamageCurtains() == 1) {
                flag = true;

                defend.setDefendCode(PublicUtil.setCode("D"));
                defend.setDefendObject("窗帘");
                defend.setDefendNumber(check.getRoomDamageCurtainsNumber());
                defend.setDefendReason(check.getRoomDamageCurtainsReason());
                defendMapper.insertSelective(defend);
            }
            if (flag) {
                //有维护对象需要更改教室状态
                room.setRoomDefendNumber(room.getRoomDefendNumber() + 1);
                room.setRoomCheckState(3);
            } else {
                room.setRoomCheckState(1);
            }
        } else {
            room.setRoomCheckState(1);
        }
    }
}
