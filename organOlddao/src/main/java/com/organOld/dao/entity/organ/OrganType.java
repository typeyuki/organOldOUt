package com.organOld.dao.entity.organ;

import com.organOld.dao.entity.DBEntity;

public class OrganType extends DBEntity {
    private int firType;
    private String secType;

    public int getFirType() {
        return firType;
    }

    public void setFirType(int firType) {
        this.firType = firType;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }
}
