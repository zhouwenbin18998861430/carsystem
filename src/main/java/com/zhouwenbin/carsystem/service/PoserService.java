package com.zhouwenbin.carsystem.service;

import com.zhouwenbin.carsystem.entity.Pos;
import com.zhouwenbin.carsystem.entity.Poser;

import java.util.List;

public interface PoserService {
    List<Poser> selectPoser(Pos pos);
    Boolean del(Poser poser);
    Boolean add(Poser poser);
}