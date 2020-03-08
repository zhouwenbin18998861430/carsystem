package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.CarTableMapper;
import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Dingdan;
import com.zhouwenbin.carsystem.service.CarTableService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
@EnableAutoConfiguration
public class CarTableServiceImpl implements CarTableService {
    @Resource
    private CarTableMapper carTableMapper;
    @Override
    public List<Cars> selectList(Cars cars) {
        return carTableMapper.selectList(cars);
    }
    @Override
    public Boolean del(Cars cars) {
        return carTableMapper.del(cars);
    }
    @Override
    public List<Cars> carinfo(Integer carId) {
        return carTableMapper.carinfo(carId);
    }
    public Boolean update(Cars cars){
        return carTableMapper.update(cars);
    }
    public List<Dingdan> selectdingdan(){return carTableMapper.selectdingdan();}
}
