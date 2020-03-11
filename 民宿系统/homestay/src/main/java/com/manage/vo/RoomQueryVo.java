package com.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * RoomQueryVo
 *
 * @author {zhulimin}
 * @date 2020/2/28 0028 下午 18:04
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomQueryVo {

    private String roomSimpleRemark ;
    private String roomTitle ;
    private String tenantName ;
    private String roomBedNumber ;
    private String roomMaxCustomerNumber ;
    private String roomIsDaylyUse ;
    private String roomIsWifi ;
    private String roomIsParking;
    private  String roomState ;
    private String tenantCode;
}
