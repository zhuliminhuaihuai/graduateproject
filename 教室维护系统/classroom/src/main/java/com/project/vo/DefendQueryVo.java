package com.project.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * DefendQueryVo
 *
 * @author {zhulimin}
 * @date 2020/1/16 0016 上午 10:48
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DefendQueryVo {

    private String defendCode;
    private String defendState;
    private String checkCode;
    private String roomCode;
    private String defendObject;
    private String startTime;
    private String endTime;
}
