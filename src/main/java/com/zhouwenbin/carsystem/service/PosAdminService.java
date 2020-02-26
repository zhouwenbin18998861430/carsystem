package com.zhouwenbin.carsystem.service;

import com.zhouwenbin.carsystem.entity.Cars;

import java.util.List;

public interface PosAdminService {
     String checkname(String account);//根据账号-》姓名
     String checkpos(String posername);//根据姓名在poser表中找属于哪个租赁点
     List<Cars> selectposcar(String pos);//查询该租赁点的车辆
     List<Cars> selectposcar1(String pos);//查询该租赁点正常的车辆
     List<Cars> selectcarinfo(Integer carid);//查询要登记出租车辆的信息
     Boolean djjiechu(Cars cars);//借出
     Boolean djguihuan(Cars cars);//归还
     List<Cars> selectposcar2(String pos);//查询该租赁点已借出的车辆
}
