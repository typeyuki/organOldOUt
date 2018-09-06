package com.organOld.dao.entity.home;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.organ.Organ;

public class Home extends DBEntity{
    private int firType;
    private String firTypeDesc;
    private String secType;


    private Chx chx;//长护险
    private Organ organ;//家庭病床、家庭医生对应的 医院啊
    private Doctor doctor;//家庭医生

    private String search;

    public String getFirTypeDesc() {
        return firTypeDesc;
    }

    public void setFirTypeDesc(String firTypeDesc) {
        this.firTypeDesc = firTypeDesc;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

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

    public Chx getChx() {
        return chx;
    }

    public void setChx(Chx chx) {
        this.chx = chx;
    }

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
