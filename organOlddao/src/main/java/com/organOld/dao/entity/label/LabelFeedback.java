package com.organOld.dao.entity.label;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.organ.Organ;

public class LabelFeedback extends DBEntity {

    private int labelId;
    private Organ organ;
    private String remark;
    private Integer isFinish;

    private Integer organId;
    private Integer labelOrganId;//标签的 发布者

    public Integer getLabelOrganId() {
        return labelOrganId;
    }

    public void setLabelOrganId(Integer labelOrganId) {
        this.labelOrganId = labelOrganId;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }

    public Integer getOrganId() {
        return organId;
    }


    public void setOrganId(Integer organId) {
        this.organId = organId;
    }
}
