package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.vo.CommentQueryVo;

import javax.servlet.http.HttpServletRequest;

/**
 * ICommentService
 *
 * @author {zhulimin}
 * @date 2020/2/6 0006 上午 1:43
 */
public interface ICommentService {

    ServerResponse addComment(HttpServletRequest request, Integer timetableId, String educationCommentText);

    LayUiPageResponse getCommentList(CommentQueryVo commentQueryVo, Integer page, Integer limit, Integer userRole, String userCode);

    ServerResponse deleteComment(Integer educationCommentId);


}
