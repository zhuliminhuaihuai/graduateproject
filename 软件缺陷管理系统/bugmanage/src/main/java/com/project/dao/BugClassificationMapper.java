package com.project.dao;

import com.project.pojo.Bug;
import com.project.pojo.BugClassification;
import com.project.vo.CommonVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BugClassificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BugClassification record);

    int insertSelective(BugClassification record);

    BugClassification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BugClassification record);

    int updateByPrimaryKey(BugClassification record);

    //List分页BugClassification列表
    List<BugClassification> bugClassList(CommonVo commonVo);
    
    //请求分类列表 渲染下拉框
    List<BugClassification> selectBugClass();

    //验证分类名不重复
    int checkBugName(@Param("bugName") String bugName );

}