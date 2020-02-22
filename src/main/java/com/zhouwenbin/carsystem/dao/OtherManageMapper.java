package com.zhouwenbin.carsystem.dao;

import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OtherManageMapper {
    //查询state为问题车辆
    List<Cars> selecterrorcar();
    //根据carid获取carinfo
    List<Cars> carinfo(Integer carid);
    // 车辆问题登记
    Boolean errorCardj(Cars cars);
    // 车辆报废
    Boolean baofei(Cars cars);
    // 分类统计车辆数量
    Integer sumcarbycategory(String category);
    // 查询客户信息
    List<Users> selectusersinfo();
    // 查询订单信息

}
