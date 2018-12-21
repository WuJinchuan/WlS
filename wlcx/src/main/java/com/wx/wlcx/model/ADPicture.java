package com.wx.wlcx.model;

public class ADPicture {
    private String adid;

    private String coid;

    private Integer adType;

    private String adImage;

    private String adRemark;

    private byte[] adIcon;

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid == null ? null : adid.trim();
    }

    public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid == null ? null : coid.trim();
    }

    public Integer getAdType() {
        return adType;
    }

    public void setAdType(Integer adType) {
        this.adType = adType;
    }

    public String getAdImage() {
        return adImage;
    }

    public void setAdImage(String adImage) {
        this.adImage = adImage == null ? null : adImage.trim();
    }

    public String getAdRemark() {
        return adRemark;
    }

    public void setAdRemark(String adRemark) {
        this.adRemark = adRemark == null ? null : adRemark.trim();
    }

    public byte[] getAdIcon() {
        return adIcon;
    }

    public void setAdIcon(byte[] adIcon) {
        this.adIcon = adIcon;
    }
}