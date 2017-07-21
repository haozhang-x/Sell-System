package com.example.model;

/**
 * Created by zhang on 2017/7/8.
 */
public class ProductDO {
    private Integer pid;
    private Float price;
    private String title;
    private String image;
    private String summary;
    private String detail;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "ProductDO{" +
                "pid=" + pid +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", summary='" + summary + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
