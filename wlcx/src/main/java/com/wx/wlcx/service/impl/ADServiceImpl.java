package com.wx.wlcx.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.wlcx.mapper.ADPictureMapper;
import com.wx.wlcx.model.ADPicture;
import com.wx.wlcx.service.ADService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ADServiceImpl implements ADService {
    private final static Logger logger = LoggerFactory.getLogger(ADServiceImpl.class);


    @Autowired
    private ADPictureMapper adPictureMapper;

    @Value("${Common.imagePathPrefix}")
    private String imagePathPrefix;

    @Override
    public List<ADPicture> getAdPictures() {
        logger.info("getAdPictures");
        return adPictureMapper.getAdPictures(imagePathPrefix);
    }

    @Override
    public List<ADPicture> getAll() {
        logger.info("getAll");
        return adPictureMapper.getAll();
    }

    @Override
    public List<ADPicture> findOnePage(int pageNum, int pageSize) {
        logger.info("findOnePage");
        PageHelper.startPage(pageNum, pageSize);
        return adPictureMapper.findOnePage();
    }
}
