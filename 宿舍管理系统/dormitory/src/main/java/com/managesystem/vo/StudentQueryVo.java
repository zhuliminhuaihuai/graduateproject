package com.managesystem.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryVo {
    private String userCode;
    private String userName;
    private String userPhone;
    private String endTime;
    private String startTime;
    private String userState;
    private String userFaculty;
}
