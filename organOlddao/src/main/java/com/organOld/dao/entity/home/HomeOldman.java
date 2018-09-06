package com.organOld.dao.entity.home;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.XqInterface;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import org.springframework.format.annotation.DateTimeFormat;
import sun.dc.pr.PRError;

import java.util.Date;
import java.util.List;

public class HomeOldman extends DBEntity implements DBInterface,XqInterface{
    private Integer homeId;
    private Oldman oldman;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date timeIn;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date timeOut;
    private Integer isService;
    private Organ organ;
    private Integer oldmanId;
    private String[] type;
    private Home home;
    private String ny;

    private Integer organId;//居委ID
    private String search;
    List<Integer> xqIds;
    private Integer oldStatus;

    public Integer getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Integer oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getNy() {
        return ny;
    }

    public void setNy(String ny) {
        this.ny = ny;
    }

    @Override
    public List<Integer> getXqIds() {
        return xqIds;
    }

    @Override
    public void setXqIds(List<Integer> xqIds) {
        this.xqIds = xqIds;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

    public Integer getIsService() {
        return isService;
    }

    public void setIsService(Integer isService) {
        this.isService = isService;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }
}
