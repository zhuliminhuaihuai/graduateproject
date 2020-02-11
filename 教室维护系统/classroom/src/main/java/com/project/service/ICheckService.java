package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Check;
import com.project.vo.CheckQueryVo;

/**
 * ICheckService
 *
 * @author {zhulimin}
 * @date 2020/1/13 0013 下午 17:40
 */
public interface ICheckService {


    /**
     *
     * @param check 检查单信息
     * @return
     */
    ServerResponse addCheck(Check check);

    /**
     * 查询单列表
     *
     * @param checkQueryVo 查询条件
     * @param page         页码
     * @param limit        大小
     * @return
     */
    LayUiPageResponse getCheckList(CheckQueryVo checkQueryVo, Integer page, Integer limit);

    /**
     * 详情
     * @param checkId 主键
     * @return
     */
    ServerResponse getCheck(Integer checkId);


    /**
     *
     * @param check 检查单信息
     * @return
     */
    ServerResponse addCheckMoreMessage(Check check,String defendObjectArray);
}
