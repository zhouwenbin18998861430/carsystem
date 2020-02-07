package com.zhouwenbin.carsystem.entity;

public class Pos {
    public String getPosname() {
        return posname;
    }

    public void setPosname(String posname) {
        this.posname = posname;
    }

    public String getPosaddress() {
        return posaddress;
    }

    public void setPosaddress(String posaddress) {
        this.posaddress = posaddress;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private String posname;//租赁点名称
    private String posaddress;//租赁点地址
    private String account;//经手人

    public Pos(String posname,String posaddress,String account){
        this.posname=posname;
        this.posaddress=posaddress;
        this.account=account;
    }
}
