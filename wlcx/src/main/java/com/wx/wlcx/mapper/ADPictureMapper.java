package com.wx.wlcx.mapper;

import com.wx.wlcx.model.ADPicture;

import java.util.List;

public interface ADPictureMapper {
    List<ADPicture> getAll();

    List<ADPicture> findOnePage();
}