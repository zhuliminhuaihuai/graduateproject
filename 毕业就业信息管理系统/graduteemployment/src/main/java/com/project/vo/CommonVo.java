package com.project.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
public class CommonVo {

    String userName;//用户名或查询通用字段
    String endTime;//结束时间
    String startTime;//开始时间
    String role;//角色
    Integer isDefault;//是否默认
    String userCode;//用户编号
    Integer hireStatus;//雇佣状态
    Integer isOn;//是否开启
    String jobSalary;//薪水
    String enterpriseCode;//企业编号

}
