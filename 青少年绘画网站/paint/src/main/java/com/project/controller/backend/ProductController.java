package com.project.controller.backend;

import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.LayUiResponse;
import com.project.common.ServerResponse;
import com.project.pojo.Branch;
import com.project.pojo.Product;
import com.project.pojo.User;
import com.project.service.IProductService;
import com.project.vo.CommonVo;
import jdk.nashorn.internal.parser.JSONParser;
import net.sf.json.JSON;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/manage/product/")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    //进入列表
    @RequestMapping(value = "product_list")
    public String product_list(){
        return "product/product_list";
    }
    //进入下架列表
    @RequestMapping(value = "under_product_list")
    public String under_product_list(){
        return "product/under_product_list";
    }
    //请求列表
    @RequestMapping(value="productList")
    @ResponseBody
    public LayUiPageResponse<List<Product>> productList(CommonVo commonVo, int page, int limit,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        commonVo.setRole(user.getRole().toString());
        commonVo.setUserId(user.getUserId());
        commonVo.setUserCode(user.getUserCode());
        return iProductService.productList(commonVo,page,limit);
    }

    //进入添加
    @RequestMapping(value = "product_add")
    public String product_add(){
        return "/product/product_add";
    }
    //生成机构和用户
    @RequestMapping(value="addProduct")
    @ResponseBody
    public ServerResponse addProduct(Product product, HttpServletRequest request){
        User user =(User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        product.setProdectUserId(user.getUserId());
        product.setProductUserName(user.getUserName());
        return iProductService.insert(product);
    }

    //进入修改
    @RequestMapping(value = "product_edit")
    public String product_edit(){
        return "/product/product_edit";
    }
    //获取信息
    @RequestMapping(value="getProductInfo")
    @ResponseBody
    public ServerResponse getProductInfo(Integer id){
        return iProductService.get(id);
    }
    //修改
    @RequestMapping(value="editProduct")
    @ResponseBody
    public ServerResponse editProduct(Product product){
        return iProductService.edit(product);
    }

    //删除
    @RequestMapping(value="deleteProduct")
    @ResponseBody
    public ServerResponse deleteProduct(Integer id){
        return iProductService.delete(id);
    }

  /*  //修改状态 上下架/是否精品
    @RequestMapping(value="editProductStatus",method =RequestMethod.POST )
    @ResponseBody
    public ServerResponse editProductStatus(int id,Integer isOn,Integer type){
        System.out.println("为什么："+id);
        return iProductService.editProductStatus(id,isOn,type);
    }*/
    //修改状态 上下架/是否精品
    @RequestMapping(value="editStatus",method =RequestMethod.POST )
    @ResponseBody
    public ServerResponse editStatus(int id,Integer isOn,Integer type){
        return iProductService.editProductStatus(id,isOn,type);
    }
    /********************************************************首页**********************************************************/
    //请求推荐列表
    @RequestMapping("productBuSelected")
    @ResponseBody
    public LayUiResponse productBuSelected(int pageSize, int currentPage){
        return iProductService.productBuSelected(pageSize,currentPage);
    }
    //请求所有作品列表 上架 审核通过
    @RequestMapping("products")
    @ResponseBody
    public LayUiResponse products(int pageSize, int currentPage){
        return iProductService.products(pageSize,currentPage);
    }

    //请求所有作品列表 上架 审核通过
    @RequestMapping("getBranchByPId")
    @ResponseBody
    public ServerResponse getBranchByPId(Integer userId){
        return iProductService.getBranchByPId(userId);
    }

}
