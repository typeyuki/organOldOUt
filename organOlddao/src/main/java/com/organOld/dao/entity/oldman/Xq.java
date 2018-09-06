package com.organOld.dao.entity.oldman;

import com.organOld.dao.entity.DBEntity;

/**
 * 小区
 * Created by netlab606 on 2018/6/14.
 */
public class Xq extends DBEntity{
    private String name;
    private String jwName;//所属居委名称
    private String districtName;//所属片区名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJwName() {
        return jwName;
    }

    public void setJwName(String jwName) {
        this.jwName = jwName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
