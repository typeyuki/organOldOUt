package com.organOld.dao.entity.oldman;


import com.organOld.dao.entity.DBEntity;

/**
 *慢病 失能 药物反应
 */
public class HealthSelect extends DBEntity {

    private Integer oldmanId;
    private Integer firType;
    private String secTypeName;



    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Integer getFirType() {
        return firType;
    }

    public void setFirType(Integer firType) {
        this.firType = firType;
    }

    public String getSecTypeName() {
        return secTypeName;
    }

    public void setSecTypeName(String secTypeName) {
        this.secTypeName = secTypeName;
    }
}
