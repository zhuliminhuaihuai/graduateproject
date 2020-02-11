package com.managesystem.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentVo {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userCode;

    private Integer userRole;

    private String userFindPassword;

    private String userPhone;

    private Date userBirthday;

    private String headimg;

    private String province;

    private String city;

    private String district;

    private String userFaculty;

    private Integer userState;

    private String bedroomCode;

    private Date userCreateTime;

    private Date userUpdateTime;

    private String buildingName;

    private String bedroomTitle;


}
