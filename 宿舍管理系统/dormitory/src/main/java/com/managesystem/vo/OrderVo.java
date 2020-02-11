package com.managesystem.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo {
    private String orderCode;
    private String userCode;
    private String userName;
    private String endTime;
    private String startTime;
    private String orderState;
}
