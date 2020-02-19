package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.PoserMapper;
import com.zhouwenbin.carsystem.entity.Pos;
import com.zhouwenbin.carsystem.entity.Poser;
import com.zhouwenbin.carsystem.service.PoserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PoserServiceImpl implements PoserService {
    @Resource
    private PoserMapper poserMapper;
    @Override
    public List<Poser> selectPoser(Pos pos) {
        return poserMapper.selectPoser(pos);
    }
    public Boolean del(Poser poser){
        return poserMapper.del(poser);
    }
    public Boolean add(Poser poser){
        return poserMapper.add(poser);
    }
}
