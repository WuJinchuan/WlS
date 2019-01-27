package com.wx.wlcx.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.wlcx.mapper.CMCompanyMapper;
import com.wx.wlcx.mapper.XTRegionMapper;
import com.wx.wlcx.model.CMCompany;
import com.wx.wlcx.model.XTRegion;
import com.wx.wlcx.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final static Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Autowired
    private CMCompanyMapper cmCompanyMapper;

    @Override
    public List<CMCompany> findCompany(int pageSize, int pageNum, String keyword, String arCode, String arName) {
        PageHelper.startPage(pageNum, pageSize);
        return cmCompanyMapper.findCompany(keyword, arCode, arName);
    }

    @Override
    public CMCompany findCompany(String id) {
        return cmCompanyMapper.findCompanyDetail(id);
    }
}
