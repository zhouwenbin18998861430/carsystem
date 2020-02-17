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
        return map;
    }
    @RequestMapping("/del")
    public  Map del(@RequestBody Cars cars){
        Map<String,Object> map=new HashMap();
        // Integer carid=cars.getCarid();
        // System.out.println("carid="+carid);
        carTableService.del(cars);
        map.put("code",0);
        map.put("msg","删除成功");
        System.out.println("map:"+map);
        return map;
    }
    @GetMapping("/edit/{carid}")
    public Map edit(@PathVariable("carid")String carid){
        System.out.println("carid:"+carid);
        Map<String,Object> map =new HashMap<>();
        map.put("msg","跳转成功");
        map.put("url","/login/carEdit");
        return map;
    }
}
