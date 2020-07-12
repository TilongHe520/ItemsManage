package com.pojo;

import java.util.Date;

public class Goods {
    
    private Integer id;
    private Integer itemId;
    private String name;
    private Float price;
    private Integer number;
    private Date createtime;

    public Goods() {
    }

    public Goods(Integer id, Integer itemId, String name, Float price, Integer number, Date createtime) {
        this.id = id;
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.number = number;
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", createtime=" + createtime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
