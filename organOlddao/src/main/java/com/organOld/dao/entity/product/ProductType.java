package com.organOld.dao.entity.product;

import com.organOld.dao.entity.DBEntity;

public class ProductType extends DBEntity{
    private String name;
    private String parent;
    private ProductType firProductType;


    public ProductType getFirProductType() {
        return firProductType;
    }

    public void setFirProductType(ProductType firProductType) {
        this.firProductType = firProductType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
