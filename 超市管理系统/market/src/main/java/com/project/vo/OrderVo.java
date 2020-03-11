package com.project.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * OrderVo
 *
 * @author {zhulimin}
 * @date 2020/2/18 0018 上午 0:55
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo {

    private String orderType;

    private String orderFromType;

    private String orderGoodName;

    private String orderGoodSort;

}
