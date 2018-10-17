package com.organOld.oService.contract;

public class OrganRequest {
    private int id;
    private String search;
    private int type;
    private Integer organTypeId;
    private String status;

    public Integer getOrganTypeId() {
        return organTypeId;
    }

    public void setOrganTypeId(Integer organTypeId) {
        this.organTypeId = organTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
