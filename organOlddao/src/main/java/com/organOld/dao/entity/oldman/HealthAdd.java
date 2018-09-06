package com.organOld.dao.entity.oldman;


import com.organOld.dao.entity.DBEntity;

/**
 * 1恶性肿瘤史 2骨折史 3残疾情况
 */
public class HealthAdd extends DBEntity {

    private Integer oldmanId;
    private int type;//1恶性肿瘤史 2骨折史 3残疾情况
    private String desc;


    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
