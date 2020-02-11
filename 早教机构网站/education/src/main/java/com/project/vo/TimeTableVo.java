package com.project.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TimeTableVo {

    private String timetableCode;
    private String studentCode;
    private String studentName;
    private String coursesCode;
    private String startTime;
    private String endTime;
    private String coursesTitle;
    private String tercherCode;
    private String tercherName;
}
