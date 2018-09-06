package com.organOld.dao.entity;

/**
 * Created by netlab606 on 2018/6/16.
 */
public class AutoValue extends DBEntity {
    private String value;
    private int type;
    private int parentIndex;

    private String timeFormat;//传给前端的时间格式


    public int getParentIndex() {
        return parentIndex;
    }

    public void setParentIndex(int parentIndex) {
        this.parentIndex = parentIndex;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
