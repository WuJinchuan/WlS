package com.wx.wlcx.resource;

import com.wx.wlcx.model.XTRegion;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class XTRegionResource {
    private static final String SPLIT_LINE = "-";

    private List<XTRegionList> regions;

    public XTRegionResource() {
        //默认空构造器
    }

    public XTRegionResource(List<XTRegion> xtRegions) {
        regions = new ArrayList<>();
        for(XTRegion xtRegion : xtRegions) {
            XTRegionList xtRegionList = new XTRegionList(xtRegion);
            regions.add(xtRegionList);
        }
    }

    public List<XTRegionList> getRegions() {
        return regions;
    }

    public void setRegions(List<XTRegionList> regions) {
        this.regions = regions;
    }

    class XTRegionList {
        private String RGID;
        private String ST_Pare;
        private String ST_Name; //级联全称
        private String RG_Name; //区域简称
        private String[] ST_Array; //级联分割
        private Double sxLocate;
        private Double syLocate;
        private String stTelcode;
        private String stZipcode;
        private String stRemark;
        private List<XTRegionList> regions;

        public XTRegionList() {
            //默认空构造器
        }

        public XTRegionList(XTRegion xtRegion) {
            this.RGID = xtRegion.getRgid();
            this.ST_Pare = xtRegion.getStPare();
            this.ST_Name = xtRegion.getStName();
            this.RG_Name = xtRegion.getRgName();
            this.ST_Array = xtRegion.getStName().split(SPLIT_LINE);
            this.sxLocate = xtRegion.getSxLocate();
            this.syLocate = xtRegion.getSyLocate();
            this.stTelcode = xtRegion.getStTelcode();
            this.stZipcode = xtRegion.getStZipcode();
            this.stRemark = xtRegion.getStRemark();
            if (!CollectionUtils.isEmpty(xtRegion.getRegions())) {
                this.regions = new ArrayList<>();
                for(XTRegion subXtRegion : xtRegion.getRegions()) {
                    XTRegionList subXtRegionList = new XTRegionList(subXtRegion);
                    this.regions.add(subXtRegionList);
                }
            }
        }

        public String getRGID() {
            return RGID;
        }

        public void setRGID(String RGID) {
            this.RGID = RGID;
        }

        public String getST_Pare() {
            return ST_Pare;
        }

        public void setST_Pare(String ST_Pare) {
            this.ST_Pare = ST_Pare;
        }

        public String getST_Name() {
            return ST_Name;
        }

        public void setST_Name(String ST_Name) {
            this.ST_Name = ST_Name;
        }

        public String getRG_Name() {
            return RG_Name;
        }

        public void setRG_Name(String RG_Name) {
            this.RG_Name = RG_Name;
        }

        public String[] getST_Array() {
            return ST_Array;
        }

        public void setST_Array(String[] ST_Array) {
            this.ST_Array = ST_Array;
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
            this.stTelcode = stTelcode;
        }

        public String getStZipcode() {
            return stZipcode;
        }

        public void setStZipcode(String stZipcode) {
            this.stZipcode = stZipcode;
        }

        public String getStRemark() {
            return stRemark;
        }

        public void setStRemark(String stRemark) {
            this.stRemark = stRemark;
        }

        public List<XTRegionList> getRegions() {
            return regions;
        }

        public void setRegions(List<XTRegionList> regions) {
            this.regions = regions;
        }
    }
}
