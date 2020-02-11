package com.manage.service.Impl;

import com.google.common.collect.Lists;
import com.manage.common.Const;
import com.manage.common.ServerResponse;
import com.manage.dao.CartMapper;
import com.manage.dao.GoodsMapper;
import com.manage.pojo.Cart;
import com.manage.pojo.Goods;
import com.manage.service.ICartService;
import com.manage.vo.CartVo;
import com.manage.vo.infoListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsMapper goodsMapper;
    //获取当前用户下的购物车所有商品
    public ServerResponse getAllGoodsUnderCart(String userCode) {

        List<Cart> cartList = cartMapper.getAllGoods(userCode);
        List<infoListVo> infoList = Lists.newArrayList();
        if (cartList.size() > 0) {
            CartVo cartVo = new CartVo();
            String photoPath = "http://127.0.0.1:8080/upload/";
            for (int i = 0; i < cartList.size(); i++) {
                infoListVo infovo = new infoListVo();
                infovo.setImg(photoPath + cartList.get(i).getGoodsImg());
                infovo.setTitle(cartList.get(i).getGoodsTitle());
                infovo.setPrice(cartList.get(i).getGoodsRelPrice());
                for (Const.GoodsBigType state : Const.GoodsBigType.values()) {
                    // 遍历枚举 获取大分类名称
                    if (state.ordinal() == cartList.get(i).getGoodsBigType()) {
                        infovo.setGoodsBigTypeString(state.toString());
                    }
                }
                for (Const.GoodsSmallType state : Const.GoodsSmallType.values()) {
                    // 遍历枚举 获取小分类名称
                    if (state.ordinal() == cartList.get(i).getGoodsSmallType()) {
                        infovo.setGoodsSmallTypeString(state.toString());
                    }
                }
                infovo.setGoodsBuyNum(cartList.get(i).getGoodsBuyNum());
                infovo.setGoodsOneSumPrice(cartList.get(i).getGoodsOneSumPrice());
                infovo.setCartId(cartList.get(i).getCartId());
                infoList.add(infovo);
            }
            cartVo.setStatus(0);
            cartVo.setInfoList(infoList);
            return ServerResponse.createBySuccess("找到购物车的商品", cartVo);
        } else {
            return ServerResponse.createByErrorMessage("该用户还未添加任何商品");
        }
    }
    //加入购物车
    public ServerResponse addGoodsToCart(String userCode, Integer goodsId, Integer number) {

        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        Cart cart = new Cart();
        cart.setGoodsId(goodsId);
        cart.setUserCode(userCode);
        cart.setGoodsCode(goods.getGoodsCode());
        cart.setGoodsBuyNum(number);
        cart.setGoodsRelPrice(goods.getGoodsRelPrice());
        cart.setGoodsImg(goods.getGoodsImg());
        cart.setGoodsTitle(goods.getGoodsTitle());
        cart.setGoodsBigType(goods.getGoodsBigType());
        cart.setGoodsSmallType(goods.getGoodsType());
        cart.setGoodsOneSumPrice(number * goods.getGoodsRelPrice());
        cart.setCartCreateTime(new Date());
        int count = cartMapper.insertSelective(cart);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("添加成功");
        } else {
            return ServerResponse.createByErrorMessage("添加失败");
        }
    }
    //获取用户当前下的所有购物车商品数量
    public ServerResponse getShopCartNumber(String userCode) {
        int count = cartMapper.getShopCartNumber(userCode);
        return ServerResponse.createBySuccess(count);
    }
    //删除购物车的商品
    public ServerResponse deleteGoodsUnderCart(Integer cartId) {

        int count = cartMapper.deleteByPrimaryKey(cartId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }

}
