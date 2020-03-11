package com.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * RoomVo
 *
 * @author {zhulimin}
 * @date 2020/3/1 0001 下午 20:44
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomVo {
    private Integer status;
    private MenuVo1 menu;
    private Integer count;
}
