package com.zhouwenbin.carsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
//扫描mapper接口
@MapperScan("com.zhouwenbin.carsystem.dao")
public class CarsystemApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CarsystemApplication.class, args);
    }

}
