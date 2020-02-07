package com.zhouwenbin.carsystem.dao;

import com.zhouwenbin.carsystem.entity.CarType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarTypeMapper {
    // 抽象方法
    Integer addtype(CarType carType);

    String selecttype(CarType carType);
}
