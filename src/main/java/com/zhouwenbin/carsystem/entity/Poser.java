package com.zhouwenbin.carsystem.entity;

public class Poser {
    public Poser(){};
    public Poser(Integer poserid,String posername,String pos,Integer carid,String phone,String shenfenzheng){
        this.carid=carid;
        this.poserid=poserid;
        this.posername=posername;
        this.pos=pos;
        this.phone=phone;
        this.shenfenzheng=shenfenzheng;
    };

    public Integer getPoserid() {
        return poserid;
    }

    public void setPoserid(Integer poserid) {
        this.poserid = poserid;
    }

    public String getPosername() {
        return posername;
    }

    public void setPosername(String posername) {
        this.posername = posername;
    }

    public String getPos() {
        return pos;
    }

    public void setPosid(String pos) {
        this.pos = pos;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getShenfenzheng() {
        return shenfenzheng;
    }

    public void setShenfenzheng(String shenfenzheng) {
        this.shenfenzheng = shenfenzheng;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private Integer poserid;
    private String posername;
    private String pos;
    private Integer carid;
    private String shenfenzheng;
    private String phone;
}
