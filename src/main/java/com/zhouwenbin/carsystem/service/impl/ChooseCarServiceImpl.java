package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.ChooseCarMapper;
import com.zhouwenbin.carsystem.entity.Cars;
import com.zhouwenbin.carsystem.entity.Dingdan;
import com.zhouwenbin.carsystem.entity.Users;
import com.zhouwenbin.carsystem.service.ChooseCarService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
@EnableAutoConfiguration
public class ChooseCarServiceImpl implements ChooseCarService {
    @Resource
    private ChooseCarMapper chooseCarMapper;
    @Override
    public List<Cars> selectbytype(Cars cars) {
        return chooseCarMapper.selectbytype(cars);
    }
    public List<Cars> selectall(){return  chooseCarMapper.selectall();}
    public List<Cars> carinfo(Integer carId){return chooseCarMapper.carinfo(carId);}
    public Integer yecx(String account){return chooseCarMapper.yecx(account);}
    public Boolean updateyue(Users users){return chooseCarMapper.updateyue(users);}
    public Boolean updatecarstate(Integer carid){return chooseCarMapper.updatecarstate(carid);}
    public String lookusersinfo(String account){return chooseCarMapper.lookusersinfo(account);}
    public Boolean insertdingdan(Dingdan dingdan){return chooseCarMapper.insertdingdan(dingdan);}
    public List<Dingdan> selectdingdan(Dingdan dingdan){return chooseCarMapper.selectdingdan(dingdan);}
    public Boolean updatecarstate1(Integer carid){return chooseCarMapper.updatecarstate1(carid);}
    public Boolean updatedingdan(Dingdan dingdan){return chooseCarMapper.updatedingdan(dingdan);}
    public Boolean removedingdan(Dingdan dingdan){return chooseCarMapper.removedingdan(dingdan);}
    public Boolean returnmoney(Users users){return chooseCarMapper.returnmoney(users);}
    public List<Dingdan>  selectdingdanbyid(Integer ddid){return chooseCarMapper.selectdingdanbyid(ddid);}
}
