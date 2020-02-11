package com.project.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * CheckQueryVo
 *
 * @author {zhulimin}
 * @date 2020/1/14 0014 下午 14:44
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CheckQueryVo {


    private String checkCode;

    private String checkState;

    private String roomCode;

    private String roomIsDamageWindow;

    private String roomIsDamageChair;

    private String roomIsNeedChalk;

    private String roomIsDamagePlatform;

    private String roomIsDamageBlackboard;

    private String roomIsDamageMedia;

    private String roomIsDamageMicrophone;

    private String roomIsDamageDoor;

    private String roomIsDamageSound;

    private String roomIsDamageCurtains;

    private String startTime;
    private String endTime;
}
