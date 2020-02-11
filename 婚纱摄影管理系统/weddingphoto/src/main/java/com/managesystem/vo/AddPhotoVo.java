package com.managesystem.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddPhotoVo {

    private String photoTitle;
    private String headimg;
    private String photoDetail;
    private String photoRemarks;
    private String picture;
    private String photoState;
}
