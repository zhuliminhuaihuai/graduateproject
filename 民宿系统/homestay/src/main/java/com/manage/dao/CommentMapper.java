package com.manage.dao;

import com.manage.pojo.Comment;
import com.manage.vo.CommentVo;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> getCommentList(CommentVo commentVo);
}