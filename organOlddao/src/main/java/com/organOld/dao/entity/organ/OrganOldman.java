package com.organOld.dao.entity.organ;


import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.XqInterface;
import com.organOld.dao.entity.oldman.Oldman;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 养老机构 中的老人
 * Created by netlab606 on 2018/4/2.
 */
public class OrganOldman extends DBEntity implements DBInterface,XqInterface {
    private Oldman oldman;
    private Organ organ;

    private Integer oldmanId;
    private List<Integer> xqIds;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date timeIn;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date timeOut;
    private String num;
    private String ny;//用于记录本次表是 几月份的

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date applyTime;
    private Integer organId;//居委ID




    /**
     * 搜素
     * @return
     */
    private Integer firType;
    private Integer oldStatus;
    private Integer isPd;
    private Integer isExist;//老人是否存在  1是 2否
    private String search;

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

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Integer getIsExist() {
        return isExist;
    }

    public void setIsExist(Integer isExist) {
        this.isExist = isExist;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getIsPd() {
        return isPd;
    }

    public void setIsPd(Integer isPd) {
        this.isPd = isPd;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public Integer getFirType() {
        return firType;
    }

    public void setFirType(Integer firType) {
        this.firType = firType;
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

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
