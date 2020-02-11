package com.manage.controller.backend;

import com.manage.common.Const;
import com.manage.common.ServerResponse;
import com.manage.pojo.User;
import com.manage.service.ICartService;
import com.manage.service.ICountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/manage/cart/")
public class CartController {

    @Autowired
    private ICartService iCartService;

    @Autowired
    private ICountService iCountService;



    //获取当前用户下的购物车所有商品
    @RequestMapping("getAllGoodsUnderCart")
    @ResponseBody
    public ServerResponse getAllGoodsUnderCart(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        String userCode = user.getUserCode();
        return iCartService.getAllGoodsUnderCart(userCode);
    }

    //加入购物车
    @RequestMapping("addGoodsToCart")
    @ResponseBody
    public ServerResponse addGoodsToCart(String userCode, Integer goodsId, Integer number) {
        return iCartService.addGoodsToCart(userCode, goodsId, number);
    }

    //获取用户当前下的所有购物车商品数量
    @RequestMapping("getShopCartNumber")
    @ResponseBody
    public ServerResponse getShopCartNumber(String userCode) {
        return iCartService.getShopCartNumber(userCode);
    }

    //删除购物车的商品
    @RequestMapping("deleteGoodsUnderCart")
    @ResponseBody
    public ServerResponse deleteGoodsUnderCart(Integer cartId) {
        return iCartService.deleteGoodsUnderCart(cartId);
    }

}
