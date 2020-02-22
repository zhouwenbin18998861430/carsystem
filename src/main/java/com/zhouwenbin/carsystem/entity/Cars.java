package com.zhouwenbin.carsystem.entity;

public class Cars {
    public Cars(){}
    public Cars(String pos,Integer carid,String carNum,String category,Integer price,String fixed,String state,Integer yaprice,String photolocation,Integer size,String account,String pinpai,String errormsg){
        this.pos=pos;
        this.carid=carid;
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
        this.errormsg=errormsg;
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

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
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

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    private String pinpai;//车辆品牌
    private String carNum;//车牌号
    private Integer carid;//车辆ID
    private String category;//车辆类别
    private Integer price;//租车价格
    private Integer yaprice;//押金价格
    private String fixed;//修理状态
    private String state;//借车状态
    private Integer size;//车辆规模
    private String photolocation;//车辆图片
    private String account;//经手人
    private String errormsg;//维修事项


    private String pos;//租赁地点

    public String toString(){
        return "Cars(pinpai="+this.getPinpai()+",carNum="+this.getCarNum()+",pos="+this.getPos()+",carid="+this.getCarid()+",category="+this.getCategory()+",price="+this.getPrice()+",yaprice="+this.getYaprice()+",fixed="+this.getFixed()+",state="+this.getState()+",size="+this.getSize()+",photolocation="+this.getPhotolocation()+",account="+this.getAccount()+",errormsg="+this.getErrormsg()+").";
    }








}
