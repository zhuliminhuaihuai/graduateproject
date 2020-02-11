package com.project.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CleanQueryVo
 *
 * @author {zhulimin}
 * @date 2020/1/21 0021 下午 15:30
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CleanQueryVo {

    private String cleanCode;
    private Integer cleanState;
    private String roomCode;
    private String startTime;
    private String endTime;
}
