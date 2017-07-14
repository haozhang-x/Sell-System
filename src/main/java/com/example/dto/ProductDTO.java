package com.example.dto;

import com.example.model.ProductDO;

/**
 * Created by zhang on 2017/7/8.
 */

public class ProductDTO extends ProductDO{
    private Integer pid; //产品id
    private String title; //标题
    private String image;//图片
    private Long price;//价格
    private Integer isBuy;//当前用户是否已经购买
    private Integer isSell;//是否已经卖出
    private String summary;//摘要
    private String detail;//全文
    private Integer buyPrice;//购买时的价格
    private Integer buyNum;//购买时间13位时间戳
    private Integer sellNum;//销售数量
    private Integer total;//购买的总金额

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(Integer isBuy) {
        this.isBuy = isBuy;
    }

    public Integer getIsSell() {
        return isSell;
    }

    public void setIsSell(Integer isSell) {
        this.isSell = isSell;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ProductDO{" +
                "pid=" + pid +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", isBuy=" + isBuy +
                ", isSell=" + isSell +
                ", summary='" + summary + '\'' +
                ", detail='" + detail + '\'' +
                ", buyPrice=" + buyPrice +
                ", buyNum=" + buyNum +
                ", sellNum=" + sellNum +
                ", total=" + total +
                '}';
    }
}
