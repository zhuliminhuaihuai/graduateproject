package com.project.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MenuVo {

    private String value;

    private String title;

    private List<MenuVo> data;

    private Boolean checked;

    private Boolean disabled;
 }
