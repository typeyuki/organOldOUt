package com.organOld.dao.entity.label;


import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.organ.Organ;

import java.util.Date;

/**
 * 三级标签实体
 * Created by netlab606 on 2018/6/7.
 */
public class Label extends DBEntity implements DBInterface{

    private LabelSec labelSec;//二级标签
    private String name;
    private String wh;
    private String content;//内容
    private String rule;//规则
    private int type;//类型  1 人员绑定标签 2规则指定标签
    private Organ organ;//发布的组织ID 主要是居委 0的话 表示针对所有
    private Date start;
    private Date end;

    private String startTime;
    private String endTime;
    private Integer firIndex;


    private Integer organId;
    private Integer oldmanId;
    private Integer secId;
    private Integer isFeedback;//针对某居委会 是否反馈


    /**
     * 查询
     * @return
     */
    private String[] censusArray;//户籍
    private String[] district;//片区索引
    private Integer ageStart;//年龄段-起
    private Integer ageEnd;//年龄段-止
    private String search;//模糊全文 匹配搜索  姓名、身份证、地址、电话
    private String[] jw;//居委索引
    private Integer sex;//1女 2男
    private Integer isKey;
    private Integer belongOrgan;
    private Integer firType;
    private Integer secType;
    private String[] politicalStatusArray;//政治面貌
    private String[] family;
    private String[] familyType;
    private String[] economic;
    private String[] isHealth;
    private String[] intelligence;
    private String[] eyesight;
    private String[] zc;
    private String[] sqzw;
    private String[] oldStatusArray;


    public String[] getFamilyType() {
        return familyType;
    }

    public void setFamilyType(String[] familyType) {
        this.familyType = familyType;
    }

    public String[] getZc() {
        return zc;
    }

    public void setZc(String[] zc) {
        this.zc = zc;
    }

    public String[] getSqzw() {
        return sqzw;
    }

    public void setSqzw(String[] sqzw) {
        this.sqzw = sqzw;
    }

    public Integer getFirIndex() {
        return firIndex;
    }

    public void setFirIndex(Integer firIndex) {
        this.firIndex = firIndex;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getSecId() {
        return secId;
    }

    public void setSecId(Integer secId) {
        this.secId = secId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String[] getCensusArray() {
        return censusArray;
    }

    public void setCensusArray(String[] censusArray) {
        this.censusArray = censusArray;
    }

    public String[] getDistrict() {
        return district;
    }

    public void setDistrict(String[] district) {
        this.district = district;
    }

    public Integer getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(Integer ageStart) {
        this.ageStart = ageStart;
    }

    public Integer getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(Integer ageEnd) {
        this.ageEnd = ageEnd;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String[] getJw() {
        return jw;
    }

    public void setJw(String[] jw) {
        this.jw = jw;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getIsKey() {
        return isKey;
    }

    public void setIsKey(Integer isKey) {
        this.isKey = isKey;
    }

    public Integer getBelongOrgan() {
        return belongOrgan;
    }

    public void setBelongOrgan(Integer belongOrgan) {
        this.belongOrgan = belongOrgan;
    }

    public Integer getFirType() {
        return firType;
    }

    public void setFirType(Integer firType) {
        this.firType = firType;
    }

    public Integer getSecType() {
        return secType;
    }

    public void setSecType(Integer secType) {
        this.secType = secType;
    }

    public String[] getPoliticalStatusArray() {
        return politicalStatusArray;
    }

    public void setPoliticalStatusArray(String[] politicalStatusArray) {
        this.politicalStatusArray = politicalStatusArray;
    }

    public String[] getFamily() {
        return family;
    }

    public void setFamily(String[] family) {
        this.family = family;
    }

    public String[] getEconomic() {
        return economic;
    }

    public void setEconomic(String[] economic) {
        this.economic = economic;
    }

    public String[] getIsHealth() {
        return isHealth;
    }

    public void setIsHealth(String[] isHealth) {
        this.isHealth = isHealth;
    }

    public String[] getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String[] intelligence) {
        this.intelligence = intelligence;
    }

    public String[] getEyesight() {
        return eyesight;
    }

    public void setEyesight(String[] eyesight) {
        this.eyesight = eyesight;
    }

    public String[] getOldStatusArray() {
        return oldStatusArray;
    }

    public void setOldStatusArray(String[] oldStatusArray) {
        this.oldStatusArray = oldStatusArray;
    }

    public Integer getIsFeedback() {
        return isFeedback;
    }

    public void setIsFeedback(Integer isFeedback) {
        this.isFeedback = isFeedback;
    }

    public String getWh() {
        return wh;
    }

    public void setWh(String wh) {
        this.wh = wh;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    public Integer getOrganId() {
        return organId;
    }

    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

    public LabelSec getLabelSec() {
        return labelSec;
    }

    public void setLabelSec(LabelSec labelSec) {
        this.labelSec = labelSec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
