package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carregister")
@ResponseBody
public class CarRegister {
    @Autowired
    private CarsService carsService;
    @PostMapping("/carregister")
    public String selectJobInfos(@RequestBody Cars cars){
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
    return carNum;
    }
}
