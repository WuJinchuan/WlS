package com.wx.wlcx.service.impl;

import com.wx.wlcx.mapper.XTRegionMapper;
import com.wx.wlcx.model.XTRegion;
import com.wx.wlcx.service.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    private final static Logger logger = LoggerFactory.getLogger(RegionServiceImpl.class);

    @Autowired
    private XTRegionMapper xtRegionMapper;

    @Override
    public List<XTRegion> getAllRegion() {
        logger.info("getAllRegion");
        return xtRegionMapper.getAll();
    }

    @Override
    public List<XTRegion> findRegionTree() {
        return xtRegionMapper.findRegionTree();
    }
}
