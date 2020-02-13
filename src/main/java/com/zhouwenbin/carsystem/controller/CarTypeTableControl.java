package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.service.CarTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/table")
public class CarTypeTableControl {
    @Autowired
    private CarTableService carTableService;
    @PostMapping("/select")
    public Map selectTable(@RequestBody Cars cars){
        //--------------
        String a=cars.getCategory();
        System.out.println("category:"+a);
        //--------------
        List<Cars> selectlist=carTableService.selectList(cars);

        Map<String,Object> map=new HashMap();
        map.put("list",selectlist);
        map.put("code",200);
        System.out.println("打印："+selectlist.toString());
        return map;
    }
}
