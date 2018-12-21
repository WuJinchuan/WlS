package com.wx.wlcx.resource;

import com.wx.wlcx.model.XTRegion;

import java.util.ArrayList;
import java.util.List;

public class XTRegionResource {
    private static final String SPLIT_LINE = "-";

    private List<XTRegionList> xtRegionLists;

    public XTRegionResource(List<XTRegion> xtRegions) {
        xtRegionLists = new ArrayList<>();
        for(XTRegion xtRegion : xtRegions) {
            XTRegionList xtRegionList = new XTRegionList();
            xtRegionList.setRGID(xtRegion.getCpid());
            xtRegionList.setRG_Name(xtRegion.getRgName());
            xtRegionList.setST_Name(xtRegion.getStName());
            xtRegionList.setST_Array(xtRegion.getStName().split(SPLIT_LINE));
            xtRegionLists.add(xtRegionList);
        }
    }

    public List<XTRegionList> getXtRegionLists() {
        return xtRegionLists;
    }

    public void setXtRegionLists(List<XTRegionList> xtRegionLists) {
        this.xtRegionLists = xtRegionLists;
    }

    class XTRegionList {
        private String RGID;
        private String ST_Name; //级联全称
        private String RG_Name; //区域简称
        private String[] ST_Array; //级联分割

        public XTRegionList() {

        }

        public XTRegionList(String RGID, String ST_Name, String RG_Name, String[] ST_Array) {
            this.RGID = RGID;
            this.ST_Name = ST_Name;
            this.RG_Name = RG_Name;
            this.ST_Array = ST_Array;
        }

        public String getRGID() {
            return RGID;
        }

        public void setRGID(String RGID) {
            this.RGID = RGID;
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
    }
}
