package com.zhouwenbin.carsystem.dao;

import com.zhouwenbin.carsystem.entity.Cars;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarsMapper {
    // 书写操作car对象的方法接口
    Integer registerCar(Cars cars);

}
