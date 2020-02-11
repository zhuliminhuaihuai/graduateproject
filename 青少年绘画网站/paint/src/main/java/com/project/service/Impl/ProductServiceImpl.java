package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.project.common.LayUiPageResponse;
import com.project.common.LayUiResponse;
import com.project.common.ServerResponse;
import com.project.dao.BranchMapper;
import com.project.dao.ProductMapper;
import com.project.dao.UserMapper;
import com.project.pojo.Branch;
import com.project.pojo.Product;
import com.project.pojo.User;
import com.project.service.IBranchService;
import com.project.service.IProductService;
import com.project.util.MD5Utils;
import com.project.util.PublicUtil;
import com.project.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BranchMapper branchMapper;


    @Override
    public LayUiPageResponse<List<Product>> productList(CommonVo commonVo, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Integer> userIds = Lists.newArrayList();
        if(commonVo.getRole().equals("2")){//培训机构要查询培训机构下所有老师的作品和所有学生的作品
            String userCode = commonVo.getUserCode();
            Branch branch = branchMapper.selectIdByCode(userCode);
            Integer branchId = branch.getId();
            userIds = userMapper.selectAllTeacherAndStudentIdsByBranchId(branchId);
            userIds.add(commonVo.getUserId());
        }
        if(commonVo.getRole().equals("3")){//教师要查询该教师自身作品以及该教师学生的作品
            Integer teacherId = commonVo.getUserId();
            userIds = userMapper.selectAllStudentIdsByTeacherId(teacherId);
            userIds.add(commonVo.getUserId());
        }
        for (Integer userId : userIds) {
            System.out.println("userId:"+userId);
        }
        commonVo.setUserIds(userIds);
        List<Product> products = productMapper.productList(commonVo);
        if(products.size()==0){
            return LayUiPageResponse.createByErrorMessage("暂无作品");
        }
        PageInfo pageInfo = new PageInfo(products);
        return LayUiPageResponse.createBySuccess(products,pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getSize());
    }

    @Override
    public ServerResponse insert(Product product) {
        String productName = product.getProductName();
        if(productMapper.checkProductName(productName)>0){
            return ServerResponse.createByErrorMessage("作品名已存在");
        }
        String productCode = PublicUtil.setCode("P");//设置编号
        product.setProductCode(productCode);//机构编号
        product.setCreateTimes(new Date());//设置创建时间为当前时间
        product.setIsCheck(0);
        product.setIsOn(1);
        product.setIsSelected(0);
        product.setReadNum(0);
        if(productMapper.insertSelective(product)>0){
            return ServerResponse.createBySuccessMessage("创建成功");
        }
        return ServerResponse.createByErrorMessage("创建失败");
    }

    @Override
    public ServerResponse delete(Integer id) {
        if(productMapper.deleteByPrimaryKey(id)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse edit(Product product) {
        String productName = product.getProductName();
        int id = product.getId();
        if(productMapper.checkProductNameExSelf(productName,id)>0){
            return ServerResponse.createByErrorMessage("机构名已存在");
        }
        if(productMapper.updateByPrimaryKeySelective(product)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse get(Integer id) {
        Product product  = productMapper.selectByPrimaryKey(id);
        if(product!=null){
            return ServerResponse.createBySuccess(product);
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse editProductStatus(Integer id, Integer isOn, Integer type) {
        System.out.println("id："+id+"isOn:"+isOn+"type:"+type);
        Product product = new Product();
        if(type==1){//当==1修改上下架
            product.setId(id);
            product.setIsOn(isOn);
        }else if(type==2) {//修改是否精选（推荐）
            product.setId(id);
            product.setIsSelected(isOn);
        }else {
            product.setId(id);
            product.setIsCheck(isOn);
        }
        if(productMapper.updateByPrimaryKeySelective(product)>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public LayUiResponse productBuSelected(int pageSize, int currentPage) {
        PageHelper.startPage(currentPage,pageSize);
        List<Product> products = productMapper.productBuSelected();
        if(products.size()==0){
            return LayUiResponse.createByErrorMessage("未设置推荐");
        }
        PageInfo pageInfo = new PageInfo(products);
        return LayUiResponse.createBySuccess(products,(int)pageInfo.getTotal());
    }

    @Override
    public LayUiResponse products(int pageSize, int currentPage) {
        PageHelper.startPage(currentPage,pageSize);
        List<Product> products = productMapper.products();
        if(products.size()==0){
            return LayUiResponse.createByErrorMessage("未设置推荐");
        }
        PageInfo pageInfo = new PageInfo(products);
        return LayUiResponse.createBySuccess(products,(int)pageInfo.getTotal());
    }

    @Override
    public ServerResponse getBranchByPId(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if(user!=null){
            Branch branch = branchMapper.selectByPrimaryKey(user.getBranchId());
            if(branch!=null){
                return ServerResponse.createBySuccess(branch);
            }
            return ServerResponse.createByErrorMessage("机构为空");
        }
        return ServerResponse.createByErrorMessage("无该角色");
    }
}
