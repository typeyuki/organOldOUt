package com.organOld.oService.model;

import com.organOld.dao.entity.organ.Organ;

public class HomeOldsModel {
    private int id;
    private Integer oldmanId;
    private String oldmanName;
    private String timeIn;
    private String timeOut;
    private String time;
    private String homeType;
    private String homeName;
    private String isService;
    private Organ organ;
    private String oldmanStatus;
    private String ny;

    public String getNy() {
        return ny;
    }

    public void setNy(String ny) {
        this.ny = ny;
    }

    public String getOldmanStatus() {
        return oldmanStatus;
    }

    public void setOldmanStatus(String oldmanStatus) {
        this.oldmanStatus = oldmanStatus;
    }

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

    public String getIsService() {
        return isService;
    }

    public void setIsService(String isService) {
        this.isService = isService;
    }

    public String getHomeType() {
        return homeType;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
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

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }
}
