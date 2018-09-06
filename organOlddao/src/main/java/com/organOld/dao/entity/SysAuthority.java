package com.organOld.dao.entity;

/**
 * 权限
 * Created by netlab606 on 2018/4/8.
 */
public class SysAuthority extends DBEntity{

    private String auDesc;
    private String auName;

    public String getAuDesc() {
        return auDesc;
    }

    public void setAuDesc(String auDesc) {
        this.auDesc = auDesc;
    }

    public String getAuName() {
        return auName;
    }

    public void setAuName(String auName) {
        this.auName = auName;
    }
}
