package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.CarsMapper;
import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.service.CarsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CarsServiceImpl implements CarsService {
    @Resource
    private CarsMapper carsMapper;
    public Integer registerCar(Cars cars) {
        return carsMapper.registerCar(cars);
    }
}
