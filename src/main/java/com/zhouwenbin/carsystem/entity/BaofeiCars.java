package com.zhouwenbin.carsystem.entity;

public class BaofeiCars {
    public BaofeiCars(){};
    public BaofeiCars(Integer carid,Integer price,Integer yaprice,Integer size,String fixed,String errormsg,String pos,String category,String photolocation,String carnum,String pinpai){
        this.carid=carid;
        this.price=price;
        this.yaprice=yaprice;
        this.size=size;
        this.fixed=fixed;
        this.errormsg=errormsg;
        this.pos=pos;
        this.category=category;
        this.carnum=carnum;
        this.photolocation=photolocation;
        this.pinpai=pinpai;
    };
    private Integer carid;
    private Integer price;
    private Integer yaprice;
    private Integer size;
    private String fixed;
    private String errormsg;
    private String pos;
    private String category;
    private String photolocation;
    private String carnum;
    private String pinpai;

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhotolocation() {
        return photolocation;
    }

    public void setPhotolocation(String photolocation) {
        this.photolocation = photolocation;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getPinpai() {
        return pinpai;
    }

    public void setPinpai(String pinpai) {
        this.pinpai = pinpai;
    }



}
