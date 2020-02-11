package com.project.controller.backend;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.service.IDefendService;
import com.project.vo.DefendQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DefendController
 *
 * @author {zhulimin}
 * @date 2020/1/15 0015 上午 11:49
 */
@RequestMapping("/manage/defend/")
@Controller
public class DefendController {

    @Autowired
    private IDefendService iDefendService;

    /**
     * 维护单列表
     *
     * @param defendQueryVo
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("getDefendList")
    @ResponseBody
    public LayUiPageResponse getDefendList(DefendQueryVo defendQueryVo, Integer page, Integer limit) {
        return iDefendService.getDefendList(defendQueryVo, page, limit);
    }

    /**
     * 维护完毕
     *
     * @param defendId
     * @return
     */
    @RequestMapping("defendOver")
    @ResponseBody
    public ServerResponse defendOver(Integer defendId) {
        return iDefendService.defendOver(defendId);
    }

    /**********************/

    /**
     * 跳转维护单页面
     * @return
     */
    @RequestMapping("jumpDefendListHtml.html")
    public String jumpDefendListHtml() {
        return "defend/defend_list";
    }

}
