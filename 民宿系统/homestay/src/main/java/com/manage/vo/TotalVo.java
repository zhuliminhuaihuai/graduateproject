package com.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TotalVo {
    private Integer orderCountTotal;
    private Integer userTotal;
    private Double orderMoneyTotal;
    private Double profitTotal;
}
