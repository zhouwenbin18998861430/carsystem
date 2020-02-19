package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Pos;
import com.zhouwenbin.carsystem.entity.Poser;
import com.zhouwenbin.carsystem.service.PoserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/poser")
public class PoserControl {
    @Autowired
    private PoserService poserService;
    @RequestMapping("/select")
    @ResponseBody
    public Map selectPoser(@RequestBody Pos pos){
        List<Poser> selectposer=poserService.selectPoser(pos);
        // System.out.println("selectposer:"+selectposer);
        Map<String,Object> map=new HashMap();
        map.put("data",selectposer);
        map.put("status", 0);
        map.put("message", "");
        map.put("total", "");
        return map;
    }
    @RequestMapping("/del")
    @ResponseBody
    public  Map del(@RequestBody Poser poser){
        System.out.println("poserid:"+poser.getPoserid());
        Map<String,Object> map=new HashMap();
        // Integer carid=cars.getCarid();
        // System.out.println("carid="+carid);
        poserService.del(poser);
        map.put("code",0);
        map.put("msg","删除成功");
        // System.out.println("map:"+map);
        return map;
    }
    @RequestMapping("/add")
    @ResponseBody
    public Map add(@RequestBody Poser poser){
        String posname=poser.getPosername();
        System.out.println("posname:"+posname);
        Map<String,Object> map=new HashMap();
        poserService.add(poser);
        map.put("posname",posname);
        map.put("code",0);
        map.put("msg","添加成功");
        return map;
    }
}
