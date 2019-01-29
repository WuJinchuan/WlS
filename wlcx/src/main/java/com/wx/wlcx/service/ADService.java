package com.wx.wlcx.service;

import com.wx.wlcx.model.ADPicture;
import com.wx.wlcx.po.CMMatcher;

import java.util.List;

public interface ADService {
    List<ADPicture> getAdPictures();

    List<ADPicture> getAll();

    List<ADPicture> findOnePage(int pageNum, int pageSize);
}
