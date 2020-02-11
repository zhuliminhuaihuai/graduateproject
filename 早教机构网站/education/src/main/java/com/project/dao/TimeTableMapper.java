package com.project.dao;

import com.project.pojo.TimeTable;
import com.project.vo.TimeTableVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TimeTableMapper {
    int deleteByPrimaryKey(Integer timetableId);

    int insert(TimeTable record);

    int insertSelective(TimeTable record);

    TimeTable selectByPrimaryKey(Integer timetableId);

    int updateByPrimaryKeySelective(TimeTable record);

    int updateByPrimaryKey(TimeTable record);

    //根据教师code删除课表
    int deleteTimeTableByTercherCode(@Param("tercherCode") String tercherCode);

    //修改授课老师的信息根据课程code
    int updateTercherMessageByCoursesCode(@Param("tercherCode") String tercherCode, @Param("terCherName") String terCherName,
                                          @Param("coursesCode") String coursesCode);

    //删除课表根据课程code
    int deleteTimeTableByCoursesCode(@Param("coursesCode") String coursesCode);

    //找到所有的课表
    List<TimeTable> getTimeTableAllList(TimeTableVo timeTableVo);

    //根据学生code找到此学生的全部课表
    List<TimeTable> getStudentUnderTimeTable(@Param("studentCode") String studentCode);

}