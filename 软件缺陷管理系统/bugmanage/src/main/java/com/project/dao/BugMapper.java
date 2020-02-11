package com.project.dao;

import com.project.pojo.Bug;
import com.project.pojo.User;
import com.project.vo.BugVo;
import com.project.vo.CommonVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BugMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bug record);

    int insertSelective(Bug record);

    Bug selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bug record);

    int updateByPrimaryKey(Bug record);

    //List分页bug列表
    List<BugVo> bugList(CommonVo commonVo);

    BugVo selectById(@Param("id") int id);
}