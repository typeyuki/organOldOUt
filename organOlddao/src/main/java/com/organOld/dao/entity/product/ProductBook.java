package com.organOld.dao.entity.product;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.oldman.Oldman;

public class ProductBook extends DBEntity implements DBInterface{
    private String productId;
    //private Oldman oldman;
    private Integer status;
    private Integer organId;
    private Integer oldmanId;

    public Integer getOldmanId() {
        return oldmanId;
    }
    @Override
    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public String getProductIds() {
        return productId;
    }

    public void setProductIds(String productIds) {
        this.productId = productIds;
    }

//    public Oldman getOldman() {
//        return oldman;
//    }
//
//    public void setOldman(Oldman oldman) {
//        this.oldman = oldman;
//    }


}
