package com.organOld.oService.contract;

public class ListRequest {
    private int type;
    private int firType;//organ_type_id in organ

    public int getFirType() {
        return firType;
    }

    public void setFirType(int firType) {
        this.firType = firType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
