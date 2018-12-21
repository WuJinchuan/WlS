package com.wx.wlcx.resource;

import com.wx.wlcx.model.CMCompany;
import com.wx.wlcx.model.CMMatcher;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CompanyResource {
    private String id;
    private String companyName;
    private String companyAddr;
    private String phone;//固定电话
    private String mobilePhone; //手机号

    private String logoPath;
    private String briefIntroduction;
    private String detailIntroduction;

    private List<Mathcer> mathcerList;

    public CompanyResource(CMCompany cmCompany) {
        this.id = cmCompany.getCoid();
        this.companyName = cmCompany.getCoName();
        this.companyAddr = cmCompany.getCoAddr();
        this.phone = cmCompany.getCoPhone();
        this.mobilePhone = cmCompany.getCoLkcode();

        this.logoPath = cmCompany.getCoPiclogo();
        this.detailIntroduction = cmCompany.getCoIntroduction();
        this.briefIntroduction = cmCompany.getCoSurvev();

        this.mathcerList = generateMatcherList(cmCompany.getCmMatchers());
    }

    private List<Mathcer> generateMatcherList(List<CMMatcher> cmMatchers) {
        List<Mathcer> mathcers = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(cmMatchers)) {
            for (CMMatcher cmMatcher : cmMatchers) {
                mathcers.add(new Mathcer(cmMatcher));
            }
        }

        return mathcers;
    }

    public List<Mathcer> getMathcerList() {
        return mathcerList;
    }

    public void setMathcerList(List<Mathcer> mathcerList) {
        this.mathcerList = mathcerList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getDetailIntroduction() {
        return detailIntroduction;
    }

    public void setDetailIntroduction(String detailIntroduction) {
        this.detailIntroduction = detailIntroduction;
    }

    class Mathcer {
        private String crId;
        private String arCode;//送货地址编号
        private String arName;//地址
        private Integer style; //1直达 2 中转

        public Mathcer(CMMatcher matcher) {
            this.crId = matcher.getCoid();
            this.arCode = matcher.getArCode();
            this.arName = matcher.getArName();
            this.style = matcher.getCrStyle();
        }

        public String getCrId() {
            return crId;
        }

        public void setCrId(String crId) {
            this.crId = crId;
        }

        public String getArCode() {
            return arCode;
        }

        public void setArCode(String arCode) {
            this.arCode = arCode;
        }

        public String getArName() {
            return arName;
        }

        public void setArName(String arName) {
            this.arName = arName;
        }

        public Integer getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }
    }
}
