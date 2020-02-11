package com.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userCode;

    private Integer userRole;

    private String userIdCard;

    private String userPhone;

    private String roomCode;

    private Integer roomState;

    private Date userCreateTime;

    private Date userUpdateTime;

    private String roomTitle;

    private String romImg;

    private String roomAddress;

}
