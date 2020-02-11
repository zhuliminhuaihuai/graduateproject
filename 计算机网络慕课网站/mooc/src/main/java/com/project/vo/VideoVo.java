package com.project.vo;

import com.project.pojo.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * VideoVo
 *
 * @author {zhulimin}
 * @date 2020/2/10 0010 上午 1:01
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VideoVo {
    private List<Video> content;
    private Integer count;
}
