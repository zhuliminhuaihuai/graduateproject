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
    private Double pri;
    private Integer nub;
    private Double delpri;
    private Integer goodsId;
}
