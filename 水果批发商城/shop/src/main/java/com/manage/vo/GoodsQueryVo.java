package com.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GoodsQueryVo {

    private String goodsCode;
    private String goodsTitle;
    private String goodsState;
    private String goodsBigType;
    private String goodsType;
}
