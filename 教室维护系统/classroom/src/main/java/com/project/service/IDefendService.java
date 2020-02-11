package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.vo.DefendQueryVo;

/**
 * IDefendService
 *
 * @author {zhulimin}
 * @date 2020/1/15 0015 上午 11:50
 */
public interface IDefendService {

    /**
     * 维护单列表
     *
     * @param defendQueryVo
     * @param page
     * @param limit
     * @return
     */
    LayUiPageResponse getDefendList(DefendQueryVo defendQueryVo, Integer page, Integer limit);

    /**
     * 维护完毕
     * @param defendId
     * @return
     */
    ServerResponse defendOver(Integer defendId);

}
