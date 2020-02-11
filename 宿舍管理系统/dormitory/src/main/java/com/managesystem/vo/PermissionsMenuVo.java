package com.managesystem.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionsMenuVo {
    private String value;

    private String title;

    private List<PermissionsChildrenMenuVo> data;

    private Boolean checked;

    private Boolean disabled;
}
