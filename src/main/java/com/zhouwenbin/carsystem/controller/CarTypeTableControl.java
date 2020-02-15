package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.service.CarTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/table")
public class CarTypeTableControl {
    @Autowired
    private CarTableService carTableService;
    @RequestMapping("/select")
    public Map selectTable(@RequestBody Cars cars){
        //--------------
        String a=cars.getCategory();
        System.out.println("category:"+a);
        //--------------
        List<Cars> selectlist=carTableService.selectList(cars);

        Map<String,Object> map=new HashMap();
        map.put("data",selectlist);
        map.put("status", 0);
        map.put("message", "");
        map.put("total", "");
        System.out.println("打印："+selectlist.toString());
        System.out.println("map:"+map);
        return map;
    }
}
