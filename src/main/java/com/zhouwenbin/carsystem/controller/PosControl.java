package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Pos;
import com.zhouwenbin.carsystem.service.PosService;
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
@RequestMapping("/pos")
public class PosControl {
    @Autowired
    private PosService posService;
    @RequestMapping("/add")
    @ResponseBody
    public Map addpos(@RequestBody Pos pos){
    String posname=pos.getPosname();
    // System.out.println("posname:"+posname);
    Map<String,Object>map=new HashMap<>();
    map.put("code",200);
    map.put("posname",posname);
    map.put("msg","租赁点添加成功");
    posService.addpos(pos);
    return map;
    }
    @RequestMapping("/select")
    @ResponseBody
    public List<String> selectpos(){
        // List<String> result=new ArrayList<String>();
        List<String> posnamelist =posService.selectpos();
        // System.out.println("categorynamelist:"+categorynamelist);
        return posnamelist;
    }
    @RequestMapping("/select1")
    @ResponseBody
    public Map selectdata(@RequestBody Cars cars){
    List<Cars> posList=posService.selectdata(cars);
        // System.out.println("posList:"+posList);
        Map<String,Object> map=new HashMap();
        map.put("data",posList);
        map.put("status", 0);
        map.put("message", "");
        map.put("total", "");
        return map;
    }
    @RequestMapping("/select2")
    @ResponseBody
    public Map selectdata1(@RequestBody Cars cars){
        List<Cars> posList=posService.selectdata1(cars);
        // System.out.println("posList:"+posList);
        Map<String,Object> map=new HashMap();
        map.put("data",posList);
        map.put("status", 0);
        map.put("message", "");
        map.put("total", "");
        return map;
    }
    @RequestMapping("/match")
    @ResponseBody
    public Map matchcar(@RequestBody Cars cars){
        Map<String,Object> map=new HashMap<>();
        posService.updatepos(cars);
        map.put("msg","分配成功");
        map.put("code",0);
        return map;
    }
    @RequestMapping("/remove")
    @ResponseBody
    public Map removepos(@RequestBody Cars cars){
        Map<String,Object> map=new HashMap<>();
        posService.removepos(cars);
        posService.nullcar(cars);
        map.put("msg","删除租赁点成功");
        map.put("code",0);
        return map;
    }
    @RequestMapping("/null")
    @ResponseBody
    public Map nullcar(@RequestBody Cars cars){
        Map<String,Object> map=new HashMap<>();
        posService.nullcar1(cars);
        map.put("msg","删除车辆成功");
        map.put("code",0);
        return map;
    }
// 租赁点编辑车辆获取ID
    @RequestMapping("/poscarEdit")
    public String poscarEdit(Integer carId, Model model){
            // List<Cars> carList;
            // map.addAttribute("carList",carList);
            // System.out.println("carid:"+carId);
        List<Cars> carlists=posService.carinfo(carId);
            // System.out.println("carlists:"+carlists);
        model.addAttribute("carId",carId);
        model.addAttribute("carlists",carlists);
        // System.out.println("carlists"+carlists);
            return "poscarEdit";
    }
    @RequestMapping("/edit")
    @ResponseBody
    public Map editcar(@RequestBody Cars cars){
        Map<String,Object> map=new HashMap<>();
        posService.update(cars);
        // posService.nullcar1(cars);
        // map.put("msg","删除车辆成功");
        map.put("code",0);
        return map;
    }
}
