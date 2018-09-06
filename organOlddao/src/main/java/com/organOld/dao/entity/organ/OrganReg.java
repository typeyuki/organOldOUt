package com.organOld.dao.entity.organ;

import com.organOld.dao.entity.DBEntity;

public class OrganReg extends DBEntity {
    private int organId;
    private String phone;
    private String email;

    public int getOrganId() {
        return organId;
    }

    public void setOrganId(int organId) {
        this.organId = organId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
