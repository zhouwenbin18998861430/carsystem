package com.zhouwenbin.carsystem.entity;


public class Users {


    public Users(String account, String password, String name, Integer age, String phone,Integer grade,Integer money,Integer shenfenzheng) {
        super();
        this.account = account;
        this.password = password;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.grade=grade;
        this.money=money;
        this.shenfenzheng=shenfenzheng;
    }

    public Users() {
        super();
    }



    private Integer shenfenzheng;

    private String account;

    private String password;

    private String name;

    private Integer age;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    private Integer grade;
    private String phone;

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    private Integer money;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getShenfenzheng() {
        return shenfenzheng;
    }

    public void setShenfenzheng(Integer shenfenzheng) {
        this.shenfenzheng = shenfenzheng;
    }

    public String toString(){
        return "Users(account="+this.getAccount()+",name="+this.getName()+",age="+this.getAge()+",phone="+this.getPhone()+",password="+this.getPassword()+",money="+this.getMoney()+",shenfenzheng="+this.getShenfenzheng()+").";
    }

}
