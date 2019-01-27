package com.wx.wlcx.service;

import com.wx.wlcx.model.XTRegion;

import java.util.List;

public interface RegionService {
    List<XTRegion> getAllRegion();

    List<XTRegion> findRegionTree();
}
