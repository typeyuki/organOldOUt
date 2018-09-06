package com.organOld.dao.entity;

import java.util.Date;

public class DBEntity {
    protected int id;
    protected Date time;//更新时间

    public DBEntity() {
    }

    public DBEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }



}
