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
    private String userName;
    private String headimg;
    private String userRole;
    private String userFindPassword;
    private String userPhone;
}
