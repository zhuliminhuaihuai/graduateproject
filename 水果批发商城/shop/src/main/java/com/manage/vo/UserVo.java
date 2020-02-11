package com.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private String userCode;
    private String userName;
    private String userRole;
    private String userPhone;
    private String endTime;
    private String startTime;
}
