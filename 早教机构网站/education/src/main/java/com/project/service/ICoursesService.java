package com.project.service;


import com.project.common.LayUiPageResponse;
import com.project.common.LayUiResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Courses;
import com.project.vo.CoursesQueryVo;

public interface ICoursesService {

    //所开设的所有课程学生看得见的
    LayUiResponse getCoursesListAndSee(int pageSize, int currentPage);

    //添加新课程
    ServerResponse addCourses(Courses courses);

    //课程列表
    LayUiPageResponse getCoursesList(Integer page, Integer limit, CoursesQueryVo coursesQueryVo);

    //根据课程名查找现有的课程
    ServerResponse getCoursesListBycoursesTitle(String coursesTitle);

    //修改课程状态
    ServerResponse updateCoursesState(Courses courses);

    //课程详情
    ServerResponse detailCourses(Integer coursesId);

    //保存课程
    ServerResponse saveCourses(Courses courses);

    //删除课程
    ServerResponse deleteCourses(Integer coursesId);

}
