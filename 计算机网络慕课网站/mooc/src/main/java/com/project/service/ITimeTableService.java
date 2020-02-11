package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.vo.TimeTableVo;

import javax.servlet.http.HttpServletRequest;

public interface ITimeTableService {

    //在线选课确认上课
    ServerResponse addTimeTable(HttpServletRequest request, Integer coursesId);

    //找到所有的课表
    LayUiPageResponse getTimeTableAllList(Integer page, Integer limit, TimeTableVo timeTableVo, Integer userRole, String userCode);

    //找到所有的课表(选课列表)
    LayUiPageResponse getTimeTableAllListForStudent(Integer page, Integer limit, TimeTableVo timeTableVo, Integer userRole, String userCode);

    //更换教师
    ServerResponse changeTercher(Integer timetableId, String userCode, String coursesCode);

    //删除课表
    ServerResponse deleteTimeTable(Integer timetableId);


}
