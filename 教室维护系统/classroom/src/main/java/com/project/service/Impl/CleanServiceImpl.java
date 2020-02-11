package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.CleanMapper;
import com.project.dao.RoomMapper;
import com.project.pojo.Clean;
import com.project.pojo.Room;
import com.project.service.ICleanService;
import com.project.util.DateUtil;
import com.project.util.PublicUtil;
import com.project.vo.CleanQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * CleanServiceImpl
 *
 * @author {zhulimin}
 * @date 2020/1/21 0021 上午 11:28
 */
@Service
public class CleanServiceImpl implements ICleanService {

    private final String date1 = "8:00:00";//1

    private final String date2 = "9:35:00";//1

    private final String date3 = "9:55:00";//2

    private final String date4 = "11:30:00";//2

    private final String date5 = "14:00:00";//3

    private final String date6 = "15:35:00";//3

    private final String date7 = "15:55:00";//4

    private final String date8 = "17:30:00";//4

    @Autowired
    private CleanMapper cleanMapper;

    @Autowired
    private RoomMapper roomMapper;

    /**
     * 创建打扫单
     * @param roomId
     * @return
     */
    @Override
    public ServerResponse addClean(Integer roomId) {
        Room room = roomMapper.selectByPrimaryKey(roomId);
        long nowDate = getNowHourAndMinuteAndSecond();
        System.out.println("----->" + nowDate);
        //校验上课时间
        ServerResponse<Clean> cleanServerResponse = checkClassTime(room, nowDate);
        if (cleanServerResponse != null) {
            return cleanServerResponse;
        }
        Clean clean = new Clean();
        clean.setCleanCode(PublicUtil.setCode("W"));
        clean.setCleanCreateTime(new Date());
        clean.setCleanState(1);
        clean.setRoomId(room.getRoomId());
        clean.setRoomCode(room.getRoomCode());
        int count = cleanMapper.insertSelective(clean);
        if (count > 0) {
            room.setRoomUpdateTime(new Date());
            room.setRoomClearState(2);
            roomMapper.updateByPrimaryKeySelective(room);
            return ServerResponse.createBySuccess("打扫发起成功", clean);
        } else {
            return ServerResponse.createByErrorMessage("打扫发起失败");
        }
    }

    @Override
    public LayUiPageResponse cleanList(CleanQueryVo cleanQueryVo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Clean> cleanList = cleanMapper.getCleanList(cleanQueryVo);
        if (cleanList.size() > 0) {
            PageInfo pageInfo = new PageInfo(cleanList);
            return LayUiPageResponse.createBySuccess(cleanList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无打扫单!!!");
        }
    }

    @Override
    public ServerResponse cleanOver(Integer cleanId) {
        Clean clean = cleanMapper.selectByPrimaryKey(cleanId);
        clean.setCleanUpdateTime(new Date());
        clean.setCleanState(2);
        clean.setCleanTime(new Date());
        int count = cleanMapper.updateByPrimaryKeySelective(clean);
        if (count > 0) {
            Room room = roomMapper.selectByPrimaryKey(clean.getRoomId());
            room.setRoomUpdateTime(new Date());
            room.setRoomClearState(1);
            roomMapper.updateByPrimaryKeySelective(room);
            return ServerResponse.createBySuccess("打扫完毕", clean);
        } else {
            return ServerResponse.createByErrorMessage("打扫完毕失败");
        }
    }

    @Override
    public ServerResponse cleanDetail(Integer cleanId) {
        Clean clean = cleanMapper.selectByPrimaryKey(cleanId);
        if (clean != null) {
            return ServerResponse.createBySuccess("找到打扫单", clean);
        } else {
            return ServerResponse.createByErrorMessage("没能找到打扫单");
        }
    }

    private ServerResponse<Clean> checkClassTime(Room room, long nowDate) {
        if (room.getRoomSections1() == 1) {
            if (between1(nowDate)) {
                return ServerResponse.createByErrorMessage("教室1~2节有课，不能打扫");
            }
        }
        if (room.getRoomSections2() == 1) {
            if (between2(nowDate)) {
                return ServerResponse.createByErrorMessage("教室3~4节有课，不能打扫");
            }
        }
        if (room.getRoomSections3() == 1) {
            if (between3(nowDate)) {
                return ServerResponse.createByErrorMessage("教室5~6节有课，不能打扫");
            }
        }
        if (room.getRoomSections4() == 1) {
            if (between4(nowDate)) {
                return ServerResponse.createByErrorMessage("教室7~8节有课，不能打扫");
            }
        }
        return null;
    }

    private long getNowHourAndMinuteAndSecond() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY) * 3600 + cal.get(Calendar.MINUTE) * 60 + cal.get(Calendar.SECOND);
    }

    //时间是否在第一节课时间里
    private boolean between1(long nowDate) {
        String[]array1 = date1.split(":");
        int total1 = Integer.valueOf(array1[0])*3600+Integer.valueOf(array1[1])*60+Integer.valueOf(array1[2]);
        System.out.println(total1);
        String[]array2 = date2.split(":");
        int total2 = Integer.valueOf(array2[0]) * 3600 + Integer.valueOf(array2[1]) * 60 + Integer.valueOf(array2[2]);
        System.out.println(total2);
        if (nowDate >= total1 && nowDate <= total2) {
            return true;
        } else {
            return false;
        }
    }
    private boolean between2(long nowDate) {
        String[]array1 = date3.split(":");
        int total1 = Integer.valueOf(array1[0])*3600+Integer.valueOf(array1[1])*60+Integer.valueOf(array1[2]);
        System.out.println(total1);
        String[]array2 = date4.split(":");
        int total2 = Integer.valueOf(array2[0]) * 3600 + Integer.valueOf(array2[1]) * 60 + Integer.valueOf(array2[2]);
        System.out.println(total2);
        if (nowDate >= total1 && nowDate <= total2) {
            return true;
        } else {
            return false;
        }
    }
    private boolean between3(long nowDate) {
        String[]array1 = date5.split(":");
        int total1 = Integer.valueOf(array1[0])*3600+Integer.valueOf(array1[1])*60+Integer.valueOf(array1[2]);
        System.out.println(total1);
        String[]array2 = date6.split(":");
        int total2 = Integer.valueOf(array2[0]) * 3600 + Integer.valueOf(array2[1]) * 60 + Integer.valueOf(array2[2]);
        System.out.println(total2);
        if (nowDate >= total1 && nowDate <= total2) {
            return true;
        } else {
            return false;
        }
    }
    private boolean between4(long nowDate) {
        String[]array1 = date7.split(":");
        int total1 = Integer.valueOf(array1[0])*3600+Integer.valueOf(array1[1])*60+Integer.valueOf(array1[2]);
        System.out.println(total1);
        String[]array2 = date8.split(":");
        int total2 = Integer.valueOf(array2[0]) * 3600 + Integer.valueOf(array2[1]) * 60 + Integer.valueOf(array2[2]);
        System.out.println(total2);
        if (nowDate >= total1 && nowDate <= total2) {
            return true;
        } else {
            return false;
        }
    }
}
