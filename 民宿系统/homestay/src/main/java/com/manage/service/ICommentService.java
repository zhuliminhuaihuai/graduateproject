package com.manage.service;

import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.pojo.Comment;
import com.manage.vo.CommentVo;

import javax.servlet.http.HttpServletRequest;

/**
 * ICommentService
 *
 * @author {zhulimin}
 * @date 2020/3/2 0002 下午 18:13
 */
public interface ICommentService {

    ServerResponse saveComment(Comment comment, Integer orderId);

    LayUiPageResponse commentList(HttpServletRequest request, CommentVo commentVo, Integer page, Integer limit);

    ServerResponse deleteComment(Integer commentId);
}
