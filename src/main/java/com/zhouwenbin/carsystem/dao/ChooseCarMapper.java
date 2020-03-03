package com.zhouwenbin.carsystem.dao;

import com.zhouwenbin.carsystem.entity.Cars;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChooseCarMapper {
    List<Cars> selectbytype();//根据所选类型进行查表
}
