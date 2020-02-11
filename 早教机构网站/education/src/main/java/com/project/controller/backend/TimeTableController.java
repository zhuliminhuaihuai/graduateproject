package com.project.controller.backend;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.service.ITimeTableService;
import com.project.vo.TimeTableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/manage/timetable")
public class TimeTableController {


    @Autowired
    private ITimeTableService iTimeTableService;

    //在线选课确认上课
    @RequestMapping("addTimeTable")
    @ResponseBody
    public ServerResponse addTimeTable(HttpServletRequest request, Integer coursesId) {

        return iTimeTableService.addTimeTable(request, coursesId);
    }

    //找到所有的课表(开课列表)
    @RequestMapping("getTimeTableAllList")
    @ResponseBody
    public LayUiPageResponse getTimeTableAllList(Integer page, Integer limit, TimeTableVo timeTableVo, Integer userRole, String userCode) {
        return iTimeTableService.getTimeTableAllList(page, limit, timeTableVo, userRole, userCode);
    }
    //找到所有的课表(选课列表)
    @RequestMapping("getTimeTableAllListForStudent")
    @ResponseBody
    public LayUiPageResponse getTimeTableAllListForStudent(Integer page, Integer limit, TimeTableVo timeTableVo, Integer userRole, String userCode) {
        return iTimeTableService.getTimeTableAllListForStudent(page, limit, timeTableVo, userRole, userCode);
    }

    //更换教师
    @RequestMapping("changeTercher")
    @ResponseBody
    public ServerResponse changeTercher(Integer timetableId, String userCode,String coursesCode) {
        return iTimeTableService.changeTercher(timetableId, userCode,coursesCode);
    }

    //删除课表
    @RequestMapping("deleteTimeTable")
    @ResponseBody
    public ServerResponse deleteTimeTable(Integer timetableId) {
        return iTimeTableService.deleteTimeTable(timetableId);
    }
    /**********************************/
    //开课列表界面
    @RequestMapping("jumpTimeTableList.html")
    public String jumpTimeTableListHtml() {
        return "timetable/time_table_list";
    }

    //选课列表界面
    @RequestMapping("jumpTimeTableSelectList.html")
    public String jumpTimeTableSelectListHtml() {
        return "timetable/time_table_select_list";
    }

    //教师列表的开课详情
    @RequestMapping("jumpTimeTableListDetail.html")
    public String jumpTimeTableListDetailHtml() {
        return "timetable/time_table_list_detail";
    }

    //学生列表的选课详情
    @RequestMapping("jumpTimeTableSelectListDetail.html")
    public String jumpTimeTableSelectListDetailHtml() {
        return "timetable/time_table_select_list_detail";
    }

    //打开更换老师界面
    @RequestMapping("openChangeTercher.html")
    public String openChangeTercherHtml() {
        return "timetable/change_tercher";
    }
}


