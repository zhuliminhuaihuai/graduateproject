package com.managesystem.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DetailPhotoVo {
    private Integer photo_id;

    private String photo_code;

    private String photo_img;

    private Date photo_create_time;

    private Date photo_update_time;

    private String photo_parent_code;

    private Integer photo_state;

    private String photo_title;

    private String photo_name;

    private String photo_detail;

    private String photo_remarks;

    private Date motherPhotoCreateTime;
}
