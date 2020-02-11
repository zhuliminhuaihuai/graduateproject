package com.project.service;

import com.project.common.LayUiPageResponse;
import com.project.common.LayUiResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Branch;
import com.project.pojo.Product;
import com.project.vo.CommonVo;

import java.util.List;

public interface IProductService {



    //分页列表
    LayUiPageResponse<List<Product>> productList(CommonVo commonVo, int page, int limit);
    //增
    ServerResponse insert(Product product);
    //删
    ServerResponse delete(Integer id);
    //改
    ServerResponse edit(Product product);
    //查 -根据ID
    ServerResponse get(Integer id);

    //修改状态 上下架/是否精品
    ServerResponse editProductStatus(Integer id,Integer isOn,Integer type);

    //首页推荐
    LayUiResponse productBuSelected(int pageSize, int currentPage);

    //更多作品
    LayUiResponse products(int pageSize, int currentPage);

    //查机构信息 -根据作者Id
    ServerResponse getBranchByPId(Integer userId);
}
