package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/carregister")
@ResponseBody
@EnableAutoConfiguration
public class CarRegisterControl {
    @Autowired
    private CarsService carsService;
    @PostMapping("/carregister")
    public Map selectJobInfos(@RequestBody Cars cars){
    // Integer category=cars.getCategory();
    String carNum=cars.getCarNum();
    // String account=cars.getAccount();
    // Integer size =cars.getSize();
    // String photolocation=cars.getPhotolocation();
    //     System.out.println("category"+category);
    //     System.out.println("carNum"+carNum);
    //     System.out.println("account"+account);
    //     System.out.println("size"+size);
    //     System.out.println("photolocation"+photolocation);
    carsService.registerCar(cars);
    Map<String ,Object>dataMap =new HashMap<>();
    dataMap.put("carNum",carNum);
    dataMap.put("code",200);
    return dataMap;
    }
}
