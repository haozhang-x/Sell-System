package com.example.model;


import java.sql.Timestamp;

public class TransactionDO {

    private Integer productId;
    private Integer userId;
    private Float price;
    private Timestamp time;


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TransactionDO{" +
                ", productId=" + productId +
                ", userId=" + userId +
                ", price=" + price +
                ", time=" + time +
                '}';
    }

}
