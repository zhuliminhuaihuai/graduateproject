package com.managesystem.dao;

import com.managesystem.pojo.WedPhoto;
import com.managesystem.vo.DetailPhotoVo;
import com.managesystem.vo.PhotoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WedPhotoMapper {
    int deleteByPrimaryKey(Integer photoId);

    int insert(WedPhoto record);

    int insertSelective(WedPhoto record);

    WedPhoto selectByPrimaryKey(Integer photoId);

    int updateByPrimaryKeySelective(WedPhoto record);

    int updateByPrimaryKey(WedPhoto record);

    //获取所有封面照片（封装的vo类）
    List<WedPhoto> getMotherPhoto(PhotoVo photoVo);

    //根据photoCode删除相册套餐包括内容
    int deletePhotoByPhotoCode(@Param("photoCode") String photoCode);

    //找到该套餐下的所有套餐内容
    List<DetailPhotoVo> getDownMotherPhoto(@Param("photoParentCode") String photoParentCode);

    //摄影师成果图
    List<DetailPhotoVo> getphotographerphoto(@Param("userCode") String userCode);

    //删除相册套餐内容（多张）
    int deleteManyPhotoChildren(@Param("idList") List<Integer> idList);

    //获取所有封面照片（客户）
    List<WedPhoto> getMontherPhotoListAsCustonmer(@Param("photoCode") String photoCode, @Param("photoTitle") String photoTitle);



}