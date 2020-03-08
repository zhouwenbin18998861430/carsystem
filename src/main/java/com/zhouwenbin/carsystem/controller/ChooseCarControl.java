package com.zhouwenbin.carsystem.controller;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Dingdan;
import com.zhouwenbin.carsystem.entity.Users;
import com.zhouwenbin.carsystem.service.ChooseCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/choosecar")
@EnableAutoConfiguration
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
    @RequestMapping("carinfo")
    @ResponseBody
    public Map carinfo(@RequestBody Cars cars){
        Integer carid=cars.getCarid();
        List<Cars> carsList=chooseCarService.carinfo(carid);
        Map<String,Object> map=new HashMap<>();
        map.put("carsList",carsList);
        return map;
    }
    @RequestMapping("/xiadan")
    @ResponseBody
    public Map xiadan(@RequestBody Cars cars,HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        response.setContentType("text/html;charset=utf-8");//解决乱码
        HttpSession session = request.getSession();//创建session对象
        Users user = (Users) session.getAttribute("user");//保存session信息
        if (user == null) {
            map.put("page", "login");
            map.put("msg","尚未登录");
        } else {
            String account = user.getAccount();
            // 根据userid查询余额
            Integer yue = chooseCarService.yecx(account);
            Integer carcost = cars.getPrice() + cars.getYaprice();
            if (yue >= carcost) {
                // 写入订单表，并对账户余额进行扣除
                Integer money=yue-carcost;//计算余额
                Users user1=new Users();
                user1.setMoney(money);
                user1.setAccount(account);
                chooseCarService.updateyue(user1);//更新金额
                Integer carid=cars.getCarid();
                chooseCarService.updatecarstate(carid);//修改车辆状态
                //写入订单表
                Dingdan dingdan=new Dingdan();
                dingdan.setAccount(account);
                dingdan.setCarid(carid);
                dingdan.setCategory(cars.getCategory());
                String username=chooseCarService.lookusersinfo(account);
                dingdan.setName(username);//根据账号查客户信息
                dingdan.setYaprice(cars.getYaprice());
                dingdan.setPrice(cars.getPrice());
                dingdan.setPinpai(cars.getPinpai());
                dingdan.setSize(cars.getSize());
                dingdan.setPos(cars.getPos());
                chooseCarService.insertdingdan(dingdan);
                map.put("msg", "租赁成功,剩余金额:"+money);
                map.put("account",account);
                map.put("page", "perdingdan");
            } else {
                map.put("msg", "余额不足，请充值");
                map.put("account",account);
                map.put("page", "charge");
            }
        }
        return map;
    }
    //根据订单号查信息
    @RequestMapping("/checkstate")
    @ResponseBody
    public Map checkstate(@RequestBody Dingdan dingdan){
        Integer ddid=dingdan.getDdid();
        List<Dingdan> dingdanList=chooseCarService.selectdingdanbyid(ddid);
        Map<String,Object> map=new HashMap();
        map.put("dingdanList",dingdanList);
        return map;
    }
    //完成订单，修改车辆状态，修改订单状态,归还押金
    @RequestMapping("/finish")
    @ResponseBody
    public Map finish(@RequestBody Dingdan dingdan){
        Integer yaprice=dingdan.getYaprice();
        Map<String,Object> map=new HashMap();
        Integer carid=dingdan.getCarid();
        Integer nowmoney=chooseCarService.yecx(dingdan.getAccount());//查询账户现有余额
        Integer money=nowmoney+yaprice;
        chooseCarService.updatecarstate1(carid);//修改车辆状态
        chooseCarService.updatedingdan(dingdan);//修改订单状态为已完成
        Users users=new Users();
        users.setAccount(dingdan.getAccount());
        users.setMoney(money);
        chooseCarService.returnmoney(users);//归还押金
        map.put("msg","完成订单成功");
        return map;
    }
    //取消订单，修改车辆状态，删除订单，归还全部金额
    @RequestMapping("/qx")
    @ResponseBody
    public Map qx(@RequestBody Dingdan dingdan){
        Map<String, Object> map = new HashMap();
        if (dingdan.getState().equals("待使用")) {
            Integer price = dingdan.getPrice() + dingdan.getYaprice();
            System.out.println("全款=" + price);
            Integer carid = dingdan.getCarid();
            Integer nowmoney = chooseCarService.yecx(dingdan.getAccount());//查询账户现有余额
            Integer money = nowmoney + price;
            chooseCarService.updatecarstate1(carid);//修改车辆状态
            chooseCarService.removedingdan(dingdan);//删除订单信息
            Users users = new Users();
            users.setAccount(dingdan.getAccount());
            users.setMoney(money);
            chooseCarService.returnmoney(users);//归还全款
            map.put("msg", "取消订单成功");
        }else {
            map.put("msg","该订单无法取消");
        }
        return map;
    }

}
