package com.zhouwenbin.carsystem.dao;

import com.zhouwenbin.carsystem.entity.Pos;
import com.zhouwenbin.carsystem.entity.Poser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoserMapper {
    List<Poser> selectPoser(Pos pos);
    Boolean del(Poser poser);
    Boolean add(Poser poser);
}
