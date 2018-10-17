package com.organOld.oService.model;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.product.Product;

import java.util.List;

public class ProductBookModel {
    private int id;
    private List<GoodsModel> productList;
    private Oldman oldman;
    private String time;
    private String ids;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<GoodsModel> getProductList() {
        return productList;
    }

    public void setProductList(List<GoodsModel> productList) {
        this.productList = productList;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

}
