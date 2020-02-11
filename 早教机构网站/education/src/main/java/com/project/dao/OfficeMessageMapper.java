package com.project.dao;

import com.project.pojo.OfficeMessage;
import com.project.vo.OfficeMessageVo;

import java.util.List;

public interface OfficeMessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(OfficeMessage record);

    int insertSelective(OfficeMessage record);

    OfficeMessage selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(OfficeMessage record);

    int updateByPrimaryKeyWithBLOBs(OfficeMessage record);

    int updateByPrimaryKey(OfficeMessage record);

    //获取机构所有信息（已经启用）
    List<OfficeMessage> getOfficeMessage();

    //获取机构视频宣传
    OfficeMessage getOfficeVideo();

    //机构基本信息获取
    List<OfficeMessage> getAllOfficeMessage(OfficeMessageVo officeMessageVo);

    //查询信息总条数
    int getOfficeMessageCount();

    //更换机构视频简介
    int updateOfficeVideo(String messageVideo);


}