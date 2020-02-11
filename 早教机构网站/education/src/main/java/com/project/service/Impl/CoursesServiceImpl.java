package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.LayUiPageResponse;
import com.project.common.LayUiResponse;
import com.project.common.ServerResponse;
import com.project.dao.CoursesMapper;
import com.project.dao.TimeTableMapper;
import com.project.dao.UserMapper;
import com.project.pojo.Courses;
import com.project.pojo.User;
import com.project.service.ICoursesService;
import com.project.util.PublicUtil;
import com.project.vo.CoursesQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CoursesServiceImpl implements ICoursesService {

    @Autowired
    private CoursesMapper coursesMapper;

    @Autowired
    private TimeTableMapper timeTableMapper;

    @Autowired
    private UserMapper userMapper;
    //所开设的所有课程(学生看得见的)
    public LayUiResponse getCoursesListAndSee(int pageSize, int currentPage) {
        PageHelper.startPage(currentPage, pageSize);
        List<Courses> coursesList = coursesMapper.getCoursesListAndSee();
        if (coursesList.size() > 0) {
            PageInfo pageInfo = new PageInfo(coursesList);
            return LayUiResponse.createBySuccess(coursesList, (int)pageInfo.getTotal());
        } else {
            return LayUiResponse.createByErrorMessage("暂无课程");
        }
    }
    //添加新课程
    public ServerResponse addCourses(Courses courses) {

        courses.setCoursesCode(PublicUtil.setCode("C"));
        courses.setCoursesCreateTime(new Date());
        User user = userMapper.findUserByUserCode(courses.getUserCode());
        courses.setUserRelName(user.getUserRealName() + "老师");
        //检测该老师是否已经开设过此课程
        int checkCount = coursesMapper.checkCoursesIsExit(courses.getCoursesTitle(), courses.getUserCode());
        if (checkCount > 0) {
            return ServerResponse.createByErrorMessage("该课程已存在!");
        } else {
            int count = coursesMapper.insertSelective(courses);
            if (count > 0) {
                return ServerResponse.createBySuccessMessage("添加成功");
            } else {
                return ServerResponse.createByErrorMessage("添加失败");
            }
        }
    }
    //课程列表
    public LayUiPageResponse getCoursesList(Integer page, Integer limit, CoursesQueryVo coursesQueryVo) {

        PageHelper.startPage(page, limit);
        List<Courses> coursesList = coursesMapper.getAllCoursesList(coursesQueryVo);
        String photoPath = "http://127.0.0.1:8080/upload/";
        if (coursesList.size() > 0) {
            for (int i = 0; i < coursesList.size(); i++) {
                coursesList.get(i).setCoursesImg(photoPath + coursesList.get(i).getCoursesImg());
            }
            PageInfo pageInfo = new PageInfo(coursesList);
            return LayUiPageResponse.createBySuccess(coursesList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无课程！");
        }
    }
    //根据课程名查找现有的课程
    public ServerResponse getCoursesListBycoursesTitle(String coursesTitle) {

        List<Courses> coursesList = coursesMapper.getCoursesListBycoursesTitle(coursesTitle);
        if (coursesList.size() > 0) {
            return ServerResponse.createBySuccess("找到课程", coursesList);
        } else {
            return ServerResponse.createByErrorMessage("未找到课程");
        }

    }
    //修改课程状态
    public ServerResponse updateCoursesState(Courses courses) {

        int count = coursesMapper.updateByPrimaryKeySelective(courses);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        } else {
            return ServerResponse.createByErrorMessage("修改失败");
        }
    }
    //课程详情
    public ServerResponse detailCourses(Integer coursesId) {

        Courses courses = coursesMapper.selectByPrimaryKey(coursesId);
        if (courses != null) {
            return ServerResponse.createBySuccess("找到课程", courses);
        } else {
            return ServerResponse.createByErrorMessage("未找到课程");
        }
    }
    //保存课程
    public ServerResponse saveCourses(Courses courses) {

        String userCode = courses.getUserCode();
        User user = userMapper.findUserByUserCode(userCode);
        courses.setUserRelName(user.getUserRealName()+"老师");
        int count = coursesMapper.updateByPrimaryKeySelective(courses);
        if (count > 0) {

            //修改课表表里头的教师名字和code
            Courses courses1 = coursesMapper.selectByPrimaryKey(courses.getCoursesId());
            String coursesCode = courses1.getCoursesCode();
            String tercherName = courses1.getUserRelName();
            String tercherCode = courses1.getUserCode();
            timeTableMapper.updateTercherMessageByCoursesCode(tercherCode, tercherName, coursesCode);
            return ServerResponse.createBySuccessMessage("保存成功");
        } else {
            return ServerResponse.createByErrorMessage("保存失败");
        }
    }
    //删除课程
    public ServerResponse deleteCourses(Integer coursesId) {

        Courses courses = coursesMapper.selectByPrimaryKey(coursesId);
         int count = coursesMapper.deleteByPrimaryKey(coursesId);
        if (count > 0) {

            String cousesCode = courses.getCoursesCode();
            //删除课表
            timeTableMapper.deleteTimeTableByCoursesCode(cousesCode);
            return ServerResponse.createBySuccessMessage("删除成功");

        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }

}

