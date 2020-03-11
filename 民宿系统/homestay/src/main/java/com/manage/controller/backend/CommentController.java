package com.manage.controller.backend;

import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.pojo.Comment;
import com.manage.service.ICommentService;
import com.manage.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * CommentController
 *
 * @author {zhulimin}
 * @date 2020/3/2 0002 下午 18:12
 */
@Controller
@RequestMapping("/manage/comment/")
public class CommentController {

    @Autowired
    private ICommentService iCommentService;

    @RequestMapping("save")
    @ResponseBody
    public ServerResponse saveComment(Comment comment, Integer orderId) {
        return iCommentService.saveComment(comment, orderId);
    }

    @RequestMapping("commentList")
    @ResponseBody
    public LayUiPageResponse commentList(HttpServletRequest request, CommentVo commentVo, Integer page, Integer limit) {
        return iCommentService.commentList(request, commentVo, page, limit);
    }

    @RequestMapping("deleteComment")
    @ResponseBody
    public ServerResponse deleteComment(Integer commentId) {
        return iCommentService.deleteComment(commentId);
    }
    /******************/
    //跳转评论添加界面
    @RequestMapping("openCommentAdd.html")
    public String openCommentAddHtml() {
        return "comment/comment_add";
    }

    @RequestMapping("jumpCommentList.html")
    public String jumpCommentListHtml() {
        return "comment/comment_list";
    }
}
