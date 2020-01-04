package com.zhouwenbin.carsystem.service;

import com.zhouwenbin.carsystem.entity.Users;

public interface UsersService {
    //初始化系统管理员
    Integer addAdmin(Users users);
    //增加普通用户
    Integer addUser(Users users);
    // 登录校验(根据用户名查询密码)
    String findPwd(String account) ;
    //查询权限等级
    Integer selectGrade(String account);
}
