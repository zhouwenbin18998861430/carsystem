package com.zhouwenbin.carsystem.dao;

import com.zhouwenbin.carsystem.entity.Cars;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarTableMapper {
    List<Cars> selectList(Cars cars);
}