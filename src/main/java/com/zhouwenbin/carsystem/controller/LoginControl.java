package com.zhouwenbin.carsystem.controller;


import com.zhouwenbin.carsystem.entity.Users;
import com.zhouwenbin.carsystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login")
public class LoginControl {
    //    写控制方法
    @Autowired
    private UsersService usersService;


    //页面跳转
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        return page;
    }
//==============================================================================
    //登录校验
    @GetMapping
    public ModelAndView login(Model model) {
        Users users = new Users();
        model.addAttribute("users", users);
        ModelAndView modelAndView = new ModelAndView("login", "userModel", model);
        return modelAndView;
    }

    @PostMapping("/submit")
    public String login(@ModelAttribute(value = "users") Users users, Model model) {
        Integer loginType = users.getGrade();
        String account = users.getAccount();
        System.out.println("输入的用户：" + account);
        String password = users.getPassword();
        System.out.println("输入的密码：" + password);
        String password1 = usersService.findPwd(account);
        System.out.println("查询的密码：" + password1);
        Integer grade = usersService.selectGrade(account);
        if (password == null) {
            model.addAttribute("msg","请先输入用户名或密码");
            return "login";//没有输入密码
        }
        if (password.equals(password1)) {
            System.out.println("grade:" + grade);
            switch (grade) {
                case 1:
//        权限为1是管理员
                    model.addAttribute("accountinfo", users);
//        ModelAndView modelAndView=new ModelAndView("index","usersModel",users);
                    return "index1";
                case 2:
//        权限为2是租赁点管理员
                    model.addAttribute("accountinfo", users);
//        ModelAndView modelAndView=new ModelAndView("index","usersModel",users);
                    return "index2";
                case 3:
//        权限为3是普通用户
                    model.addAttribute("accountinfo", users);
//        ModelAndView modelAndView=new ModelAndView("index","usersModel",users);
                    return "index3";
            }
        }
        model.addAttribute("msg", "用户名或密码错误 ");
        return "login";//密码错了
    }

    //============================================================================

//==============================================================================

}
