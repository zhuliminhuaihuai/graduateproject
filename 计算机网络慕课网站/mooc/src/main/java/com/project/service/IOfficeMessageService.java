package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.OfficeMessage;
import com.project.vo.OfficeMessageVo;

public interface IOfficeMessageService {

    //获取机构所有信息（已经启用）
    ServerResponse getOfficeMessage();

    //获取机构视频宣传
    ServerResponse getOfficeVideo();

    //机构基本信息获取
    LayUiPageResponse getAllOfficeMessage(Integer page, Integer limit, OfficeMessageVo officeMessageVo);

    //修改机构启用状态
    ServerResponse updateOfficeMessageStage(OfficeMessage officeMessage);

    //机构信息详情
    ServerResponse detailOfficeMessage(Integer messageId);

    //机构信息保存
    ServerResponse saveOfficeMessage(OfficeMessage officeMessage);

    //删除机构信息
    ServerResponse deleteOfficeMessage(Integer messageId);

    //更换机构视频简介
    ServerResponse updateOfficeVideo(String officeVideo);

    //添加机构基本信息
    ServerResponse addOfficeMessage(OfficeMessage officeMessage);

}
