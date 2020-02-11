package com.project.dao;

import com.project.pojo.Comment;
import com.project.vo.CommentQueryVo;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer educationCommentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer educationCommentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> getCommentList(CommentQueryVo commentQueryVo);
}