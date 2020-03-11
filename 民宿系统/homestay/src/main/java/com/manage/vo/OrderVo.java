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

    private String checkInState;
    private String orderState;
    private String tenantName;
    private String customerName;
    private String tenantId;
    private String customerId;
    private String roomCode;

    private String customerCode;
    private String tenantCode;

}
