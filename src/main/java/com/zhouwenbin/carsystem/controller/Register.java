package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Users;
import com.zhouwenbin.carsystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Register {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    //普通用户注册
    @PostMapping("/registercheck")
    public String addUser(Users users) {
        try {

            int account = usersService.addUser(users);
            if (account > 0) {

                return "success";
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return "register";
    }
}
