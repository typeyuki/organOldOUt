package com.organOld.dao.entity.oldman;

import com.organOld.dao.entity.DBEntity;

public class HealthSelectMan extends DBEntity {
    private Integer oldmanId;
    private Integer healthSelectId;

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Integer getHealthSelectId() {
        return healthSelectId;
    }

    public void setHealthSelectId(Integer healthSelectId) {
        this.healthSelectId = healthSelectId;
    }
}
