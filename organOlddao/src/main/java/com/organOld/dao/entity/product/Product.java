package com.organOld.dao.entity.product;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import org.springframework.web.multipart.MultipartFile;

public class Product extends DBEntity  {
    private Integer organId;
    private double price;
    private String intro;
    private String imgUrl;
    private ProductType productType;
    private Integer type;

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrganId() {
        return organId;
    }


    public void setOrganId(Integer organId) {
        this.organId = organId;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
