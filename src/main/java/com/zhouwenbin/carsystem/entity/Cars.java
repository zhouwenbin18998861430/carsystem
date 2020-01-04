package com.zhouwenbin.carsystem.entity;

public class Cars {
    public Cars(String carNum,Integer category,Integer price,Integer fixed,Integer state,Integer yaprice){
        this.carNum=carNum;
        this.category=category;
        this.price=price;
        this.fixed=fixed;
        this.state=state;
        this.yaprice=yaprice;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
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

    private String carNum;//车牌号
    private Integer category;//车辆类别
    private Integer price;//租车价格
    private Integer yaprice;//押金价格
    private Integer fixed;//修理状态
    private Integer state;//借车状态
}
