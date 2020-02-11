package com.manage.pojo;

import java.util.Date;

public class Cart {
    private Integer cartId;

    private Integer goodsId;

    private String cartCode;

    private String userCode;

    private String goodsCode;

    private Integer goodsBuyNum;

    private Double goodsRelPrice;

    private String goodsImg;

    private String goodsTitle;

    private Integer goodsBigType;

    private Integer goodsSmallType;

    private Double goodsOneSumPrice;

    private Double goodsSumPrice;

    private Date cartCreateTime;

    private Date cartUpdateTime;

    private Integer cartBuySumNum;

    public Cart(Integer cartId, Integer goodsId, String cartCode, String userCode, String goodsCode, Integer goodsBuyNum, Double goodsRelPrice, String goodsImg, String goodsTitle, Integer goodsBigType, Integer goodsSmallType, Double goodsOneSumPrice, Double goodsSumPrice, Date cartCreateTime, Date cartUpdateTime, Integer cartBuySumNum) {
        this.cartId = cartId;
        this.goodsId = goodsId;
        this.cartCode = cartCode;
        this.userCode = userCode;
        this.goodsCode = goodsCode;
        this.goodsBuyNum = goodsBuyNum;
        this.goodsRelPrice = goodsRelPrice;
        this.goodsImg = goodsImg;
        this.goodsTitle = goodsTitle;
        this.goodsBigType = goodsBigType;
        this.goodsSmallType = goodsSmallType;
        this.goodsOneSumPrice = goodsOneSumPrice;
        this.goodsSumPrice = goodsSumPrice;
        this.cartCreateTime = cartCreateTime;
        this.cartUpdateTime = cartUpdateTime;
        this.cartBuySumNum = cartBuySumNum;
    }

    public Cart() {
        super();
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode == null ? null : cartCode.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public Integer getGoodsBuyNum() {
        return goodsBuyNum;
    }

    public void setGoodsBuyNum(Integer goodsBuyNum) {
        this.goodsBuyNum = goodsBuyNum;
    }

    public Double getGoodsRelPrice() {
        return goodsRelPrice;
    }

    public void setGoodsRelPrice(Double goodsRelPrice) {
        this.goodsRelPrice = goodsRelPrice;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle == null ? null : goodsTitle.trim();
    }

    public Integer getGoodsBigType() {
        return goodsBigType;
    }

    public void setGoodsBigType(Integer goodsBigType) {
        this.goodsBigType = goodsBigType;
    }

    public Integer getGoodsSmallType() {
        return goodsSmallType;
    }

    public void setGoodsSmallType(Integer goodsSmallType) {
        this.goodsSmallType = goodsSmallType;
    }

    public Double getGoodsOneSumPrice() {
        return goodsOneSumPrice;
    }

    public void setGoodsOneSumPrice(Double goodsOneSumPrice) {
        this.goodsOneSumPrice = goodsOneSumPrice;
    }

    public Double getGoodsSumPrice() {
        return goodsSumPrice;
    }

    public void setGoodsSumPrice(Double goodsSumPrice) {
        this.goodsSumPrice = goodsSumPrice;
    }

    public Date getCartCreateTime() {
        return cartCreateTime;
    }

    public void setCartCreateTime(Date cartCreateTime) {
        this.cartCreateTime = cartCreateTime;
    }

    public Date getCartUpdateTime() {
        return cartUpdateTime;
    }

    public void setCartUpdateTime(Date cartUpdateTime) {
        this.cartUpdateTime = cartUpdateTime;
    }

    public Integer getCartBuySumNum() {
        return cartBuySumNum;
    }

    public void setCartBuySumNum(Integer cartBuySumNum) {
        this.cartBuySumNum = cartBuySumNum;
    }
}