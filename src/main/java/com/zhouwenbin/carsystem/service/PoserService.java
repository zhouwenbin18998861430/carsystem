package com.zhouwenbin.carsystem.service;

import com.zhouwenbin.carsystem.entity.Pos;
import com.zhouwenbin.carsystem.entity.Poser;
import com.zhouwenbin.carsystem.entity.Users;

import java.util.List;

public interface PoserService {
    List<Poser> selectPoser(Pos pos);
    Boolean del(Poser poser);
    Boolean add(Poser poser);
    Boolean addtouser(Users users);
    List<Poser> poserinfo(Integer poserid);
    Boolean saveinfo(Poser poser);
    List<Poser> poserinfo2();
    Boolean match(Poser poser);//分配管理员
}
