package com.zhouwenbin.carsystem.service.impl;

import com.zhouwenbin.carsystem.dao.UsersMapper;
import com.zhouwenbin.carsystem.entity.Users;
import com.zhouwenbin.carsystem.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
//    注入
    @Resource
    private UsersMapper usersMapper;

    @Override
    public Integer addAdmin(Users users) {
        return usersMapper.addAdmin(users);
    }


    @Override
    public Integer addUser(Users users)  {
        return usersMapper.addUser(users);
    }

    @Override
    public String findPwd(String account) {
        String result1=usersMapper.findPwd(account);
//        System.out.println("findpwd:"+result1);
//        System.out.println("用户已经登录");
//        System.out.println("密码是："+result1);
        return result1;
    }

    @Override
    public Integer selectGrade(String account) {
        return usersMapper.selectGrade(account);
    }

    public List<Users> haveaccount(String account){return usersMapper.haveaccount(account);}

    public Boolean forgetpwd(Users users){
        return usersMapper.forgetpwd(users);
    }


}
