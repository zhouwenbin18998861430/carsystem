package com.zhouwenbin.carsystem.dao;

import com.zhouwenbin.carsystem.entity.Pos;
import com.zhouwenbin.carsystem.entity.Poser;
import com.zhouwenbin.carsystem.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoserMapper {
    List<Poser> selectPoser(Pos pos);
    Boolean del(Poser poser);
    Boolean add(Poser poser);
    Boolean addtouser(Users users);
    List<Poser> poserinfo(Integer poserid);//select租赁点管理员信息
    Boolean saveinfo(Poser poser);//编辑租赁点管理员信息
    List<Poser> poserinfo2();//查询未分配的管理员
    Boolean match(Poser poser);//分配管理员
    Boolean updatecar(Poser poser);//更新车辆归属
}
