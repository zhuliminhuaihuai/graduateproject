package com.project.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.CoursesMapper;
import com.project.dao.TimeTableMapper;
import com.project.dao.UserMapper;
import com.project.pojo.Courses;
import com.project.pojo.TimeTable;
import com.project.pojo.User;
import com.project.service.ITimeTableService;
import com.project.util.PublicUtil;
import com.project.vo.TimeTableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class TimeTableServiceImpl implements ITimeTableService {


    @Autowired
    private TimeTableMapper timeTableMapper;

    @Autowired
    private CoursesMapper coursesMapper;

    @Autowired
    private UserMapper userMapper;


    //在线选课确认上课
    public ServerResponse addTimeTable(HttpServletRequest request, Integer coursesId) {

        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        TimeTable timeTable = new TimeTable();
        Courses courses = coursesMapper.selectByPrimaryKey(coursesId);
        timeTable.setTimetableCode(PublicUtil.setCode("T"));
        timeTable.setTimetableCreateTime(new Date());
        timeTable.setStudentCode(user.getUserCode());
        timeTable.setStudentName(user.getUserRealName());
        timeTable.setTercherCode(courses.getUserCode());
        timeTable.setTercherName(courses.getUserRelName());
        timeTable.setCoursesCode(courses.getCoursesCode());
        timeTable.setCoursesTitle(courses.getCoursesTitle());
        //学生已经选课的课表
        List<TimeTable> timeTableList = timeTableMapper.getStudentUnderTimeTable(user.getUserCode());
        for (int i = 0; i < timeTableList.size(); i++) {
            if (courses.getCoursesCode().equals(timeTableList.get(i).getCoursesCode())) {
                return ServerResponse.createByErrorMessage("该课程你已选过，请勿重复选课");
            }
        }

        int count = timeTableMapper.insertSelective(timeTable);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("选课成功!");
        } else {
            return ServerResponse.createByErrorMessage("选课失败!");
        }
    }
    //找到所有的课表
    public LayUiPageResponse getTimeTableAllList(Integer page, Integer limit, TimeTableVo timeTableVo,Integer userRole,String userCode) {

        if (userRole == 2) {
            timeTableVo.setTercherCode(userCode);
        }
        PageHelper.startPage(page, limit);
        List<TimeTable> timeTableList = timeTableMapper.getTimeTableAllList(timeTableVo);
        if (timeTableList.size() > 0) {
            PageInfo pageInfo = new PageInfo(timeTableList);
            return LayUiPageResponse.createBySuccess(timeTableList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无课表!");
        }
    }
    //找到所有的课表(选课列表)
    public LayUiPageResponse getTimeTableAllListForStudent(Integer page, Integer limit, TimeTableVo timeTableVo,Integer userRole,String userCode) {

        if (userRole == 1) {
            timeTableVo.setStudentCode(userCode);
        }
        PageHelper.startPage(page, limit);
        List<TimeTable> timeTableList = timeTableMapper.getTimeTableAllList(timeTableVo);
        if (timeTableList.size() > 0) {
            PageInfo pageInfo = new PageInfo(timeTableList);
            return LayUiPageResponse.createBySuccess(timeTableList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无课表!");
        }
    }
    //更换教师
    public ServerResponse changeTercher(Integer timetableId, String userCode, String coursesCode) {

        User user = userMapper.findUserByUserCode(userCode);
        TimeTable timeTable = timeTableMapper.selectByPrimaryKey(timetableId);
        timeTable.setTercherCode(userCode);
        timeTable.setTercherName(user.getUserRealName() + "老师");
        timeTable.setTimetableUpdateTime(new Date());
        timeTable.setCoursesCode(coursesCode);
        int count = timeTableMapper.updateByPrimaryKeySelective(timeTable);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更换成功!");
        } else {
            return ServerResponse.createByErrorMessage("更换失败!");
        }
    }
    //删除课表
    public ServerResponse deleteTimeTable(Integer timetableId) {

        int count = timeTableMapper.deleteByPrimaryKey(timetableId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功!");
        } else {
            return ServerResponse.createByErrorMessage("删除失败!");
        }
    }


}
