package com.zhouwenbin.carsystem.service;

import com.zhouwenbin.carsystem.entity.Cars;

import java.util.List;

public interface ChooseCarService {
    List<Cars> selectbytype();//根据所选类型进行查表
}
