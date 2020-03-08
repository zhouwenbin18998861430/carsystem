package com.zhouwenbin.carsystem.service;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Dingdan;
import com.zhouwenbin.carsystem.entity.Users;

import java.util.List;

public interface ChooseCarService {
    List<Cars> selectbytype(Cars cars);//根据所选类型进行查表
    List<Cars> selectall();//查询全部车辆
    List<Cars> carinfo(Integer carId);//根据ID查车辆信息
    Integer yecx(String account);//余额查询
    Boolean updateyue(Users users);//更新余额
    Boolean updatecarstate(Integer carid);//修改车辆状态改为借出
    Boolean updatecarstate1(Integer carid);//修改车辆状态改为正常
    String lookusersinfo(String account);//根据账号查用户名
    Boolean insertdingdan(Dingdan dingdan);//将数据写入订单表
    List<Dingdan> selectdingdan(Dingdan dingdan);//根据用户查询订单信息
    Boolean updatedingdan(Dingdan dingdan);//更新订单信息
    Boolean removedingdan(Dingdan dingdan);//移除订单信息
    Boolean returnmoney(Users users);//退还金额
    List<Dingdan>  selectdingdanbyid(Integer ddid);//根据订单ID查询订单信息
}
