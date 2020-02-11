package com.project.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoursesQueryVo {

    private String coursesCode;
    private String coursesTitle;
    private String startTime;
    private String endTime;
    private String userRelName;
    private String coursesState;

}
