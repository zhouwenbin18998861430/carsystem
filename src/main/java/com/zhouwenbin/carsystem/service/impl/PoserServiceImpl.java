package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.PoserMapper;
import com.zhouwenbin.carsystem.entity.Pos;
import com.zhouwenbin.carsystem.entity.Poser;
import com.zhouwenbin.carsystem.entity.Users;
import com.zhouwenbin.carsystem.service.PoserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
@EnableAutoConfiguration
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
    public Boolean addtouser(Users users){return poserMapper.addtouser(users);}
    public Boolean add(Poser poser){
        return poserMapper.add(poser);
    }
    public List<Poser> poserinfo(Integer poserid){return  poserMapper.poserinfo(poserid);}
    public Boolean saveinfo(Poser poser){return poserMapper.saveinfo(poser);}
    public List<Poser> poserinfo2(){return poserMapper.poserinfo2();}
    public Boolean match(Poser poser){return  poserMapper.match(poser);}
    public Boolean updatecar(Poser poser){return  poserMapper.updatecar(poser);}
}
