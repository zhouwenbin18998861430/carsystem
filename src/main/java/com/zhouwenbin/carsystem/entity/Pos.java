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

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Integer getPosid() {
        return posid;
    }

    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    private String posname;//租赁点名称
    private String posaddress;//租赁点地址
    private String account;//经手人
    private Integer carid;//车辆id
    private Integer posid;//租赁点id


    public Pos(){};
    public Pos(String posname,String posaddress,String account,Integer carid,Integer posid){
        this.posname=posname;
        this.posaddress=posaddress;
        this.account=account;
        this.carid=carid;
        this.posid=posid;
    }
}
