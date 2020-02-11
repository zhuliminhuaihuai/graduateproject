package com.managesystem.service.Impl;

import com.managesystem.common.ServerResponse;
import com.managesystem.dao.BedRoomMapper;
import com.managesystem.dao.UserMapper;
import com.managesystem.pojo.BedRoom;
import com.managesystem.pojo.User;
import com.managesystem.service.IBedRoomService;
import com.managesystem.util.PublicUtil;
import com.managesystem.vo.BedRoomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BedRoomServiceImpl implements IBedRoomService {

    @Autowired
    private BedRoomMapper bedRoomMapper;

    @Autowired
    private UserMapper userMapper;


    //一键生成房间
    public ServerResponse addManyBedRoom(BedRoomVo bedRoomVo) {

        //生成房间之间先删除宿舍楼底下的所有的房间
        bedRoomMapper.deleteBuildingUnderBedRoom(bedRoomVo.getBuildingCode());

        Integer floor = Integer.parseInt(bedRoomVo.getFloorNumber());
        Integer bedroomnumber = Integer.parseInt(bedRoomVo.getBedRoomNumber());
        int sum = 0;
        for (int i = 1; i <= floor; i++) {
            for (int j = 1; j <= bedroomnumber; j++) {
                BedRoom bedRoom = new BedRoom();
                bedRoom.setBedroomCode(PublicUtil.setCode("B"));
                if (j <= 9) {
                    bedRoom.setBedroomTitle(i + "-" + i + "0" + j);
                } else {
                    bedRoom.setBedroomTitle(i + "-" + i + j);
                }
                bedRoom.setBedroomNumber(Integer.parseInt(bedRoomVo.getUserNumber()));
                bedRoom.setBedroomPeople(0);
                bedRoom.setBedroomState(1);
                bedRoom.setBuildingCode(bedRoomVo.getBuildingCode());
                bedRoom.setBedroomCreateTime(new Date());
                int count = bedRoomMapper.insertSelective(bedRoom);
                sum += count;
            }
        }
        if (sum == (floor * bedroomnumber)) {
            return ServerResponse.createBySuccessMessage("生成成功");
        } else {
            return ServerResponse.createByErrorMessage("生成失败");
        }
    }
    //安排学生入住
    public ServerResponse checkInBedRoom(String ids, Integer bedroomId) {

        int i = ids.indexOf("[");
        int j = ids.indexOf("]");
        String s1 = ids.substring(i + 1, j);
        String[] idsArray= s1.split(",");
        List<Integer> idList =new ArrayList();
        for(String s : idsArray){
            Integer k = Integer.parseInt(s);
            idList.add(k);
        }
        BedRoom bedRoom = bedRoomMapper.selectByPrimaryKey(bedroomId);
        if (idList.size() + bedRoom.getBedroomPeople() > bedRoom.getBedroomNumber()) {
            return ServerResponse.createByErrorMessage("入住人数过多");
        }
        String bedRoomCode = bedRoom.getBedroomCode();
        User user = userMapper.selectByPrimaryKey(idList.get(0));
        int count = userMapper.updateStudentCheckInRoom(idList, bedRoomCode);
        if (count > 0) {

            bedRoom.setBedroomFaculty(user.getUserFaculty());
            bedRoom.setBedroomPeople(bedRoom.getBedroomPeople()+idList.size());
            if (bedRoom.getBedroomPeople() == bedRoom.getBedroomNumber()) {
                bedRoom.setBedroomState(2);
            }
            int updateCount = bedRoomMapper.updateByPrimaryKey(bedRoom);
            if (updateCount > 0) {
                return ServerResponse.createBySuccessMessage("入住成功");
            } else {
                return ServerResponse.createByErrorMessage("入住失败");
            }
        } else {
            return ServerResponse.createByErrorMessage("入住失败");
        }
    }
}
