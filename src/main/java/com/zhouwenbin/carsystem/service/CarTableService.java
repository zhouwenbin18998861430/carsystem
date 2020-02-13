package com.zhouwenbin.carsystem.service;

import com.zhouwenbin.carsystem.entity.Cars;

import java.util.List;

public interface CarTableService {
    List<Cars> selectList(Cars cars);
}
