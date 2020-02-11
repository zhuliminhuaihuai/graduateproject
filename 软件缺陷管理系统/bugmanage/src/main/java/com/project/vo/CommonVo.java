package com.project.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Getter
public class CommonVo {//所有模糊查询统一放这

    String userName;//用户名或查询通用字段
    String realName;//姓名名或查询通用字段
    String endTime;//结束时间
    String startTime;//开始时间
    String role;//角色
    Integer isDefault;//是否默认
    String userCode;//用户编号
    Integer isOn;//是否开启

    String bugTitle;//bug标题
    String status;//bug状态
    String typeId;//bug分类ID
    String bugName;//bug分类名称

    Integer projectId;//项目ID

    List<Integer> userIds; //用户userId集合

    Integer userId;
}
