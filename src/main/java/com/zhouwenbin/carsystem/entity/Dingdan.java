package com.zhouwenbin.carsystem.entity;

public class Dingdan {
    public Dingdan(){};
    public Dingdan(Integer ddid,Integer carid,String account,String name,String category,Integer price,Integer yaprice,String pos){
        this.ddid=ddid;
        this.carid=carid;
        this.account=account;
        this.name=name;
        this.category=category;
        this.price=price;
        this.yaprice=yaprice;
        this.pos=pos;
    }
    private Integer ddid;
    private Integer carid;
    private String account;
    private String name;
    private String category;
    private Integer price;
    private Integer yaprice;
    private String pos;

    public Integer getDdid() {
        return ddid;
    }

    public void setDdid(Integer ddid) {
        this.ddid = ddid;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYaprice() {
        return yaprice;
    }

    public void setYaprice(Integer yaprice) {
        this.yaprice = yaprice;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPinpai() {
        return pinpai;
    }

    public void setPinpai(String pinpai) {
        this.pinpai = pinpai;
    }

    private Integer size;
    private String pinpai;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String state;
    public String toString(){
        return "carid="+this.getCarid()+",account="+this.getAccount()+",pos="+this.getPos()+",state="+this.getState()+",name="+this.getName()+",category="+this.getCategory()+",price="+this.getPrice()+",yaprice="+this.getYaprice()+",size="+this.getSize()+",pinpai="+this.getPinpai()+").";
    }
}
