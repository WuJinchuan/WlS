package com.wx.wlcx.model;

public class CMMatcher {
    private String coid;

    private Integer crIdx;

    private Integer crMode;

    private Integer ctMode;

    private Double crFate;

    private String rgCode;

    private String rgName;

    private String arCode;

    private String arName;

    private String cmCode;

    private String cmName;

    private String crAddr;

    private Integer crStyle;

    private Integer crGrade;

    public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid;
    }

    public Integer getCrIdx() {
        return crIdx;
    }

    public void setCrIdx(Integer crIdx) {
        this.crIdx = crIdx;
    }

    public Integer getCrMode() {
        return crMode;
    }

    public void setCrMode(Integer crMode) {
        this.crMode = crMode;
    }

    public Integer getCtMode() {
        return ctMode;
    }

    public void setCtMode(Integer ctMode) {
        this.ctMode = ctMode;
    }

    public Double getCrFate() {
        return crFate;
    }

    public void setCrFate(Double crFate) {
        this.crFate = crFate;
    }

    public String getRgCode() {
        return rgCode;
    }

    public void setRgCode(String rgCode) {
        this.rgCode = rgCode == null ? null : rgCode.trim();
    }

    public String getRgName() {
        return rgName;
    }

    public void setRgName(String rgName) {
        this.rgName = rgName == null ? null : rgName.trim();
    }

    public String getArCode() {
        return arCode;
    }

    public void setArCode(String arCode) {
        this.arCode = arCode == null ? null : arCode.trim();
    }

    public String getArName() {
        return arName;
    }

    public void setArName(String arName) {
        this.arName = arName == null ? null : arName.trim();
    }

    public String getCmCode() {
        return cmCode;
    }

    public void setCmCode(String cmCode) {
        this.cmCode = cmCode == null ? null : cmCode.trim();
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName == null ? null : cmName.trim();
    }

    public String getCrAddr() {
        return crAddr;
    }

    public void setCrAddr(String crAddr) {
        this.crAddr = crAddr == null ? null : crAddr.trim();
    }

    public Integer getCrStyle() {
        return crStyle;
    }

    public void setCrStyle(Integer crStyle) {
        this.crStyle = crStyle;
    }

    public Integer getCrGrade() {
        return crGrade;
    }

    public void setCrGrade(Integer crGrade) {
        this.crGrade = crGrade;
    }
}