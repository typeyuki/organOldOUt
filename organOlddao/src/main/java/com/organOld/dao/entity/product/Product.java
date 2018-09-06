package com.organOld.dao.entity.product;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import org.springframework.web.multipart.MultipartFile;

public class Product extends DBEntity implements DBInterface {
    private Integer organId;
    private String name;
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

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
