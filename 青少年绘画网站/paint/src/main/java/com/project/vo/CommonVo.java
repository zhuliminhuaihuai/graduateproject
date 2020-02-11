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
    Integer userId;
    List<Integer> userIds;//用户ID集合
    Integer branchId;
    String isOn;//是否上下架 1上 0下
    String isCheck;//是否审核通过 0待审核 1审核通过 2审核失败
    String isSelect;//是否精选 1是 0否
    String productType;//作品类型 色彩作品：1； 素描作品：2； 速写作品：3; 油画作品：4;  其他作品：5

    @Override
    public String toString() {
        return "CommonVo{" +
                "userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", endTime='" + endTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", role='" + role + '\'' +
                ", isDefault=" + isDefault +
                ", userCode='" + userCode + '\'' +
                ", userId=" + userId +
                ", isOn='" + isOn + '\'' +
                ", isCheck='" + isCheck + '\'' +
                ", isSelect='" + isSelect + '\'' +
                ", productType='" + productType + '\'' +
                '}';
    }
}
