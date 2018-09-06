package com.organOld.dao.entity.label;

import com.organOld.dao.entity.DBEntity;

/**
 * 一级 二级 标签
 * Created by netlab606 on 2018/6/16.
 */
public class LabelSec extends DBEntity{
    private String firName;
    private String secName;

    private Integer firIndex;


    public Integer getFirIndex() {
        return firIndex;
    }

    public void setFirIndex(Integer firIndex) {
        this.firIndex = firIndex;
    }

    public String getFirName() {
        return firName;
    }

    public void setFirName(String firName) {
        this.firName = firName;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }
}
