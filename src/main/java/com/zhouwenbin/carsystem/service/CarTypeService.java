package com.zhouwenbin.carsystem.service;

import com.zhouwenbin.carsystem.entity.CarType;

import java.util.List;

public interface CarTypeService {
    // 抽象方法
    Integer addtype(CarType carType);
    List<String> selecttype();
}
