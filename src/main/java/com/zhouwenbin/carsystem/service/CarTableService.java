package com.zhouwenbin.carsystem.service;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Dingdan;

import java.util.List;

public interface CarTableService {
    List<Cars> selectList(Cars cars);
    Boolean del(Cars cars);
    List<Cars> carinfo(Integer carId);
    Boolean update(Cars cars);
    List<Dingdan> selectdingdan();//查询订单
}
