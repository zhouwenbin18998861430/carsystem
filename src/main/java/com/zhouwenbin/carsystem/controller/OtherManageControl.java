package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.BaofeiCars;
import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Users;
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
    // 查询问题车辆信息
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
    @RequestMapping("/selecterrorcarhavemsg")
    @ResponseBody
    // 查询问题车辆信息(errormsg不为)
    public Map selectdata2(){
        List<Cars> errorcarlist=otherManageService.selecterrorcarhavemsg();
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
    // 登记损坏信息
    @RequestMapping("/djerrormsg")
    @ResponseBody
    public Map djerrormsg(@RequestBody Cars cars){
        otherManageService.errorCardj(cars);
        // System.out.println("posList:"+posList);
        Map<String,Object> map=new HashMap();
        map.put("msg","登记成功");
        return map;
    }
    // 移除误操作
    @RequestMapping("/removeerrorcar")
    @ResponseBody
    public Map removeerrorcar(@RequestBody Cars cars){
        otherManageService.removeerrorcar(cars);
        Map<String,Object> map=new HashMap();
        map.put("msg","删除成功");
        return map;
    }
    //报废车辆
    @RequestMapping("/baofeierrorcar")
    @ResponseBody
    public Map baofeierrorcar(@RequestBody Cars cars, BaofeiCars baofeiCars){
        //改状态
        otherManageService.yibaofei(cars);
        List<Cars> carsList= otherManageService.carinfo(cars.getCarid());
        Integer carid=carsList.get(0).getCarid();
        String category=carsList.get(0).getCategory();
        String carnum=carsList.get(0).getCarNum();
        String fixed=carsList.get(0).getFixed();
        String state=carsList.get(0).getState();
        String photolocation=carsList.get(0).getPhotolocation();
        String errormsg=carsList.get(0).getErrormsg();
        String pos=carsList.get(0).getPos();
        Integer price=carsList.get(0).getPrice();
        Integer size=carsList.get(0).getSize();
        String pinpai=carsList.get(0).getPinpai();
        Integer yaprice=carsList.get(0).getYaprice();
        baofeiCars.setCarid(carid);
        baofeiCars.setFixed(fixed);
        baofeiCars.setErrormsg(errormsg);
        baofeiCars.setPos(pos);
        baofeiCars.setCategory(category);
        baofeiCars.setPrice(price);
        baofeiCars.setSize(size);
        baofeiCars.setPhotolocation(photolocation);
        baofeiCars.setCarnum(carnum);
        baofeiCars.setPinpai(pinpai);
        baofeiCars.setYaprice(yaprice);
        otherManageService.baofei(baofeiCars);
        Map<String,Object> map=new HashMap();
        map.put("msg","车辆报废成功");
        return map;
    }
    //修理操作
    @RequestMapping("/fixed")
    @ResponseBody
    public Map fixed(@RequestBody Cars cars){
        // System.out.println("carid:"+cars.getCarid());
        Map<String,Object> map=new HashMap();
        otherManageService.fixed(cars);
        map.put("msg","车辆已维修完成");
        return map;
    }
    // 获取用户信息
    @RequestMapping("/userinfo")
    @ResponseBody
    public Map userSelect(){
        Map<String,Object> map=new HashMap();
        List<Users> userslist=otherManageService.selectusersinfo();
        map.put("data",userslist);
        map.put("status", 0);
        map.put("message", "");
        map.put("total", "");
        return map;
    }
    // 删除用户
    @RequestMapping("/deluserinfo")
    @ResponseBody
    public Map deluserinfo(@RequestBody Users users){
        Map<String,Object> map=new HashMap();
        otherManageService.deluser(users);
        map.put("msg","删除成功");
        return map;
    }
    // 传递用户信息编辑界面
    @RequestMapping("/edituser")
    public String edituser(String account, Model model){
        List<Users> userlists=otherManageService.selectusersbyid(account);
        model.addAttribute("account",account);
        model.addAttribute("userlists",userlists);
        return "edituser";
    }

    // 修改用户信息
    @RequestMapping("/edituserinfo")
    @ResponseBody
    public Map edituserinfo(@RequestBody Users users){
        Map<String,Object> map=new HashMap();
        otherManageService.edituserinfo(users);
        map.put("msg","用户信息修改成功");
        return map;
    }
}
