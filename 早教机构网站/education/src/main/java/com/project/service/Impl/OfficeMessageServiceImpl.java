package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.OfficeMessageMapper;
import com.project.pojo.OfficeMessage;
import com.project.service.IOfficeMessageService;
import com.project.util.PublicUtil;
import com.project.vo.OfficeMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OfficeMessageServiceImpl implements IOfficeMessageService {

    @Autowired
    private OfficeMessageMapper officeMessageMapper;

    //获取机构所有信息（已经启用）
    public ServerResponse getOfficeMessage() {
        List<OfficeMessage> officeMessageList = officeMessageMapper.getOfficeMessage();
        if (officeMessageList.size() > 0) {
            return ServerResponse.createBySuccess("找到结果", officeMessageList);
        } else {
            return ServerResponse.createByErrorMessage("暂无数据");
        }
    }

    //获取机构视频宣传
    public ServerResponse getOfficeVideo() {

        OfficeMessage officeMessage = officeMessageMapper.getOfficeVideo();
        if (officeMessage != null) {
            return ServerResponse.createBySuccess("找到视频", officeMessage);
        } else {
            return ServerResponse.createByErrorMessage("暂未找到视频");
        }
    }
    //机构基本信息获取
    public LayUiPageResponse getAllOfficeMessage(Integer page, Integer limit, OfficeMessageVo officeMessageVo) {

        PageHelper.startPage(page, limit);
        List<OfficeMessage> officeMessageList = officeMessageMapper.getAllOfficeMessage(officeMessageVo);
        String photoPath = "http://127.0.0.1:8080/upload/";
        if (officeMessageList.size() > 0) {
            for (int i = 0; i < officeMessageList.size(); i++) {
                officeMessageList.get(i).setMessageImg(photoPath + officeMessageList.get(i).getMessageImg());
            }
            PageInfo pageInfo = new PageInfo(officeMessageList);
            return LayUiPageResponse.createBySuccess(officeMessageList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无信息!");
        }
    }
    //修改机构启用状态
    public ServerResponse updateOfficeMessageStage(OfficeMessage officeMessage) {

        int count = officeMessageMapper.updateByPrimaryKeySelective(officeMessage);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        } else {
            return ServerResponse.createByErrorMessage("修改失败");
        }
    }
    //机构信息详情
    public ServerResponse detailOfficeMessage(Integer messageId) {

        OfficeMessage officeMessage = officeMessageMapper.selectByPrimaryKey(messageId);
        if (officeMessage != null) {
            return ServerResponse.createBySuccess("找到该条信息", officeMessage);
        } else {
            return ServerResponse.createByErrorMessage("无此条信息");
        }
    }
    //机构信息保存
    public ServerResponse saveOfficeMessage(OfficeMessage officeMessage) {

        int count = officeMessageMapper.updateByPrimaryKeySelective(officeMessage);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("保存成功");
        } else {
            return ServerResponse.createByErrorMessage("保存失败");
        }
    }
    //删除机构信息
    public ServerResponse deleteOfficeMessage(Integer messageId) {

        int total = officeMessageMapper.getOfficeMessageCount();
        if (total == 1) {
            return ServerResponse.createByErrorMessage("不能删除!机构信息必须大于1条，请重新添加信息再选择删除!");
        }
        int count = officeMessageMapper.deleteByPrimaryKey(messageId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }
    //更换机构视频简介
    public ServerResponse updateOfficeVideo(String officeVideo) {

        int count = officeMessageMapper.updateOfficeVideo(officeVideo);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更换成功!");
        } else {
            return ServerResponse.createByErrorMessage("更换失败!");
        }
    }
    //添加机构基本信息
    public ServerResponse addOfficeMessage(OfficeMessage officeMessage) {

        officeMessage.setMessageCode(PublicUtil.setCode("P"));
        officeMessage.setMessageCreateTime(new Date());
        OfficeMessage officeMessage1 = officeMessageMapper.getOfficeVideo();
        officeMessage.setMessageVideo(officeMessage1.getMessageVideo());
        int count = officeMessageMapper.insertSelective(officeMessage);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("添加成功");
        } else {
            return ServerResponse.createByErrorMessage("添加失败");
        }
    }
}
