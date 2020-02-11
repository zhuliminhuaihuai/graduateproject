package com.project.dao;

import com.project.pojo.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {
    int deleteByPrimaryKey(Integer educationVideoId);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer educationVideoId);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    List<Video> getVideoList(@Param("coursesCode") String coursesCode, @Param("educationVideoName") String educationVideoName);
}