package com.managesystem.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {

    private String userName;
    private String userCode;
    private String startTime;
    private String endTime;
    private String userRole;

}
