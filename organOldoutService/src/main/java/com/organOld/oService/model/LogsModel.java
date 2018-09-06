package com.organOld.oService.model;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;

public class LogsModel {
    private Oldman oldman;
    private String time;
    private Integer id;
    private String data;
    private Organ organ;
    private String type;
    private String order;
    private String moneyChange;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getMoneyChange() {
        return moneyChange;
    }

    public void setMoneyChange(String moneyChange) {
        this.moneyChange = moneyChange;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
