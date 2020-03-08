package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.PosAdminMapper;
import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.service.PosAdminService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
@EnableAutoConfiguration
public class PosAdminServiceImpl implements PosAdminService {
    @Resource
    private PosAdminMapper posAdminMapper;
    public String checkname(String account){return posAdminMapper.checkname(account);}//根据账号-》姓名
    public String checkpos(String posername){return posAdminMapper.checkpos(posername);}//根据姓名在poser表中找属于哪个租赁点
    @Override
    public List<Cars> selectposcar(String pos) {
        return posAdminMapper.selectposcar(pos);
    }
    public List<Cars> selectposcar1(String pos){return posAdminMapper.selectposcar1(pos);}
    public List<Cars> selectcarinfo(Integer carid){return posAdminMapper.selectcarinfo(carid);}
    public Boolean djjiechu(Cars cars){return posAdminMapper.djjiechu(cars);}
    public List<Cars> selectposcar2(String pos){return posAdminMapper.selectposcar2(pos);}
    public Boolean djguihuan(Cars cars){return posAdminMapper.djguihuan(cars);}
}
