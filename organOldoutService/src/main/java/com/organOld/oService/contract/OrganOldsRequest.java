package com.organOld.oService.contract;

public class OrganOldsRequest {
    private int organId;
    private Integer oldmanId;
    private String firType;//用于养老状态  organ机构养老 community 社区养老
    private Integer isPd;
    private String search;
    private Integer isExist;//老人是否存在  1是 2否
    private String ny;

    public String getNy() {
        return ny;
    }

    public void setNy(String ny) {
        this.ny = ny;
    }

    public Integer getIsExist() {
        return isExist;
    }

    public void setIsExist(Integer isExist) {
        this.isExist = isExist;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getIsPd() {
        return isPd;
    }

    public void setIsPd(Integer isPd) {
        this.isPd = isPd;
    }

    public String getFirType() {
        return firType;
    }

    public void setFirType(String firType) {
        this.firType = firType;
    }

    public int getOrganId() {
        return this.organId;
    }

    public void setOrganId(int organId) {
        this.organId = organId;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }
}
