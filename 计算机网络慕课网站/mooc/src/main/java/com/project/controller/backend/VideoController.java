package com.project.controller.backend;

import com.project.common.ServerResponse;
import com.project.pojo.Video;
import com.project.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * VideoController
 *
 * @author {zhulimin}
 * @date 2020/2/9 0009 下午 15:20
 */
@Controller
@RequestMapping("/manage/video/")
public class VideoController {

    @Autowired
    private IVideoService iVideoService;

    //添加章节视频
    @RequestMapping("add")
    @ResponseBody
    public ServerResponse addVideo(HttpServletRequest request, Integer coursesId, Video video) {
        return iVideoService.addVideo(request, coursesId, video);
    }

    //视频全部
    @RequestMapping("videoList")
    @ResponseBody
    public ServerResponse videoList(Integer coursesId, String educationVideoName) {
        return iVideoService.videoList(coursesId, educationVideoName);
    }

    //学生视频全部
    @RequestMapping("videoStudentList")
    @ResponseBody
    public ServerResponse videoStudentList(Integer timetableId, String educationVideoName) {
        return iVideoService.videoStudentList(timetableId, educationVideoName);
    }

    //删除视频
    @RequestMapping("delete")
    public String videoDelete(Integer educationVideoId) {
        iVideoService.videoDelete(educationVideoId);
        return "video/video_list";
    }
    /*************打开上传视频界面****/
    @RequestMapping("openVideoAdd.html")
    public String openVideoAddHtml() {
        return "video/video_add";
    }

    @RequestMapping("openVideoList.html")
    public String openVideoListHtml() {
        return "video/video_list";
    }

    @RequestMapping("openVideoStudentList.html")
    public String openVideoStudentListHtml() {
        return "video/video_student_list";
    }
}
