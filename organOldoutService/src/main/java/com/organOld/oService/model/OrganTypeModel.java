package com.organOld.oService.model;

import com.organOld.dao.entity.organ.Organ;

import java.util.List;

public class OrganTypeModel {
    private String organName;
    private int id;
    private List<AutoValModel> organs;

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AutoValModel> getOrgans() {
        return organs;
    }

    public void setOrgans(List<AutoValModel> organs) {
        this.organs = organs;
    }
}
