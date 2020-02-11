package com.project.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OfficeMessageVo {

    private String messageCode;
    private String messageTitle;
    private String startTime;
    private String endTime;
    private String messageState;
}
