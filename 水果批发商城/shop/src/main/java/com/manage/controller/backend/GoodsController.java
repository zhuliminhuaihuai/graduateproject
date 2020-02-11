package com.manage.controller.backend;

import com.google.common.collect.Lists;
import com.manage.common.Const;
import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.dao.GoodsMapper;
import com.manage.pojo.Goods;
import com.manage.pojo.User;
import com.manage.service.IGoodsService;
import com.manage.util.DateUtil;
import com.manage.util.ImageCompression;
import com.manage.util.UuidUtil;
import com.manage.vo.*;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manage/goods/")
public class GoodsController {

    @Autowired
    private IGoodsService iGoodsService;

    //前端商城展示的商品
    @RequestMapping("portalGetGoodsImg")
    @ResponseBody
    public ServerResponse portalGetGoodsImg(@Param("title")String title,Integer goodsBigType,Integer goodsType) {
        return iGoodsService.portalGetGoodsImg(title,goodsBigType,goodsType);
    }

    //前端水果商品的详情
    @RequestMapping("portalDetailGoodsMessage")
    @ResponseBody
    public ServerResponse portalDetailGoodsMessage(Integer goodsId) {
        return iGoodsService.portalDetailGoodsMessage(goodsId);
    }

    //后台商品列表
    @RequestMapping("goodsList")
    @ResponseBody
    public LayUiPageResponse goodsList(GoodsQueryVo goodsQueryVo, Integer page, Integer limit) {
        return iGoodsService.goodsList(goodsQueryVo, page, limit);
    }

    //修改商品状态 是否启用
    @RequestMapping("modifyGoodsState")
    @ResponseBody
    public ServerResponse modifyGoodsState(Integer goodsId, Integer goodsState) {
        return iGoodsService.modifyGoodsState(goodsId, goodsState);
    }

    //批量删除商品
    @RequestMapping("someDeleteGoods")
    @ResponseBody
    public ServerResponse someDeleteGoods(String ids) {
        return iGoodsService.someDeleteGoods(ids);
    }

    //删除商品
    @RequestMapping("deleteGoods")
    @ResponseBody
    public ServerResponse deleteGoods(Integer goodsId) {
        return iGoodsService.deleteGoods(goodsId);
    }

    //商品详情
    @RequestMapping("detailGoods")
    @ResponseBody
    public ServerResponse detailGoods(Integer goodsId) {
        return iGoodsService.detailGoods(goodsId);
    }

    //保存商品 修改商品
    @RequestMapping("modifyGoods")
    @ResponseBody
    public ServerResponse modifyGoods(Goods goods, String goodsPrice1, String goodsCostPrice1, String goodsRelPrice1) {
        return iGoodsService.modifyGoods(goods, goodsPrice1, goodsCostPrice1, goodsRelPrice1);
    }

    //商品低于预警线
    @RequestMapping("goodsLowNumberLine")
    @ResponseBody
    public ServerResponse goodsLowNumberLine() {

        return iGoodsService.goodsLowNumberLine();
    }
    //添加商品
    @RequestMapping("addGoods")
    @ResponseBody
    public ServerResponse addGoods(Goods goods, String goodsPrice1, String goodsCostPrice1, String goodsRelPrice1) {
        return iGoodsService.addGoods(goods, goodsPrice1, goodsCostPrice1, goodsRelPrice1);
    }

    //补货商品列表
    @RequestMapping("getReplenishmentList")
    @ResponseBody
    public LayUiPageResponse getReplenishmentList(Integer page, Integer limit) {
        return iGoodsService.getReplenishmentList(page, limit);
    }

    //补充商品货物
    @RequestMapping("addReplenishmentGoods")
    @ResponseBody
    public ServerResponse addReplenishmentGoods(Goods goods) {
        return iGoodsService.addReplenishmentGoods(goods);
    }
    //上传商品照片
    @RequestMapping("uploadImg")
    @ResponseBody
    public ServerResponse uploadImg(HttpServletRequest request,
                                    HttpSession session) throws IOException {
        User user = (User) session.getAttribute(Const.ManagerToken.SESSION);
        // 转型为MultipartHttpServletRequest
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获取文件到map容器中
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        StringBuffer sb = new StringBuffer();
        String photo = "/AllImg/BranchImg/";
        String pictureSaveFilePath = request.getSession().getServletContext().getRealPath("upload");
        if (fileMap != null) {
            for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
                MultipartFile file = entity.getValue();
                if (file != null && !file.isEmpty()) {
                    String tpid = UuidUtil.get32UUID();
                    // 扩展名格式：
                    String extName = "";
                    if (file.getOriginalFilename().lastIndexOf(".") >= 0) {
                        extName = file.getOriginalFilename().substring(
                                file.getOriginalFilename().lastIndexOf("."));
                    }
                    String days = DateUtil.getDays();
                    // 多张图片上传
                    this.copyFile(file.getInputStream(),
                            pictureSaveFilePath + photo + days ,
                            tpid + extName).replaceAll("-", "");

                    sb.append(photo + days + "/" +   tpid
                            + extName);

                    // ----图片压缩 s-m-l 型
                    String imgSrc = pictureSaveFilePath + photo + days + "/"
                            + tpid + extName;
                    String imgS = photo + days + "/" + tpid + "_s"
                            + extName;
                    String imgM = photo + days + "/"  + tpid + "_m"
                            + extName;
                    String imgL = photo + days + "/"  + tpid + "_l"
                            + extName;

                    // ----获取图片的宽和高
                    File picture = new File(imgSrc);
                    BufferedImage sourceImg = ImageIO.read(picture);
                    float width = sourceImg.getWidth();
                    float height = sourceImg.getHeight();
                    // -----设置图片的压缩百分比
                    int scale = 0;
                    if (width <= 120 || height <= 64) {
                        scale = 100;
                    } else {
                        scale = (int) (120 / width * 100);
                    }
                    ImageCompression.scaleImage(imgSrc, pictureSaveFilePath
                            + imgS, scale);
                    if (width <= 240 || height <= 100) {
                        scale = 100;
                    } else {
                        scale = (int) (240 / width * 100);
                    }
                    ImageCompression.scaleImage(imgSrc, pictureSaveFilePath
                            + imgM, scale);
                    if (width <= 480 || height <= 120) {
                        scale = 100;
                    } else {
                        scale = (int) (480 / width * 100);
                    }
                    ImageCompression.scaleImage(imgSrc, pictureSaveFilePath
                            + imgL, scale);

                } else {
                    sb.append("");
                }
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uri", sb.toString());
        System.out.println("map:" + map);
        return ServerResponse.createBySuccess(map);
    }
    /**
     * 写文件到当前目录的upload目录中
     *
     * @param
     * @param
     * @throws IOException
     */
    private String copyFile(InputStream in, String dir, String realName)
            throws IOException {
        File file = new File(dir, realName);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        FileUtils.copyInputStreamToFile(in, file);
        return realName;
    }
    /**********************************************************/
    //跳转商城商品详情页面
    @RequestMapping("jumpGoodsDetail.html")
    public String jumpGoodsDetailHtml(@Param("goodsId") Integer goodsId, HttpServletRequest request) {
        System.out.println("id:" + goodsId);
        request.setAttribute("goodsId", goodsId);
        return "goods/portal_goods_detail";
    }

    //跳转商城商品详情页面未登录
    @RequestMapping("jumpGoodsDetailNoLogin.html")
    public String jumpGoodsDetailNoLoginHtml(@Param("goodsId") Integer goodsId, HttpServletRequest request) {
        System.out.println("id:" + goodsId);
        request.setAttribute("goodsId", goodsId);
        return "goods/portal_goods_detail_nologin";
    }

    //跳转商品列表
    @RequestMapping("jumpGoodsList.html")
    public String jumpGoodsListHtml() {
        return "goods/goods_list";
    }

    //跳转商品详情
    @RequestMapping("jumpGoodsDetailBackStage.html")
    public String jumpGoodsDetail() {
        return "goods/goods_detail";
    }

    //跳转添加商品页面
    @RequestMapping("jumpGoodsAdd.html")
    public String jumpGoodsAdd() {
        return "goods/goods_add";
    }

    //跳转补货商品列表
    @RequestMapping("jumpGoodsReplenishment.html")
    public String jumpGoodsReplenishmentHtml() {
        return "goods/goods_replenishment";
    }

    //打开补货数量界面
    @RequestMapping("jumpGoodsReplenishmentNumber.html")
    public String jumpGoodsReplenishmentNumberHtml() {
        return "goods/goods_replenishment_number";
    }
}
