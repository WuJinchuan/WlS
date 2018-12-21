package com.wx.wlcx.mapper;

import com.wx.wlcx.model.CMMatcher;

public interface CMMatcherMapper {
    int insert(CMMatcher record);

    int insertSelective(CMMatcher record);
}