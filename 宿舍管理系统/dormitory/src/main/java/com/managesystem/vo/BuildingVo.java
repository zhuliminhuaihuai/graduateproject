package com.managesystem.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuildingVo {
    private String buildingCode;
    private String buildingName;
    private String endTime;
    private String startTime;
    private String buildingTitle;
}
