package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.OtherManageMapper;
import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Users;
import com.zhouwenbin.carsystem.service.OtherManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class OtherManageServiceImpl implements OtherManageService {
    @Resource
    private OtherManageMapper otherManageMapper;
    public List<Cars> selecterrorcar(){
        return otherManageMapper.selecterrorcar();
    }

    public List<Cars> carinfo(Integer carid){return otherManageMapper.carinfo(carid);}
    @Override
    public Boolean errorCardj(Cars cars) {
        return otherManageMapper.errorCardj(cars);
    }

    @Override
    public Boolean baofei(Cars cars) {
        return otherManageMapper.baofei(cars);
    }

    @Override
    public Integer sumcarbycategory(String category) {
        return otherManageMapper.sumcarbycategory(category);
    }

    @Override
    public List<Users> selectusersinfo() {
        return otherManageMapper.selectusersinfo();
    }
}
