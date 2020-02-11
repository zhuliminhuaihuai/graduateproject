package com.project.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * CommentQueryVo
 *
 * @author {zhulimin}
 * @date 2020/2/6 0006 上午 2:56
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentQueryVo {


    private String educationCommentCode;

    private String coursesCode;

    private String coursesTitle;

    private String studenrCode;

    private String studentName;

    private String tercherCode;

    private String tercherName;

    private String educationCommentText;

    private String startTime;
    private String endTime;
}
