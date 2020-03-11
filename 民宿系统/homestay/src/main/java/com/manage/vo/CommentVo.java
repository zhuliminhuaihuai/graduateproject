package com.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CommentVo
 *
 * @author {zhulimin}
 * @date 2020/3/4 0004 下午 17:10
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentVo {

    private String commentName;
    private String roomCode;
    private String tenantName;
    private String commentRemark;

    private String commentCode;
    private String tenantCode;


}
