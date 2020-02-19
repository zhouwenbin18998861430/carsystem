package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.PosMapper;
import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Pos;
import com.zhouwenbin.carsystem.service.PosService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PosServiceImpl implements PosService {
    @Resource
    private PosMapper posMapper;
    public Boolean addpos(Pos pos) {
        return posMapper.addpos(pos);
    }
    public List<String> selectpos(){
        return posMapper.selectpos();
    }
    public List<Cars> selectdata(Cars cars){
        return posMapper.selectdata(cars);
    }
    public Boolean updatepos(Cars cars){
        return posMapper.updatepos(cars);
    }
    public Boolean removepos(Cars cars){
        return posMapper.removepos(cars);
    }
    public Boolean nullcar(Cars cars){
        return posMapper.nullcar(cars);
    }
    public Boolean nullcar1(Cars cars){
        return posMapper.nullcar1(cars);
    }
}
