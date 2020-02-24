package com.zhouwenbin.carsystem.entity;
// 映射分类统计实体
public class categoryTosum {
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCs() {
        return cs;
    }

    public void setCs(Integer cs) {
        this.cs = cs;
    }

    public categoryTosum(){};
    public categoryTosum(String category,Integer cs){
        this.category=category;
        this.cs=cs;
    };
    private String category;
    private Integer cs;
    public String toString(){
        return "categoryTosum(category="+this.getCategory()+",cs="+this.getCs()+").";
    }
}
