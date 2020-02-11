package com.managesystem.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MenuVo {

    private String title;
    private String icon;
    private String href;
    private Boolean spread;
    private List<MenuVo> children;
}
