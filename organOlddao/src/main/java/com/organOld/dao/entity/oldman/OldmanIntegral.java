package com.organOld.dao.entity.oldman;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;

public class OldmanIntegral extends DBEntity implements DBInterface{
    private Oldman oldman;
    private Integer integral;
    private Integer organId;


    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}
