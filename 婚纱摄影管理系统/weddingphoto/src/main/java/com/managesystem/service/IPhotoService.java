package com.managesystem.service;

import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.pojo.WedPhoto;
import com.managesystem.vo.AddPhotoVo;
import com.managesystem.vo.PhotoVo;
import org.apache.ibatis.annotations.Param;

public interface IPhotoService {


    //获取所有封面照片（封装的vo类）
    LayUiPageResponse getMontherPhotoList(PhotoVo photoVo, Integer page, Integer limit);

    //获取所有封面照片（客户）
    LayUiPageResponse getMontherPhotoListAsCustonmer(String photoCode, String photoTitle, Integer page, Integer limit);

    //修改相册是否启用状态
    ServerResponse modifyPhotoState(WedPhoto wedPhoto);

    //摄影师成果图
    ServerResponse getphotographerphoto(String userCode);

    //上传婚纱套餐
    ServerResponse addPhoto(AddPhotoVo addPhotoVo);

    //删除相册包括相册内容
    ServerResponse deletePhoto(String photoCode);

    //相册详情
    ServerResponse detailPhoto(Integer photoId);

    //上传相册套餐内容（子照片）
    ServerResponse addPhotoChildren(String photoImg, String photoParentCode);

    //删除相册套餐内容（子照片 单张）
    ServerResponse deletePhotoChildren(Integer photoId);

    //删除相册套餐内容（多张）
    ServerResponse deleteManyPhotoChildren(@Param("photoIds") String photoIds);

    //修改相册套餐的基本信息
    ServerResponse modifyPhotoMessage(WedPhoto wedPhoto);

    //相册基本信息详情
    ServerResponse detailPhotoMessage(Integer photoId);


}
