package com.project.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryVo {
    private String userCode;
    private String userName;
    private String userRealName;
    private String userPhone;
    private String startTime;
    private String endTime;
    private String userSex;
    private String userRole;
}
