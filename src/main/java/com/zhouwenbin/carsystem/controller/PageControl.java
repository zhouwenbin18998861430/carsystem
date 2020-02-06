package com.zhouwenbin.carsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControl {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        return page;
    }
}
