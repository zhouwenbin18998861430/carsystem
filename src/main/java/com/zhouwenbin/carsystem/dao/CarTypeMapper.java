package com.zhouwenbin.carsystem.dao;

import com.zhouwenbin.carsystem.entity.CarType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarTypeMapper {
    // 抽象方法
    Integer addtype(CarType carType);

    List<String> selecttype();
}
