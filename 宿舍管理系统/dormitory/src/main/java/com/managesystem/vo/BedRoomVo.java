package com.managesystem.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BedRoomVo {
    private String buildingCode;
    private String floorNumber;
    private String bedRoomNumber;
    private String userNumber;
}
