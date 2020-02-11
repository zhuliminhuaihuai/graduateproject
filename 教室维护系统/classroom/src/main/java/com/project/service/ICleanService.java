package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Clean;
import com.project.vo.CleanQueryVo;

/**
 * ICleanService
 *
 * @author {zhulimin}
 * @date 2020/1/21 0021 上午 11:29
 */
public interface ICleanService {

    /**
     * 创建打扫单
     *
     * @param roomId
     * @return
     */
    ServerResponse addClean(Integer roomId);

    /**
     * 打扫列表
     *
     * @param cleanQueryVo
     * @param page
     * @param limit
     * @return
     */
    LayUiPageResponse cleanList(CleanQueryVo cleanQueryVo, Integer page, Integer limit);

    /**
     * @param cleanId
     * @return
     */
    ServerResponse cleanOver(Integer cleanId);

    ServerResponse cleanDetail(Integer cleanId);
}
