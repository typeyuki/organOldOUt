package com.organOld.oService.contract;

public class LogsRequest {
    private Integer organId;
    private Integer type;
    private String start;
    private String end;
    private String[] organIds;
    private String search;
    private Integer order;
    private Integer oldmanId;
    public String[] getOrganIds() {
        return organIds;
    }
    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }


    public void setOrganIds(String[] organIds) {
        this.organIds = organIds;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

   ;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getOrganId() {
        return organId;
    }

    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
