package com.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class infoListVo {
    private String img;
    private String title;
    private Double price;
    private Integer goodsBigType;
    private String goodsBigTypeString;
    private Integer goodsSmallType;
    private String goodsSmallTypeString;
    private Integer goodsBuyNum;
    private Double goodsOneSumPrice;
    private Integer cartId;



}

