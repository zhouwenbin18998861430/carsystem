package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.CarType;
import com.zhouwenbin.carsystem.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cartype")
@ResponseBody
public class CarTypeControl {
@Autowired
    private CarTypeService carTypeService;
    @PostMapping("/add")
    public String addtype(@RequestBody CarType carType){
        String categoryname=carType.getCategoryname();
        carTypeService.addtype(carType);
        System.out.println("categoryname:"+categoryname);
        return categoryname;
    }
}
