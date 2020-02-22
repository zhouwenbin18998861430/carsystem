package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.service.OtherManageService;
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
@RequestMapping("/other")
public class OtherManageControl {
    @Autowired
    private OtherManageService otherManageService;
    @RequestMapping("/selecterrorcar")
    @ResponseBody
    public Map selectdata1(){
        List<Cars> errorcarlist=otherManageService.selecterrorcar();
        // System.out.println("posList:"+posList);
        Map<String,Object> map=new HashMap();
        map.put("data",errorcarlist);
        map.put("status", 0);
        map.put("message", "");
        map.put("total", "");
        return map;
    }
    // 例外拼接跳转
    @RequestMapping("/djerror")
    public String djerror(Integer carid, Model model){
        List<Cars> carlists=otherManageService.carinfo(carid);
        // System.out.println("carlists:"+carlists);
        model.addAttribute("carid",carid);
        model.addAttribute("carlists",carlists);
        // System.out.println("carlists"+carlists);
        return "djerror";
    }
    @RequestMapping("/djerrormsg")
    @ResponseBody
    public Map djerrormsg(@RequestBody Cars cars){
        System.out.println("Errormsg:"+cars.getErrormsg());
        System.out.println("carid:"+cars.getCarid());
        otherManageService.errorCardj(cars);
        // System.out.println("posList:"+posList);
        Map<String,Object> map=new HashMap();
        map.put("msg","登记成功");
        return map;
    }
}
