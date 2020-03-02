package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class PageControl extends HttpServlet {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        return page;
    }
    // @RequestMapping("/index1")
    // public String index1(HttpServletRequest request, HttpServletResponse response,Model model) {
    //     response.setContentType("text/html;charset=utf-8");//解决乱码
    //     HttpSession session=request.getSession();//创建session对象
    //     Users user=(Users) session.getAttribute("user");//保存session信息
    //     if (user==null){
    //         System.out.println("你还未登陆");
    //         return "redirect:/login";
    //     }else {
    //         System.out.println("已登陆");
    //         model.addAttribute("user",user);
    //         // //创建Cookie对象用来保存Session的id
    //         // Cookie cookie=new Cookie("JSESSIONID",session.getId());
    //         // cookie.setMaxAge(30*60);
    //         // cookie.setPath("/Project01");
    //         // response.addCookie(cookie);
    //         // model.addAttribute("user",user);
    //     }
    //     return "index1";
    // }
    // @RequestMapping("/index2")
    // public String index2(HttpServletRequest request, HttpServletResponse response,Model model) {
    //     response.setContentType("text/html;charset=utf-8");//解决乱码
    //     HttpSession session=request.getSession();//创建session对象
    //     Users user=(Users) session.getAttribute("user");//保存session信息
    //     if (user==null){
    //         System.out.println("你还未登陆");
    //         return "redirect:/login";
    //     }else {
    //         System.out.println("已登陆");
    //         model.addAttribute("user",user);
    //         // //创建Cookie对象用来保存Session的id
    //         // Cookie cookie=new Cookie("JSESSIONID",session.getId());
    //         // cookie.setMaxAge(30*60);
    //         // cookie.setPath("/Project02");
    //         // response.addCookie(cookie);
    //         // model.addAttribute("user",user);
    //     }
    //     return "index2";
    // }
    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        response.setContentType("text/html;charset=utf-8");//解决乱码
        HttpSession session=request.getSession();//创建session对象
        Users user=(Users) session.getAttribute("user");//保存session信息
        if (user==null){
            System.out.println("你还未登陆");
            model.addAttribute("msg", "你尚未登录");
            // return "redirect:/login";
        }else {
            System.out.println("已登陆");
            model.addAttribute("user",user);
            // System.out.println("user1"+user);
            // //创建Cookie对象用来保存Session的id
            // Cookie cookie=new Cookie("JSESSIONID",session.getId());
            // cookie.setMaxAge(30*60);
            // cookie.setPath("/Project0");
            // response.addCookie(cookie);
            // model.addAttribute("user",user);
        }
        return "index";
    }
}
