package com.organOld.dao.entity.record;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;

import java.util.Date;

public class Record extends DBEntity implements DBInterface{
    private String data;
    private Oldman oldman;
    private Integer organId;
    private Integer oldmanId;
    private Integer type;
    private Organ organ;
    private Double prevMoney;
    private Double nowMoney;
    private String order;
    private Date start;
    private Date end;
    private String name;
    private int hdType;
    private String hdTime;
    private int peopleType;
    private Integer cardId;
    private String[] organIds;
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHdType() {
        return hdType;
    }

    public void setHdType(int hdType) {
        this.hdType = hdType;
    }

    public String getHdTime() {
        return hdTime;
    }

    public void setHdTime(String hdTime) {
        this.hdTime = hdTime;
    }

    public int getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(int peopleType) {
        this.peopleType = peopleType;
    }

    public String[] getOrganIds() {
        return organIds;
    }

    public void setOrganIds(String[] organIds) {
        this.organIds = organIds;
    }





    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Double getPrevMoney() {
        return prevMoney;
    }

    public void setPrevMoney(Double prevMoney) {
        this.prevMoney = prevMoney;
    }

    public Double getNowMoney() {
        return nowMoney;
    }

    public void setNowMoney(Double nowMoney) {
        this.nowMoney = nowMoney;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }
    @Override
    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }
}
