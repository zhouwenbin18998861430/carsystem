package com.zhouwenbin.carsystem.entity;

public class Cars {
    public Cars(String carNum,String category,Integer price,Integer fixed,Integer state,Integer yaprice,String photolocation,Integer size,String account,String pinpai){
        this.carNum=carNum;
        this.category=category;
        this.price=price;
        this.fixed=fixed;
        this.state=state;
        this.yaprice=yaprice;
        this.photolocation=photolocation;
        this.size=size;
        this.account=account;
        this.pinpai=pinpai;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
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

    public Integer getFixed() {
        return fixed;
    }

    public void setFixed(Integer fixed) {
        this.fixed = fixed;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPhotolocation() {
        return photolocation;
    }

    public void setPhotolocation(String photolocation) {
        this.photolocation = photolocation;
    }

    public String getPinpai() {
        return pinpai;
    }

    public void setPinpai(String pinpai) {
        this.pinpai = pinpai;
    }

    private String pinpai;//车辆品牌
    private String carNum;//车牌号
    private String category;//车辆类别
    private Integer price;//租车价格
    private Integer yaprice;//押金价格
    private Integer fixed;//修理状态
    private Integer state;//借车状态
    private Integer size;//车辆规模
    private String photolocation;//车辆图片
    private String account;//经手人

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }







}
