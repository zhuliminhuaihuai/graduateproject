package com.managesystem.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.managesystem.common.LayUiPageResponse;
import com.managesystem.common.ServerResponse;
import com.managesystem.dao.WedPhotoMapper;
import com.managesystem.pojo.WedPhoto;
import com.managesystem.service.IPhotoService;
import com.managesystem.util.PublicUtil;
import com.managesystem.vo.AddPhotoVo;
import com.managesystem.vo.DetailPhotoVo;
import com.managesystem.vo.PhotoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PhotoServiceImpl implements IPhotoService {

    @Autowired
    private WedPhotoMapper wedPhotoMapper;

    //获取所有封面照片（封装的vo类）
    public LayUiPageResponse getMontherPhotoList(PhotoVo photoVo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<WedPhoto> wedPhotoList = wedPhotoMapper.getMotherPhoto(photoVo);
        String photoPath = "http://127.0.0.1:8080/upload/";
        if (wedPhotoList.size() > 0) {
            for (int i = 0; i < wedPhotoList.size(); i++) {
                wedPhotoList.get(i).setPhotoImg(photoPath + wedPhotoList.get(i).getPhotoImg());
            }
            PageInfo pageInfo = new PageInfo(wedPhotoList);
            return LayUiPageResponse.createBySuccess(wedPhotoList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据！");
        }
    }

    //获取所有封面照片（客户）
    public LayUiPageResponse getMontherPhotoListAsCustonmer(String photoCode, String photoTitle, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<WedPhoto> wedPhotoList = wedPhotoMapper.getMontherPhotoListAsCustonmer(photoCode, photoTitle);
        String photoPath = "http://127.0.0.1:8080/upload/";
        if (wedPhotoList.size() > 0) {
            for (int i = 0; i < wedPhotoList.size(); i++) {
                wedPhotoList.get(i).setPhotoImg(photoPath + wedPhotoList.get(i).getPhotoImg());
            }
            PageInfo pageInfo = new PageInfo(wedPhotoList);
            return LayUiPageResponse.createBySuccess(wedPhotoList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无数据！");
        }
    }

    //修改相册是否启用状态
    public ServerResponse modifyPhotoState(WedPhoto wedPhoto) {
        int count = wedPhotoMapper.updateByPrimaryKeySelective(wedPhoto);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        } else {
            return ServerResponse.createByErrorMessage("修改失败");
        }
    }
    //摄影师成果图
    public ServerResponse getphotographerphoto(String userCode) {

        List<DetailPhotoVo> detailPhotoVoList = wedPhotoMapper.getphotographerphoto(userCode);
        if (detailPhotoVoList.size() > 0) {
            return ServerResponse.createBySuccess("找到成果图", detailPhotoVoList);
        } else {
            return ServerResponse.createByErrorMessage("没有成果图");
        }
    }

    //上传婚纱套餐
    public ServerResponse addPhoto(AddPhotoVo addPhotoVo) {
        WedPhoto wedPhoto = new WedPhoto();
        //先存入封面照片
        String photoParentCode = PublicUtil.setCode("P");
        wedPhoto.setPhotoCode(photoParentCode);
        wedPhoto.setPhotoImg(addPhotoVo.getHeadimg());
        wedPhoto.setPhotoCreateTime(new Date());
        wedPhoto.setPhotoParentCode("nullcode");
        wedPhoto.setPhotoState(Integer.parseInt(addPhotoVo.getPhotoState()));
        wedPhoto.setPhotoTitle(addPhotoVo.getPhotoTitle());
        wedPhoto.setPhotoDetail(addPhotoVo.getPhotoDetail());
        wedPhoto.setPhotoRemarks(addPhotoVo.getPhotoRemarks());
        int count = wedPhotoMapper.insertSelective(wedPhoto);
        if (count > 0) {
            //遍历相册套餐内容将套餐内容插入表中
            System.out.println("进来了么？");
            System.out.println("照片内容："+addPhotoVo.getPicture());
            String[] pictureArray = addPhotoVo.getPicture().split("#");
            int countTotal = 0;
            int countFalse = 0;
            for (int i = 0; i < pictureArray.length; i++) {
                if (!pictureArray[i].equals("")) {
                    WedPhoto wedPhoto1 = new WedPhoto();
                    wedPhoto1.setPhotoCode(PublicUtil.setCode("PC"));
                    wedPhoto1.setPhotoImg(pictureArray[i]);
                    wedPhoto1.setPhotoCreateTime(new Date());
                    wedPhoto1.setPhotoParentCode(photoParentCode);
                    wedPhoto1.setPhotoState(1);
                    wedPhotoMapper.insertSelective(wedPhoto1);
                    countTotal++;
                } else {
                    countFalse++;
                }
            }
            if (countTotal == (pictureArray.length-countFalse)) {
                return ServerResponse.createBySuccessMessage("相册套餐存入成功");
            }
        } else {
            return ServerResponse.createByErrorMessage("相册套餐存入失败");
        }
        return ServerResponse.createByErrorMessage("相册套餐存入失败");
    }

    //删除相册包括相册内容
    public ServerResponse deletePhoto(String photoCode) {

        int count = wedPhotoMapper.deletePhotoByPhotoCode(photoCode);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }

    }
    //相册详情
    public ServerResponse detailPhoto(Integer photoId) {

        WedPhoto wedPhoto = wedPhotoMapper.selectByPrimaryKey(photoId);
        if (wedPhoto != null) {
            String photoCode = wedPhoto.getPhotoCode();
            String photoTitle = wedPhoto.getPhotoTitle();
            Date photoCreateTime = wedPhoto.getPhotoCreateTime();
            List<DetailPhotoVo> detailPhotoVoList = wedPhotoMapper.getDownMotherPhoto(photoCode);
            if (detailPhotoVoList.size() > 0) {
                detailPhotoVoList.get(0).setPhoto_title(photoTitle);
                detailPhotoVoList.get(0).setMotherPhotoCreateTime(photoCreateTime);
                return ServerResponse.createBySuccess("找到相册内容", detailPhotoVoList);
            } else {
                return ServerResponse.createByErrorMessage("该婚纱套餐没有相册内容");
            }
        } else {
            return ServerResponse.createByErrorMessage("未找到该婚纱套餐");
        }

    }

    //上传相册套餐内容（子照片）
    public ServerResponse addPhotoChildren(String photoImg, String photoParentCode) {
        WedPhoto wedPhoto = new WedPhoto();
        wedPhoto.setPhotoCode(PublicUtil.setCode("PC"));
        wedPhoto.setPhotoImg(photoImg);
        wedPhoto.setPhotoCreateTime(new Date());
        wedPhoto.setPhotoParentCode(photoParentCode);
        wedPhoto.setPhotoState(1);
        int count = wedPhotoMapper.insertSelective(wedPhoto);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("添加成功");
        } else {
            return ServerResponse.createByErrorMessage("添加失败");
        }
    }

    //删除相册套餐内容（子照片 单张）
    public ServerResponse deletePhotoChildren(Integer photoId) {

        int count = wedPhotoMapper.deleteByPrimaryKey(photoId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }

    //删除相册套餐内容（多张）
    public ServerResponse deleteManyPhotoChildren(@Param("photoIds") String photoIds) {
        int x = photoIds.indexOf("[");
        int y = photoIds.indexOf("]");
        String photoIdsString = photoIds.substring(x + 1, y );
        System.out.println(photoIdsString);
        String[] photoIdsStringArray= photoIdsString.split(",");
        List<Integer> idList =new ArrayList();
        for(String s : photoIdsStringArray){
            Integer i = Integer.parseInt(s);
            idList.add(i);
        }
        int count = wedPhotoMapper.deleteManyPhotoChildren(idList);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }
    //修改相册套餐的基本信息
    public ServerResponse modifyPhotoMessage(WedPhoto wedPhoto) {

        int count = wedPhotoMapper.updateByPrimaryKeySelective(wedPhoto);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        } else {
            return ServerResponse.createBySuccessMessage("修改失败");
        }
    }
    //相册基本信息详情
    public ServerResponse detailPhotoMessage(Integer photoId) {

        WedPhoto wedPhoto = wedPhotoMapper.selectByPrimaryKey(photoId);
        if (wedPhoto != null) {
            return ServerResponse.createBySuccess("找到相册", wedPhoto);
        } else {
            return ServerResponse.createByErrorMessage("暂无此相册");
        }
    }




}
