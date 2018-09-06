package com.organOld.oService.model;




import com.organOld.dao.entity.oldman.HealthAdd;
import com.organOld.dao.entity.oldman.HealthSelect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by netlab606 on 2018/5/28.
 */
public class OldsHealthModel extends Pattern {
    private int oldmanId;
    private String bloodType;
    private String intellInfo;//失智
    private String sight;//视力
    private List<HealthAdd> Cancer=new ArrayList<>();//恶性肿瘤史  id+内容
    private List<HealthAdd> broken=new ArrayList<>();//骨折史
    private List<HealthAdd> disabled=new ArrayList<>();//残疾情况
    private List<HealthSelect> chronicDis=new ArrayList<>();//慢病
    private List<HealthSelect> abiliInfo=new ArrayList<>();//失能
    private List<HealthSelect> drugAlley=new ArrayList<>();//药物反应
    private String name;

    public int getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(int oldmanId) {
        this.oldmanId = oldmanId;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getIntellInfo() {
        return intellInfo;
    }

    public void setIntellInfo(String intellInfo) {
        this.intellInfo = intellInfo;
    }

    public String getSight() {
        return sight;
    }

    public void setSight(String sight) {
        this.sight = sight;
    }

    public List<HealthAdd> getCancer() {
        return Cancer;
    }

    public void setCancer(List<HealthAdd> cancer) {
        Cancer = cancer;
    }

    public List<HealthAdd> getBroken() {
        return broken;
    }

    public void setBroken(List<HealthAdd> broken) {
        this.broken = broken;
    }

    public List<HealthAdd> getDisabled() {
        return disabled;
    }

    public void setDisabled(List<HealthAdd> disabled) {
        this.disabled = disabled;
    }

    public List<HealthSelect> getChronicDis() {
        return chronicDis;
    }

    public void setChronicDis(List<HealthSelect> chronicDis) {
        this.chronicDis = chronicDis;
    }

    public List<HealthSelect> getAbiliInfo() {
        return abiliInfo;
    }

    public void setAbiliInfo(List<HealthSelect> abiliInfo) {
        this.abiliInfo = abiliInfo;
    }

    public List<HealthSelect> getDrugAlley() {
        return drugAlley;
    }

    public void setDrugAlley(List<HealthSelect> drugAlley) {
        this.drugAlley = drugAlley;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
