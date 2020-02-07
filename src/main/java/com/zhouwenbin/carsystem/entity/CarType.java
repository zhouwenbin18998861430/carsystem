package com.zhouwenbin.carsystem.entity;

public class CarType {
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private Integer num;//可载数量
    private String categoryname;//类型名
    private String account;//经手人
    private Integer state;//分类的状态 0正常1删除

    public CarType(Integer num,String categoryname,String account){
        this.num=num;
        this.categoryname=categoryname;
        this.account=account;
    }
}
