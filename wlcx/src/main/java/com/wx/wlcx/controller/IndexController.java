package com.wx.wlcx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @GetMapping("/test")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}