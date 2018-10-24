package com.organOld.oService.model;

import java.util.List;

public class ProductTypeModel {
    private String name;
//    private String type;
//    private String parent;
//    private int id;
    private List<ProductTypeModel> productTypeModels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getParent() {
//        return parent;
//    }
//
//    public void setParent(String parent) {
//        this.parent = parent;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public List<ProductTypeModel> getProductTypeModels() {
        return productTypeModels;
    }

    public void setProductTypeModels(List<ProductTypeModel> productTypeModels) {
        this.productTypeModels = productTypeModels;
    }
}
