package com.example.model;


import java.sql.Date;

public class TransactionDO {

    private Integer tid;
    private Integer productId;
    private Integer userId;
    private Integer price;
    private Date time;


    public Integer getPid() {
        return tid;
    }

    public void setPid(Integer tid) {
        this.tid = tid;
    }

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TransactionDO{" +
                "tid=" + tid +
                ", productId=" + productId +
                ", userId=" + userId +
                ", price=" + price +
                ", time=" + time +
                '}';
    }

}
