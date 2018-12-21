package com.wx.wlcx.service;

import com.wx.wlcx.po.CMMatcher;

import java.util.List;

public interface MatcherService {
    List<CMMatcher> getAll();

    List<com.wx.wlcx.model.CMMatcher> findAll(int pageNum, int pageSize);
}
