package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.CarTableMapper;
import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.service.CarTableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CarTableServiceImpl implements CarTableService {
    @Resource
    private CarTableMapper carTableMapper;
    @Override
    public List<Cars> selectList(Cars cars) {
        return carTableMapper.selectList(cars);
    }
}
