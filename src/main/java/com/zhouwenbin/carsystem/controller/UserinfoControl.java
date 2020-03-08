package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Dingdan;
import com.zhouwenbin.carsystem.entity.Users;
import com.zhouwenbin.carsystem.service.ChooseCarService;
import com.zhouwenbin.carsystem.service.OtherManageService;
import com.zhouwenbin.carsystem.service.UsersService;
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
@RequestMapping("/xiugaimyinfo")
@EnableAutoConfiguration
public class UserinfoControl {
    @Autowired
    private UsersService usersService;
    @Autowired
    private ChooseCarService chooseCarService;
    @Autowired
    private OtherManageService otherManageService;
    // 修改账户信息
    @RequestMapping("/updateinfo")
    @ResponseBody
    public Map updateinfo(@RequestBody Users users){
        usersService.xiugaiinfo(users);
        Map<String,Object> map=new HashMap<>();
        map.put("msg","修改成功");
        return map;
    }
    @RequestMapping("/checkmyinfo")
    @ResponseBody
    public Map checkmyinfo(@RequestBody Users users){
        String account=users.getAccount();
        List<Users> usersList= usersService.haveaccount(account);
        Map<String,Object> map=new HashMap<>();
        map.put("msg","查询成功返回");
        map.put("usersList",usersList);
        return map;
    }
    @RequestMapping("/lookdingdan")
    @ResponseBody
    public Map lookdingdan(@RequestBody Dingdan dingdan){
        Map<String,Object> map=new HashMap<>();
        return map;
    }
    @RequestMapping("/dingdanxinxi")
    @ResponseBody
    public Map dingdanxinxi(@RequestBody Dingdan dingdan){
        Map<String,Object> map=new HashMap<>();
        List<Dingdan> dingdanList=chooseCarService.selectdingdan(dingdan);
        map.put("dingdanList",dingdanList);
        map.put("msg","查询成功返回");
        return map;
    }
    // 跳转充值界面
    @RequestMapping("/usercharge")
    public String edituser(String account, Model model){
        List<Users> userlists=otherManageService.selectusersbyid(account);
        model.addAttribute("account",account);
        model.addAttribute("userlists",userlists);
        return "usercharge";
    }
    @RequestMapping("/moneycharge")
    @ResponseBody
    public Map moneycharge(@RequestBody Users users){
        System.out.println("account="+users.getAccount());
        System.out.println("需要充值="+users.getMoney());
        Integer yecx=chooseCarService.yecx(users.getAccount());
        System.out.println("账户现有="+yecx);
        Integer money=yecx+users.getMoney();
        System.out.println("充值后="+money);
        Users users1=new Users();
        users1.setAccount(users.getAccount());
        users1.setMoney(money);
        usersService.charge(users1);
        Map<String,Object> map=new HashMap<>();
        map.put("msg","充值成功");
        return map;
    }
}
