package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Users;
import com.zhouwenbin.carsystem.service.ChooseCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/choosecar")
public class ChooseCarControl {
    @Autowired
    private ChooseCarService chooseCarService;
    @RequestMapping("/selectall")
    @ResponseBody
    public Map selectall(){
        Map<String,Object> map=new HashMap();
        List<Cars> carsList=chooseCarService.selectall();
        map.put("carlist",carsList);
        map.put("msg","查询全部车辆信息");
        return map;
    }
    @RequestMapping("/selectbytype")
    @ResponseBody
    public Map selectbytype(@RequestBody Cars cars){
        Map<String,Object> map=new HashMap();
        // System.out.println(cars.getCategory());
        List<Cars> carsList=chooseCarService.selectbytype(cars);
        map.put("carlist",carsList);
        map.put("msg","按类型查询车辆信息");
        return map;
    }
    @RequestMapping("/zulin")
    @ResponseBody
    public Map zulin(@RequestBody Cars cars, HttpServletRequest request){
        HttpSession session=request.getSession();//创建session对象
        Users user=(Users) session.getAttribute("user");//保存session信息
        Map<String,Object> map=new HashMap<>();
        if (user==null){
            map.put("page","login");
            return map;
        }else {
            map.put("page","zulinxiadan");
            map.put("carid",cars.getCarid());
            return map;
        }
    }

}
