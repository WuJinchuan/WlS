package com.wx.wlcx.controller;

import com.wx.wlcx.model.XTRegion;
import com.wx.wlcx.resource.XTRegionResource;
import com.wx.wlcx.service.CompanyService;
import com.wx.wlcx.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class XTRegionController {
    private final static Logger logger = LoggerFactory.getLogger(XTRegionController.class);

    @Autowired
    private CompanyService companyService;

    @GetMapping("/findAllRegion")
    public ResponseEntity<JsonResult> findAllUser(){
        logger.info(String.format("findAllRegion"));
        JsonResult r = new JsonResult();
        try {
            List<XTRegion> xtRegions = companyService.getAllRegion();
            r.setResult(new XTRegionResource(xtRegions));
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
