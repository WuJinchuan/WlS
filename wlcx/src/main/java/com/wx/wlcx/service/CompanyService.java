package com.wx.wlcx.service;

import com.wx.wlcx.model.CMCompany;
import com.wx.wlcx.model.XTRegion;

import java.util.List;

public interface CompanyService {
    List<CMCompany> findCompany(int pageSize, int pageNum, String keyword, String arCode, String arName);

    CMCompany findCompany(String id);
}
