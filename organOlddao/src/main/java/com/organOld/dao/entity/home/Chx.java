package com.organOld.dao.entity.home;

import com.organOld.dao.entity.DBEntity;

/**
 * 长护险
 * Created by netlab606 on 2018/6/16.
 */
public class Chx extends DBEntity {

    private Integer level;//级别
    private String serviceTime;//服务时间
    private int homeId;

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }
}
