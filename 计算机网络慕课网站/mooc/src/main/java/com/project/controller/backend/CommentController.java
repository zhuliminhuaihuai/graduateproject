package com.project.controller.backend;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.service.ICommentService;
import com.project.vo.CommentQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * CommentController
 *
 * @author {zhulimin}
 * @date 2020/2/6 0006 上午 1:42
 */
@Controller
@RequestMapping("/manage/comment/")
public class CommentController {

    @Autowired
    private ICommentService iCommentService;



    //添加评论
    @RequestMapping("addComment")
    @ResponseBody
    public ServerResponse addComment(HttpServletRequest request,Integer timetableId, String educationCommentText) {
        return iCommentService.addComment(request,timetableId, educationCommentText);
    }

    //评论列表
    @RequestMapping("getCommentList")
    @ResponseBody
    public LayUiPageResponse getCommentList(CommentQueryVo commentQueryVo, Integer page, Integer limit, Integer userRole, String userCode) {
        return iCommentService.getCommentList(commentQueryVo, page, limit, userRole, userCode);
    }

    //删除评论
    @RequestMapping("deleteComment")
    @ResponseBody
    public ServerResponse deleteComment(Integer educationCommentId) {
        return iCommentService.deleteComment(educationCommentId);
    }
    /************************************跳转页面*/
    @RequestMapping("openAddComment.html")
    public String openAddCommentHtml() {
        return "comment/comment_add";
    }

    @RequestMapping("jumpCommentList.html")
    public String jumpCommentListHtml() {
        return "comment/comment_list";
    }

}
