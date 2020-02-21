package com.zhouwenbin.carsystem.dao;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Pos;

import java.util.List;

public interface PosMapper {
    //添加租赁点
    Boolean addpos(Pos pos);
    List<String> selectpos();
    List<Cars> selectdata(Cars cars);//查未分配租赁点车辆
    List<Cars> selectdata1(Cars cars);//查某租赁点的车辆
    Boolean updatepos(Cars cars);
    Boolean removepos(Cars cars);
    Boolean nullcar(Cars cars);//删除租赁点时把汽车释放
    Boolean nullcar1(Cars cars);
    List<Cars> carinfo(Integer carId);//跳转到编辑车辆信息需要的车辆参数
    Boolean update(Cars cars);//更新车辆信息，编辑功能
}
