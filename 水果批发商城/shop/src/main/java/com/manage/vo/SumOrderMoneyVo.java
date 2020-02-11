package com.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SumOrderMoneyVo {

    private Double transactionMoney;

    private Date orderdateTime;

    private Integer countOrder;

    private String xaxisName;
}
