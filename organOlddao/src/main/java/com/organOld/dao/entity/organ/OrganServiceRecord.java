package com.organOld.dao.entity.organ;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;

public class OrganServiceRecord extends DBEntity implements DBInterface {
    private Integer organId;
    private String data;
    private Integer oldmanId;
    private String oldmanName;
    private String organName;
    private String order;//单号


    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public String getOldmanName() {
        return oldmanName;
    }

    public void setOldmanName(String oldmanName) {
        this.oldmanName = oldmanName;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
