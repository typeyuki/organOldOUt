package com.organOld.oService.model;

import com.organOld.dao.entity.organ.Organ;

public class OrganOldsModel extends Pattern {
    private Integer oldmanId;
    private String oldmanName;
    private int organId;
    private String organName;
    private String timeIn;
    private String timeOut;
    private String num;
    private String applyTime;
    private String oldmanStatus;
    private String ny;
    private Organ organ;

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

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getOldmanName() {
        return oldmanName;
    }

    public void setOldmanName(String oldmanName) {
        this.oldmanName = oldmanName;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public int getOrganId() {
        return organId;
    }

    public void setOrganId(int organId) {
        this.organId = organId;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
