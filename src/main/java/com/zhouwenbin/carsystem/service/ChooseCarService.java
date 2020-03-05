package com.zhouwenbin.carsystem.service;

import com.zhouwenbin.carsystem.entity.Cars;

import java.util.List;

public interface ChooseCarService {
    List<Cars> selectbytype(Cars cars);//根据所选类型进行查表
    List<Cars> selectall();//查询全部车辆
}
