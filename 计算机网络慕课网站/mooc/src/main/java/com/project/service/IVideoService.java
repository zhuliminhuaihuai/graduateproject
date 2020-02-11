package com.project.service;

import com.project.common.ServerResponse;
import com.project.pojo.Video;

import javax.servlet.http.HttpServletRequest;

/**
 * IVideoService
 *
 * @author {zhulimin}
 * @date 2020/2/9 0009 下午 15:20
 */
public interface IVideoService {

    ServerResponse addVideo(HttpServletRequest request, Integer coursesId, Video video);

    ServerResponse videoList(Integer coursesId, String educationVideoName);

    ServerResponse videoStudentList(Integer timetableId, String educationVideoName);

    void videoDelete(Integer educationVideoId);
}
