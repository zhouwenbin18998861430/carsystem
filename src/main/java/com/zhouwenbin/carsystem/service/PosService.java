package com.zhouwenbin.carsystem.service;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Pos;

import java.util.List;

public interface PosService {
    //添加租赁点
    Boolean addpos(Pos pos);
    List<String> selectpos();
    List<Cars> selectdata(Cars cars);
    List<Cars> selectdata1(Cars cars);
    Boolean updatepos(Cars cars);
    Boolean removepos(Cars cars);
    Boolean nullcar(Cars cars);
    Boolean nullcar1(Cars cars);
    List<Cars> carinfo(Integer carId);
    Boolean update(Cars cars);
}
