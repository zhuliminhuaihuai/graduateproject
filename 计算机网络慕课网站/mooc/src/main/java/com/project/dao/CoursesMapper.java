package com.project.dao;

import com.project.pojo.Courses;
import com.project.vo.CoursesQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoursesMapper {
    int deleteByPrimaryKey(Integer coursesId);

    int insert(Courses record);

    int insertSelective(Courses record);

    Courses selectByPrimaryKey(Integer coursesId);

    int updateByPrimaryKeySelective(Courses record);

    int updateByPrimaryKey(Courses record);

    //所开设的所有课程(学生看得见的)
    List<Courses> getCoursesListAndSee();

    //老师被删除后  所开设的课程也得都删了
    int deleteCoursesByUserCode(@Param("userCode") String userCode);

    //课程列表
    List<Courses> getAllCoursesList(CoursesQueryVo coursesQueryVo);

    int checkCoursesIsExit(@Param("coursesTitle") String coursesTitle, @Param("userCode") String userCode);

    //根据课程名查找现有的课程
    List<Courses> getCoursesListBycoursesTitle(@Param("coursesTitle") String coursesTitle);

    Courses getCoursesByCode(@Param("coursesCode") String coursesCode);

    /*//根据userCode找到课程
    Courses getCoursesByUserCode(@Param("userCode") String userCode);*/


}