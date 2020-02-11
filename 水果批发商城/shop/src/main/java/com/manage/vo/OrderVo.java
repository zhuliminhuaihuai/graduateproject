package com.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo {

    private String orderCode;
    private String userPhone;
    private String userCode;
    private String userName;
    private String endTime;
    private String startTime;
    private String payType;

}
