package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.CarType;
import com.zhouwenbin.carsystem.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cartype")
@ResponseBody
public class CarTypeControl {
@Autowired
    private CarTypeService carTypeService;
    @PostMapping("/add")
    public Map addtype(@RequestBody CarType carType){
        String categoryname=carType.getCategoryname();
        carTypeService.addtype(carType);
        System.out.println("categoryname:"+categoryname);
        Map<String,Object> map=new HashMap<>();
        map.put("code",200);
        map.put("categoryname",categoryname);
        return map;
    }
    @PostMapping("/select")
    public  Map selecttype(@RequestBody CarType carType){
        carTypeService.selecttype(carType);
        String categoryname=carType.getCategoryname();
        Map<String,Object> map=new HashMap<>();
        map.put("code",200);
        map.put("categoryname",categoryname);
        return map;
    }
}
