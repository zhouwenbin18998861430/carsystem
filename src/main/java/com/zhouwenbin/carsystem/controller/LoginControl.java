package com.zhouwenbin.carsystem.controller;


import com.zhouwenbin.carsystem.entity.Users;
import com.zhouwenbin.carsystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/login")
public class LoginControl extends HttpServlet {
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
    // @GetMapping
    // public ModelAndView login(Model model) {
    //     Users users = new Users();
    //     model.addAttribute("users", users);
    //     ModelAndView modelAndView = new ModelAndView("login", "userModel", model);
    //     return modelAndView;
    // }

    @PostMapping("/submit")
    public String login( Model model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();//创建session对象
        Users user=(Users) session.getAttribute("user");//保存session信息
        if (user!=null){
            System.out.println("该用户已经登录");
        }
        // System.out.println("该用户尚未登录");
        String account = request.getParameter("account");
        // System.out.println("输入的用户：" + account);
        String password = request.getParameter("password");
        // System.out.println("输入的密码：" + password);
        String password1 = usersService.findPwd(account);
        // System.out.println("查询的密码：" + password1);
        Integer grade = usersService.selectGrade(account);
        // System.out.println("权限等级为:"+grade);
        if (password.length() == 0) {
            model.addAttribute("msg", "请先输入用户名或密码");
            return "/login";//没有输入密码
        } else if (password.equals(password1)) {
            // System.out.println("grade:" + grade);
            response.setContentType("text/html;charset=utf-8");//解决乱码
            Users users = new Users();
            users.setAccount(account);
            users.setPassword(password1);
            // HttpSession session = request.getSession();
            switch (grade) {
                case 1:
//        权限为1是管理员
//                     model.addAttribute("accountinfo", users);
                    session.setAttribute("user", users);//创建session保存对象
                    // HttpSession session=request.getSession();//创建session保存信息
//        ModelAndView modelAndView=new ModelAndView("index","usersModel",users);
                    return "redirect:/index1";
                case 2:
//        权限为2是租赁点管理员
//                     model.addAttribute("accountinfo", users);
                    session.setAttribute("user", users);//创建session保存对象
//        ModelAndView modelAndView=new ModelAndView("index","usersModel",users);
                    return "redirect:/index2";
                case 3:
//        权限为3是普通用户
//                     model.addAttribute("accountinfo", users);
                    session.setAttribute("user", users);//创建session保存对象
//        ModelAndView modelAndView=new ModelAndView("index","usersModel",users);
                    return "redirect:/index";
            }
        } else
            model.addAttribute("msg", "用户名或密码错误 ");
        return "redirect:/login";//密码错了

    }

    //============================================================================
// 注册功能
    @RequestMapping("/registeraccount")
    @ResponseBody
    public Map registeraccount(@RequestBody Users users){
        Map<String,Object> map=new HashMap();
        String account=users.getAccount();
        // String account1=
        // try {
            List<Users> userlist=usersService.haveaccount(account);
            // System.out.println("userlist"+userlist);
            if (null == userlist || userlist.size() ==0){
                int account1=usersService.addUser(users);
                map.put("msg",account+"注册成功");
            }else {
                map.put("msg","该账号已经存在");
            }
        return map;
    }
//==============================================================================

//==============================================================================
    @RequestMapping("/forgetpwd")
    @ResponseBody
    public Map forgetpwd(@RequestBody Users users){
        Map<String,Object> map=new HashMap();
        String account=users.getAccount();
        // System.out.println("account:"+account);
        Integer age=users.getAge();
        Integer phone=users.getPhone();
        String name=users.getName();
        String password=users.getPassword();
        List<Users> userlist=usersService.haveaccount(account);
        // System.out.println("dataaccount:"+userlist.get(0).getAccount());
        // System.out.println("1:"+account.equals(userlist.get(0).getAccount()));
        // System.out.println("2:"+age.equals(userlist.get(0).getAge()));
        // System.out.println("3:"+phone==userlist.get(0).getPhone());
        // System.out.println("4:"+name==userlist.get(0).getName());
        if (account.equals(userlist.get(0).getAccount())&&age.equals(userlist.get(0).getAge())&&phone.equals(userlist.get(0).getPhone())&&name.equals(userlist.get(0).getName())){
            usersService.forgetpwd(users);
            map.put("msg","新密码为："+password+",请牢记您的新密码");
        }else {
            System.out.println("失败了");
            map.put("msg","请核对所需信息项后重试");
        }
        return map;
    }
}
