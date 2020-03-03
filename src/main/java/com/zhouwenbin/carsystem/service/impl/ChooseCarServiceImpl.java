package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.ChooseCarMapper;
import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.service.ChooseCarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ChooseCarServiceImpl implements ChooseCarService {
    @Resource
    private ChooseCarMapper chooseCarMapper;
    @Override
    public List<Cars> selectbytype() {
        return chooseCarMapper.selectbytype();
    }
}
