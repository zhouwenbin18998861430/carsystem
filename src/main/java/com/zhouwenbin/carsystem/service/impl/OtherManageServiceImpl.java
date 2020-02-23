package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.OtherManageMapper;
import com.zhouwenbin.carsystem.entity.BaofeiCars;
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

    public List<Cars> selecterrorcarhavemsg(){return otherManageMapper.selecterrorcarhavemsg();}

    public List<Cars> carinfo(Integer carid){return otherManageMapper.carinfo(carid);}

    public Boolean fixed(Cars cars){return otherManageMapper.fixed(cars);}
    @Override
    public Boolean errorCardj(Cars cars) {
        return otherManageMapper.errorCardj(cars);
    }

    @Override
    public Boolean baofei(BaofeiCars baofeiCars) {
        return otherManageMapper.baofei(baofeiCars);
    }

    public Boolean yibaofei(Cars cars){return otherManageMapper.yibaofei(cars);}
    @Override
    public Integer sumcarbycategory(String category) {
        return otherManageMapper.sumcarbycategory(category);
    }

    public List<Users> selectusersbyid(String account){return otherManageMapper.selectusersbyid(account);}

    public Boolean edituserinfo(Users users){return otherManageMapper.edituserinfo(users);}

    public Boolean  deluser(Users users){return  otherManageMapper.deluser(users);}
    @Override
    public List<Users> selectusersinfo() {
        return otherManageMapper.selectusersinfo();
    }

    public Boolean removeerrorcar(Cars cars){
        return otherManageMapper.removeerrorcar(cars);
    }
}
