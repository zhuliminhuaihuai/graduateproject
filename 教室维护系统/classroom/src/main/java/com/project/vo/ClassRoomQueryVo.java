package com.project.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoomQueryVo {

    private String roomCode;
    private String roomBuilding;
    private String roomNumber;
    private String roomSections1;
    private String roomSections2;
    private String roomSections3;
    private String roomSections4;
    private String roomPeople;
    private String roomPurpose;
    private String startTime;
    private String endTime;
    private String roomCheckState;
    private String roomClearState;
    private String roomCheckNumber;
    private String roomDefendNumber;
    private String roomClearNumber;
}
