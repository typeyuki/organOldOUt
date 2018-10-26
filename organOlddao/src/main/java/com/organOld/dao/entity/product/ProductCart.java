package com.organOld.dao.entity.product;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;

public class ProductCart extends DBEntity implements DBInterface {
    private Integer oldmanId;
    private Integer organId;
    private Integer productId;
    private Integer type;
    public Integer getOldmanId() {
        return oldmanId;
    }
   @Override
    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
