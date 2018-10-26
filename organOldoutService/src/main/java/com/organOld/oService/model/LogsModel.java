package com.organOld.oService.model;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;

public class LogsModel {
    private Oldman oldman;
    private String time;
    private Integer id;
    private String data;//兑换积分
    private Organ organ;
    private String type;//扫码类型
    private String order;//消费类型
    private String moneyChange;//表示"2->1"
    private String hdName;
    private String hdType;//活动类型

    public String getNowData() {
        return nowData;
    }

    public void setNowData(String nowData) {
        this.nowData = nowData;
    }

    private String peopleType;//活动角色
    private String secType;//小类
    private String integral;//兑换的积分
    private String hdTime;//活动时间
    private String nowData;

    public String getHdName() {
        return hdName;
    }

    public void setHdName(String hdName) {
        this.hdName = hdName;
    }

    public String getHdType() {
        return hdType;
    }

    public void setHdType(String hdType) {
        this.hdType = hdType;
    }

    public String getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(String peopleType) {
        this.peopleType = peopleType;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getHdTime() {
        return hdTime;
    }

    public void setHdTime(String hdTime) {
        this.hdTime = hdTime;
    }



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
