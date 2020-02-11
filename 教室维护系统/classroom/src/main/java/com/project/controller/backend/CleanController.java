package com.project.controller.backend;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Clean;
import com.project.service.ICleanService;
import com.project.vo.CleanQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * CleanController
 *
 * @author {zhulimin}
 * @date 2020/1/21 0021 上午 11:27
 */
@RequestMapping("/manage/clean/")
@Controller
public class CleanController {

    @Autowired
    private ICleanService iCleanService;

    /**
     * 创建打扫单
     *
     * @param roomId
     * @return
     */
    @RequestMapping("addClean")
    @ResponseBody
    public ServerResponse addClean(Integer roomId) {
        return iCleanService.addClean(roomId);
    }

    /**
     * 打扫列表
     * @param cleanQueryVo
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("cleanList")
    @ResponseBody
    public LayUiPageResponse cleanList(CleanQueryVo cleanQueryVo,Integer page, Integer limit) {
        return iCleanService.cleanList(cleanQueryVo, page, limit);
    }

    /**
     * 打扫完毕
     *
     * @param cleanId
     * @return
     */
    @RequestMapping("cleanOver")
    @ResponseBody
    public ServerResponse cleanOver(Integer cleanId) {
        return iCleanService.cleanOver(cleanId);
    }

    /**
     * 详情
     *
     * @param cleanId
     * @return
     */
    @RequestMapping("cleanDetail")
    @ResponseBody
    public ServerResponse cleanDetail(Integer cleanId) {
        return iCleanService.cleanDetail(cleanId);
    }

    /********************************/
    @RequestMapping("jumpCleanHtml.html")
    public String jumpCleanHtml() {
        return "clean/clean_list";
    }

    @RequestMapping("jumpCleanDetailHtml.html")
    public String jumpCleanDetailHtml() {
        return "clean/clean_detail";
    }
}
