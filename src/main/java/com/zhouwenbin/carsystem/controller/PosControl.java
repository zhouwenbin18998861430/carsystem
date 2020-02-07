package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Pos;
import com.zhouwenbin.carsystem.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/pos")
public class PosControl {
    @Autowired
    private PosService posService;
@PostMapping("/add")
    public Map addpos(@RequestBody Pos pos){
    String posname=pos.getPosname();
    // System.out.println("posname:"+posname);
    Map<String,Object>map=new HashMap<>();
    map.put("code",200);
    map.put("posname",posname);
    posService.addpos(pos);
    return map;
    }
}
