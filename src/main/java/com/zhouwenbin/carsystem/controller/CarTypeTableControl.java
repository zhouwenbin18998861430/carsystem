package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Dingdan;
import com.zhouwenbin.carsystem.service.CarTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/table")
@EnableAutoConfiguration
public class CarTypeTableControl {
    @Autowired
    private CarTableService carTableService;
    @RequestMapping("/select")
    @ResponseBody
    public Map selectTable(@RequestBody Cars cars){
        //--------------
        String a=cars.getCategory();
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
    @ResponseBody
    public  Map del(@RequestBody Cars cars){
        Map<String,Object> map=new HashMap();
        // Integer carid=cars.getCarid();
        // System.out.println("carid="+carid);
        carTableService.del(cars);
        map.put("code",0);
        map.put("msg","删除成功");
        // System.out.println("map:"+map);
        return map;
    }
    @RequestMapping("/edit")
    @ResponseBody
    public Map edit(@RequestBody Cars cars){
        Map<String,Object> map =new HashMap<>();
        carTableService.update(cars);
        map.put("msg","更新成功成功");
        map.put("code",0);
        return map;
    }

    //获取车辆id
    @RequestMapping("/carEdit")
    public String carEdit(Integer carId, Model model){
        // List<Cars> carList;
        // map.addAttribute("carList",carList);
        // System.out.println("carid:"+carId);
        List<Cars> carlists=carTableService.carinfo(carId);
        // System.out.println(carlists);
        // System.out.println("carlists:"+carlists);
        model.addAttribute("carId",carId);
        model.addAttribute("carlists",carlists);
        return "carEdit";
    }
    //获取客户订单信息
    @RequestMapping("/dingdaninfo")
    @ResponseBody
    public Map userdingdanSelect(){
        Map<String,Object> map=new HashMap();
        // List<Users> userslist=otherManageService.selectusersinfo();
        List<Dingdan> dingdanList=carTableService.selectdingdan();
        map.put("data",dingdanList);
        map.put("status", 0);
        map.put("message", "");
        map.put("total", "");
        return map;
    }
}
