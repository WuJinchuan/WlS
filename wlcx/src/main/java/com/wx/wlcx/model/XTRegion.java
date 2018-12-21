package com.wx.wlcx.model;

public class XTRegion {
    private String rgid;

    private String cpid;

    private String stPare;

    private String stTree;

    private String stName;

    private String rgName;

    private Integer stState;

    private Double sxLocate;

    private Double syLocate;

    private String stTelcode;

    private String stZipcode;

    private String stRemark;

    public String getRgid() {
        return rgid;
    }

    public void setRgid(String rgid) {
        this.rgid = rgid == null ? null : rgid.trim();
    }

    public String getCpid() {
        return cpid;
    }

    public void setCpid(String cpid) {
        this.cpid = cpid == null ? null : cpid.trim();
    }

    public String getStPare() {
        return stPare;
    }

    public void setStPare(String stPare) {
        this.stPare = stPare == null ? null : stPare.trim();
    }

    public String getStTree() {
        return stTree;
    }

    public void setStTree(String stTree) {
        this.stTree = stTree == null ? null : stTree.trim();
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName == null ? null : stName.trim();
    }

    public String getRgName() {
        return rgName;
    }

    public void setRgName(String rgName) {
        this.rgName = rgName == null ? null : rgName.trim();
    }

    public Integer getStState() {
        return stState;
    }

    public void setStState(Integer stState) {
        this.stState = stState;
    }

    public Double getSxLocate() {
        return sxLocate;
    }

    public void setSxLocate(Double sxLocate) {
        this.sxLocate = sxLocate;
    }

    public Double getSyLocate() {
        return syLocate;
    }

    public void setSyLocate(Double syLocate) {
        this.syLocate = syLocate;
    }

    public String getStTelcode() {
        return stTelcode;
    }

    public void setStTelcode(String stTelcode) {
        this.stTelcode = stTelcode == null ? null : stTelcode.trim();
    }

    public String getStZipcode() {
        return stZipcode;
    }

    public void setStZipcode(String stZipcode) {
        this.stZipcode = stZipcode == null ? null : stZipcode.trim();
    }

    public String getStRemark() {
        return stRemark;
    }

    public void setStRemark(String stRemark) {
        this.stRemark = stRemark == null ? null : stRemark.trim();
    }
}