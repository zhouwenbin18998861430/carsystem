package com.zhouwenbin.carsystem.service;

import com.zhouwenbin.carsystem.entity.BaofeiCars;
import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Users;

import java.util.List;

public interface OtherManageService {
    //查询state为问题车辆
    List<Cars> selecterrorcar();
    //查询errormsg不为空的问题车辆
    List<Cars> selecterrorcarhavemsg();
    //根据carid获取carinfo
    List<Cars> carinfo(Integer carid);
    //车辆维修
    Boolean fixed(Cars cars);
    // 车辆问题登记
    Boolean errorCardj(Cars cars);
    // 车辆报废
    Boolean baofei(BaofeiCars baofeiCars);
    //改变fixed为已报废
    Boolean yibaofei(Cars cars);
    // 分类统计车辆数量
    Integer sumcarbycategory(String category);
    // 查询客户信息
    List<Users> selectusersinfo();
    //查询客户byID
    List<Users> selectusersbyid(String account);
    //修改用户信息
    Boolean edituserinfo(Users users);
    //删除用户
    Boolean deluser(Users users);
    // 查询订单信息

    //使车辆变回正常
    Boolean removeerrorcar(Cars cars);

}
