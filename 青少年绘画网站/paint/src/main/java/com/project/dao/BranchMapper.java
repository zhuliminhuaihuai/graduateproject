package com.project.dao;

import com.project.pojo.Branch;
import com.project.pojo.User;
import com.project.vo.CommonVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BranchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Branch record);

    int insertSelective(Branch record);

    Branch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Branch record);

    int updateByPrimaryKeyWithBLOBs(Branch record);

    int updateByPrimaryKey(Branch record);

    //List分页角色列表
    List<Branch> branchList(CommonVo commonVo);

    //检测机构名
    int checkBranchName(@Param("branchName") String branchName);

    //修改-检测机构名
    int checkbranchNameExSelf(@Param("branchName") String branchName,@Param("id") Integer id);

    //根据用户编号 查询机构Id
    Branch selectIdByCode(@Param("userCode") String userCode);

}