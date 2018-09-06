package com.organOld.dao.entity.label;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.XqInterface;
import com.organOld.dao.entity.oldman.Oldman;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by netlab606 on 2018/7/8.
 */
public class LabelMan extends DBEntity implements DBInterface,XqInterface{
    private int labelId;
    private int oldmanId;
    private int isImplement;
    private String labelName;
    private String remark;

    private Oldman oldman;

    private Integer organId;


    private List<Integer> xqIds=new ArrayList<>();


    @Override
    public List<Integer> getXqIds() {
        return xqIds;
    }

    @Override
    public void setXqIds(List<Integer> xqIds) {
        this.xqIds = xqIds;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public int getIsImplement() {
        return isImplement;
    }

    public void setIsImplement(int isImplement) {
        this.isImplement = isImplement;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public int getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(int oldmanId) {
        this.oldmanId = oldmanId;
    }
}
