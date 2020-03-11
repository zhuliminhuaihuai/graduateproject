package com.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContentVo {

    private String img;
    private String title;
    private Integer pri;
    private Integer nub;
    private Integer delpri;
    private Integer roomId;
    private String roomTitle;

    private Integer roomBedNumber;

    private Integer roomBathNumber;

    private Integer roomWcNumber;

    private Integer roomNumber;

    private Integer roomMaxCustomerNumber;
}
