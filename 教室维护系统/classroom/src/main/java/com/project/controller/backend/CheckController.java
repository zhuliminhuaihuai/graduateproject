package com.project.controller.backend;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Check;
import com.project.service.ICheckService;
import com.project.vo.CheckQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * CheckController
 *
 * @author {zhulimin}
 * @date 2020/1/13 0013 下午 17:39
 */
@RequestMapping("/manage/check/")
@Controller
public class CheckController {

    @Autowired
    private ICheckService iCheckService;

    /**
     * @param check 检查单信息
     * @return
     */
    @RequestMapping("addCheck")
    @ResponseBody
    public ServerResponse addCheck(Check check) {
        return iCheckService.addCheck(check);
    }

    /**
     * 查询单列表
     *
     * @param checkQueryVo 查询条件
     * @param page         页码
     * @param limit        大小
     * @return
     */
    @RequestMapping("getCheckList")
    @ResponseBody
    public LayUiPageResponse getCheckList(CheckQueryVo checkQueryVo, Integer page, Integer limit) {
        return iCheckService.getCheckList(checkQueryVo, page, limit);
    }

    /**
     * 反馈前的详情
     *
     * @param checkId 检查单主键
     * @return
     */
    @RequestMapping("getCheck")
    @ResponseBody
    public ServerResponse getCheck(Integer checkId) {
        return iCheckService.getCheck(checkId);
    }

    /**
     * @param check 检查单信息
     * @return
     */
    @RequestMapping("addCheckMoreMessgage")
    @ResponseBody
    public ServerResponse addCheckMoreMessgage(Check check,@Param("defendObjectArray") String defendObjectArray) {
        System.out.println(defendObjectArray);
        return iCheckService.addCheckMoreMessage(check,defendObjectArray);
    }

    /*********************跳转页面*************************************/
    /**
     *  跳转检查单页面
     * @return
     */
    @RequestMapping("jumpCheckHtml.html")
    public String jumpCheckHtml() {
        return "check/check_list";
    }

    /**
     * 打开反馈检查单页面
     * @return
     */
    @RequestMapping("openCheckFeedBackHtml.html")
    public String openCheckFeedBackHtml() {
        return "check/check_feedback";
    }

    /**
     * 打开检查单详情
     * @return
     */
    @RequestMapping("openCheckDetailHtml.html")
    public String openCheckDeatilHtml() {
        return "check/check_detail";
    }

}
