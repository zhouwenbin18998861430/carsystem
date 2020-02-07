package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.PosMapper;
import com.zhouwenbin.carsystem.entity.Pos;
import com.zhouwenbin.carsystem.service.PosService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class PosServiceImpl implements PosService {
    @Resource
    private PosMapper posMapper;
    public Integer addpos(Pos pos) {
        return posMapper.addpos(pos);
    }
}
