package com.project.dao;

import com.project.pojo.Branch;
import com.project.pojo.Product;
import com.project.vo.CommonVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

    //List分页列表
    List<Product> productList(CommonVo commonVo);

    //检测机构名
    int checkProductName(@Param("productName") String productName);

    //修改-检测机构名
    int checkProductNameExSelf(@Param("productName") String productName,@Param("id") Integer id);

    //List分页列表-请求推荐
    List<Product> productBuSelected();

    //List分页列表-请求更多作品
    List<Product> products();


}