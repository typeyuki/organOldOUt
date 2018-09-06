package com.organOld.dao.entity.oldman;


import com.organOld.dao.entity.DBEntity;

public class Man extends DBEntity {
    protected String name;
    protected String phone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
