package com.zhouwenbin.carsystem.dao;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Pos;

import java.util.List;

public interface PosMapper {
    //添加租赁点
    Boolean addpos(Pos pos);
    List<String> selectpos();
    List<Cars> selectdata(Cars cars);
    Boolean updatepos(Cars cars);
    Boolean removepos(Cars cars);
    Boolean nullcar(Cars cars);//删除租赁点时把汽车释放
    Boolean nullcar1(Cars cars);
}
