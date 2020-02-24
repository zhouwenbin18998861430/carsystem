package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Pos;
import com.zhouwenbin.carsystem.entity.Poser;
import com.zhouwenbin.carsystem.service.PoserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        // System.out.println("posname:"+pos.getPosname());
        List<Poser> selectposer=poserService.selectPoser(pos);
        Map<String,Object> map=new HashMap();
        map.put("data",selectposer);
        map.put("status", 0);
        map.put("message", "");
        map.put("total", "");
        // System.out.println("selectposer:"+selectposer);
        return map;
    }
    @RequestMapping("/del")
    @ResponseBody
    public  Map del(@RequestBody Poser poser){
        // System.out.println("poserid:"+poser.getPoserid());
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
        // System.out.println("posname:"+posname);
        Map<String,Object> map=new HashMap();
        poserService.add(poser);
        map.put("posname",posname);
        map.put("code",0);
        map.put("msg","添加成功");
        return map;
    }
    @RequestMapping("/poserEdit")
    public String carEdit(Integer poserid, Model model){
        // List<Cars> carList;
        // map.addAttribute("carList",carList);
        // System.out.println("carid:"+carId);
        List<Poser> poserList=poserService.poserinfo(poserid);
        // System.out.println("carlists:"+carlists);
        model.addAttribute("poserid",poserid);
        model.addAttribute("poserlists",poserList);
        return "poserEdit";
    }
    @RequestMapping("/save")
    @ResponseBody
    public Map saveinfo(@RequestBody Poser poser){
        Map<String,Object> map =new HashMap<>();
        poserService.saveinfo(poser);
        map.put("msg","更新成功成功");
        map.put("code",0);
        return map;
    }
    //查询未分配的管理员
    @RequestMapping("/selectposer")
    @ResponseBody
    public Map selectposer(){
        Map<String,Object> map =new HashMap<>();
        // poserService.saveinfo(poser);
        List<Poser> poserList =poserService.poserinfo2();
        map.put("data",poserList);
        map.put("status", 0);
        map.put("message", "");
        map.put("total", "");
        return map;
    }
    //分配租赁点管理员
    @RequestMapping("/match")
    @ResponseBody
    public Map match(@RequestBody Poser poser){
        Map<String,Object> map =new HashMap<>();
        // poserService.saveinfo(poser);
        poserService.match(poser);
        map.put("msg", "分配成功");
        return map;
    }
}
