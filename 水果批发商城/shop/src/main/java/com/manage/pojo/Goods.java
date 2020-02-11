package com.manage.pojo;

import java.util.Date;

public class Goods {
    private Integer goodsId;

    private String goodsCode;

    private String goodsImg;

    private Integer goodsState;

    private Integer goodsBigType;

    private Integer goodsType;

    private String goodsTitle;

    private Double goodsCostPrice;

    private Double goodsRelPrice;

    private Double goodsPrice;

    private Integer goodsBuyNum;

    private Date goodsCreateTime;

    private Date goodsUpdateTime;

    private Integer goodsInventory;

    private String goodsRenark;

    public Goods(Integer goodsId, String goodsCode, String goodsImg, Integer goodsState, Integer goodsBigType, Integer goodsType, String goodsTitle, Double goodsCostPrice, Double goodsRelPrice, Double goodsPrice, Integer goodsBuyNum, Date goodsCreateTime, Date goodsUpdateTime, Integer goodsInventory, String goodsRenark) {
        this.goodsId = goodsId;
        this.goodsCode = goodsCode;
        this.goodsImg = goodsImg;
        this.goodsState = goodsState;
        this.goodsBigType = goodsBigType;
        this.goodsType = goodsType;
        this.goodsTitle = goodsTitle;
        this.goodsCostPrice = goodsCostPrice;
        this.goodsRelPrice = goodsRelPrice;
        this.goodsPrice = goodsPrice;
        this.goodsBuyNum = goodsBuyNum;
        this.goodsCreateTime = goodsCreateTime;
        this.goodsUpdateTime = goodsUpdateTime;
        this.goodsInventory = goodsInventory;
        this.goodsRenark = goodsRenark;
    }

    public Goods() {
        super();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public Integer getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Integer goodsState) {
        this.goodsState = goodsState;
    }

    public Integer getGoodsBigType() {
        return goodsBigType;
    }

    public void setGoodsBigType(Integer goodsBigType) {
        this.goodsBigType = goodsBigType;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle == null ? null : goodsTitle.trim();
    }

    public Double getGoodsCostPrice() {
        return goodsCostPrice;
    }

    public void setGoodsCostPrice(Double goodsCostPrice) {
        this.goodsCostPrice = goodsCostPrice;
    }

    public Double getGoodsRelPrice() {
        return goodsRelPrice;
    }

    public void setGoodsRelPrice(Double goodsRelPrice) {
        this.goodsRelPrice = goodsRelPrice;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsBuyNum() {
        return goodsBuyNum;
    }

    public void setGoodsBuyNum(Integer goodsBuyNum) {
        this.goodsBuyNum = goodsBuyNum;
    }

    public Date getGoodsCreateTime() {
        return goodsCreateTime;
    }

    public void setGoodsCreateTime(Date goodsCreateTime) {
        this.goodsCreateTime = goodsCreateTime;
    }

    public Date getGoodsUpdateTime() {
        return goodsUpdateTime;
    }

    public void setGoodsUpdateTime(Date goodsUpdateTime) {
        this.goodsUpdateTime = goodsUpdateTime;
    }

    public Integer getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(Integer goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public String getGoodsRenark() {
        return goodsRenark;
    }

    public void setGoodsRenark(String goodsRenark) {
        this.goodsRenark = goodsRenark == null ? null : goodsRenark.trim();
    }
}