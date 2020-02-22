package com.zhouwenbin.carsystem.dao;

import com.zhouwenbin.carsystem.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UsersMapper {
    //初始化系统管理员
    Integer addAdmin(Users users);
    //增加普通用户
    Integer addUser(Users users);
    // 登录校验(根据用户名查询密码)
    String findPwd(String account) ;
    //查询权限等级
    Integer selectGrade(String account);
    //查询数据库中是否有此账号
    List<Users> haveaccount(String account);
    //忘记密码重设
    Boolean forgetpwd(Users users);
}
