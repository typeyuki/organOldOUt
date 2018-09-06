package com.organOld.dao.entity.home;

import com.organOld.dao.entity.DBEntity;

//家庭医生
public class Doctor extends DBEntity{
    private String name;
    private Integer organId;
    private int homeId;

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public Integer getOrganId() {
        return organId;
    }

    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
