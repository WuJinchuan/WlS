package com.wx.wlcx.mapper;

import com.wx.wlcx.model.XTRegion;

import java.util.List;

public interface XTRegionMapper {
    int insert(XTRegion record);

    int insertSelective(XTRegion record);

    List<XTRegion> getAll();

    List<XTRegion> findRegionTree();
}