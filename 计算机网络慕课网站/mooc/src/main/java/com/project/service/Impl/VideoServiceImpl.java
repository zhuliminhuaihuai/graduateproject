package com.project.service.Impl;

import com.project.common.Const;
import com.project.common.ServerResponse;
import com.project.dao.CoursesMapper;
import com.project.dao.TimeTableMapper;
import com.project.dao.VideoMapper;
import com.project.pojo.Courses;
import com.project.pojo.TimeTable;
import com.project.pojo.User;
import com.project.pojo.Video;
import com.project.service.IVideoService;
import com.project.util.PublicUtil;
import com.project.vo.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * VideoServiceImpl
 *
 * @author {zhulimin}
 * @date 2020/2/9 0009 下午 15:20
 */
@Service
public class VideoServiceImpl implements IVideoService {

    @Autowired
    private CoursesMapper coursesMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private TimeTableMapper timeTableMapper;

    @Override
    public ServerResponse addVideo(HttpServletRequest request, Integer coursesId, Video video) {

        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        Courses courses = coursesMapper.selectByPrimaryKey(coursesId);
        video.setEducationVideoCode(PublicUtil.setCode("V"));
        video.setEducationVideoCreateTime(new Date());
        video.setCoursesCode(courses.getCoursesCode());
        video.setCoursesName(courses.getCoursesTitle());
        video.setUploadCode(user.getUserCode());
        video.setUploadName(user.getUserRealName());
        video.setTercherCode(courses.getUserCode());
        video.setTercherName(courses.getUserRelName());
        int count = videoMapper.insertSelective(video);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("上传成功!");
        } else {
            return ServerResponse.createByErrorMessage("上传失败!");
        }
    }

    @Override
    public ServerResponse videoList(Integer coursesId, String educationVideoName) {
        Courses courses = coursesMapper.selectByPrimaryKey(coursesId);
        List<Video> videoList = videoMapper.getVideoList(courses.getCoursesCode(), educationVideoName);
        if (videoList.size() > 0) {
            String path = "http://127.0.0.1:8080/upload/";
            for (Video v : videoList
            ) {
                v.setEducationVideoPath(path + v.getEducationVideoPath());
            }
            VideoVo videoVo = new VideoVo();
            videoVo.setContent(videoList);
            videoVo.setCount(videoList.size());
            return ServerResponse.createBySuccess("找到视频", videoVo);
        } else {
            return ServerResponse.createByErrorMessage("暂无视频");
        }

    }

    @Override
    public ServerResponse videoStudentList(Integer timetableId, String educationVideoName) {
        TimeTable timeTable = timeTableMapper.selectByPrimaryKey(timetableId);
        List<Video> videoList = videoMapper.getVideoList(timeTable.getCoursesCode(), educationVideoName);
        if (videoList.size() > 0) {
            String path = "http://127.0.0.1:8080/upload/";
            for (Video v : videoList
            ) {
                v.setEducationVideoPath(path + v.getEducationVideoPath());
            }
            VideoVo videoVo = new VideoVo();
            videoVo.setContent(videoList);
            videoVo.setCount(videoList.size());
            return ServerResponse.createBySuccess("找到视频", videoVo);
        } else {
            return ServerResponse.createByErrorMessage("暂无视频");
        }
    }

    @Override
    public void videoDelete(Integer educationVideoId) {
        videoMapper.deleteByPrimaryKey(educationVideoId);
//        int count = videoMapper.deleteByPrimaryKey(educationVideoId);
//        if (count > 0) {
//            return ServerResponse.createBySuccessMessage("删除成功!");
//        } else {
//            return ServerResponse.createByErrorMessage("删除失败!");
//        }
    }
}
