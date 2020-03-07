package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Users;
import com.zhouwenbin.carsystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/xiugaimyinfo")
public class UserinfoControl {
    @Autowired
    private UsersService usersService;
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
}
