package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Users;
import com.zhouwenbin.carsystem.service.PosAdminService;
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
@RequestMapping("/posAdmin")
public class PosAdminControl {
    @Autowired
    private PosAdminService posAdminService;
    //查询当前租赁点的所有车辆信息
    @RequestMapping("/selectposcar")
    @ResponseBody
    public Map selectposcar(@RequestBody Users users) {
        Map<String, Object> map = new HashMap();
        String account=users.getAccount();
        String name=posAdminService.checkname(account);
        String pos=posAdminService.checkpos(name);
        List<Cars> carsList=posAdminService.selectposcar(pos);
        map.put("data", carsList);
        map.put("status", 0);
        map.put("message", "");
        map.put("total", "");
        return map;
    }
    //查询当前租赁点正常的所有车辆信息
    @RequestMapping("/selectposcar1")
    @ResponseBody
    public Map selectposcar1(@RequestBody Users users) {
        Map<String, Object> map = new HashMap();
        String account=users.getAccount();
        String name=posAdminService.checkname(account);
        String pos=posAdminService.checkpos(name);
        List<Cars> carsList=posAdminService.selectposcar1(pos);
        map.put("data", carsList);
        map.put("status", 0);
        map.put("message", "");
        map.put("total", "");
        return map;
    }
    //车辆租出登记
    @RequestMapping("/djborrow")
    public String djborrow(Integer carid, Model model){
        List<Cars> carlists=posAdminService.selectcarinfo(carid);
        // model.addAttribute("account",account);
        // System.out.println("carlist:"+carlists);
        model.addAttribute("carlists",carlists);
        return "djborrow";
    }
    //更新借出信息
    @RequestMapping("djjiechu")
    @ResponseBody
    public Map djjiechu(@RequestBody Cars cars ){
        Map<String, Object> map = new HashMap();
        posAdminService.djjiechu(cars);
        map.put("msg","借出登记成功");
        return map;
    }
    //查询当前租赁点已借出的所有车辆信息
    @RequestMapping("/selectposcar2")
    @ResponseBody
    public Map selectposcar2(@RequestBody Users users) {
        Map<String, Object> map = new HashMap();
        String account=users.getAccount();
        String name=posAdminService.checkname(account);
        String pos=posAdminService.checkpos(name);
        List<Cars> carsList=posAdminService.selectposcar2(pos);
        // System.out.println("carList:"+carsList);
        map.put("data", carsList);
        map.put("status", 0);
        map.put("message", "");
        map.put("total", "");
        return map;
    }
    //返回归还面板信息
    @RequestMapping("/djreturn")
    public String djreturn(Integer carid, Model model){
        List<Cars> carlists=posAdminService.selectcarinfo(carid);
        // model.addAttribute("account",account);
        // System.out.println("carlist:"+carlists);
        model.addAttribute("carlists",carlists);
        // System.out.println("carlists"+carlists);
        return "djreturn";
    }
    //更新归还信息
    @RequestMapping("djguihuan")
    @ResponseBody
    public Map djguihuan(@RequestBody Cars cars ){
        Map<String, Object> map = new HashMap();
        posAdminService.djjiechu(cars);
        map.put("msg","归还登记成功");
        return map;
    }
}
