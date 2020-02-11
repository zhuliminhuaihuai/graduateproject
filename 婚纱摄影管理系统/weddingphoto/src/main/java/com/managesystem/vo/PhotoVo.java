package com.managesystem.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PhotoVo {

    private String photoCode;
    private String photoTitle;
    private String photoState;
    private String startTime;
    private String endTime;
}
