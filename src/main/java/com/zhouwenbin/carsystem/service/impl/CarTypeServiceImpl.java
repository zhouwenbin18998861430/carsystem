package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.CarTypeMapper;
import com.zhouwenbin.carsystem.entity.CarType;
import com.zhouwenbin.carsystem.service.CarTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CarTypeServiceImpl implements CarTypeService {
    @Resource
    private CarTypeMapper carTypeMapper;
    public Integer addtype(CarType carType) {
        return carTypeMapper.addtype(carType);
    }

    @Override
    public List<String> selecttype() {
        return carTypeMapper.selecttype();
    }
}
