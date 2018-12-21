package com.wx.wlcx.controller;

import com.wx.wlcx.model.ADPicture;
import com.wx.wlcx.service.ADService;
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
public class ADController {
    private final static Logger logger = LoggerFactory.getLogger(ADController.class);

    @Autowired
    private ADService adService;

    //获取所有数据
    @GetMapping("/getAllAd")
    public ResponseEntity<JsonResult> getUserList (){
        logger.info("get all ads");
        JsonResult r = new JsonResult();
        try {
            List<ADPicture> ads = adService.getAll();
            r.setResult(ads);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @GetMapping(value = "/ad/pages/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<JsonResult> findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        logger.info(String.format("get one page ads, pageSize: %d, page: %d", pageNum, pageSize));
        JsonResult r = new JsonResult();
        try {
            List<ADPicture> users = adService.findOnePage(pageNum, pageSize);
            r.setResult(users);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
