package com.project.dao;

import com.project.pojo.EmployInfo;
import com.project.pojo.Enterprise;
import com.project.vo.CommonVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnterpriseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    Enterprise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKeyWithBLOBs(Enterprise record);

    int updateByPrimaryKey(Enterprise record);

    //企业业信息列表
    List<Enterprise> enterpriseList(CommonVo commonVo);

    //验证企业名称是否存在
    int chekcEName(@Param("enterpriseName") String enterpriseName);
    //根据用户
    List<Enterprise> enterpriseByUserCode(@Param("userCode") String userCode);

    //查询自己注册通过的企业
    Enterprise enterpriseInfoByUserCode(@Param("userCode") String userCode);

    int checkEnter(@Param("userCode") String userCode);

}