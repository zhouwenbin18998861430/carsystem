package com.zhouwenbin.carsystem.entity;


public class Users {


    public Users(String account, String password, String name, Integer age, Integer phone,Integer grade) {
        super();

        this.account = account;
        this.password = password;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.grade=grade;
    }

    public Users() {
        super();
    }

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
    private Integer phone;

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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }


}
