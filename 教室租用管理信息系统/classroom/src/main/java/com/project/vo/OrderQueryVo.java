package com.project.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderQueryVo {
    private String orderCode;
    private String orderState;
    private String orderExamineState;
    private String appointmentStartTime;
    private String appointmentEndTime;
    private String orderPurpose;
    private String orderSelection;
    private String roomBuilding;
    private String studentCollege;
    private String studentClass;
    private String studentName;
    private String startTime;
    private String endTime;
    private String userRole;
    private String userCode;
    private String studentCode;


}
