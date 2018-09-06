package com.organOld.dao.entity.oldman;

import com.organOld.dao.entity.DBEntity;

public class OldmanKeyHandle extends DBEntity {
    private int type;
    private int oldmanId;
    private String homeFirTypes;
    private String organIds;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(int oldmanId) {
        this.oldmanId = oldmanId;
    }

    public String getHomeFirTypes() {
        return homeFirTypes;
    }

    public void setHomeFirTypes(String homeFirTypes) {
        this.homeFirTypes = homeFirTypes;
    }

    public String getOrganIds() {
        return organIds;
    }

    public void setOrganIds(String organIds) {
        this.organIds = organIds;
    }
}
