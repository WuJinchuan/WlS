package com.wx.wlcx.resource;

import com.wx.wlcx.model.CMCompany;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CompaniesListResource {
    private List<CompanyResource> companyResourceList;

    public CompaniesListResource(List<CMCompany> cmCompanies) {
        companyResourceList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(cmCompanies)) {
            for (CMCompany cmCompany : cmCompanies) {
                companyResourceList.add(new CompanyResource(cmCompany));
            }
        }
    }

    public List<CompanyResource> getCompanyResourceList() {
        return companyResourceList;
    }

    public void setCompanyResourceList(List<CompanyResource> companyResourceList) {
        this.companyResourceList = companyResourceList;
    }
}
