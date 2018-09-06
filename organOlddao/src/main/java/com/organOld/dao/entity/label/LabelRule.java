package com.organOld.dao.entity.label;


import com.organOld.dao.entity.DBEntity;

//规则绑定标签
public class LabelRule extends DBEntity {

    private int labelId;

    private int ageStart;
    private int ageEnd;
    private String districtIds;
    private String jwIds;
    private int sex;
    private String censuses;
    private String politicalStatuses;
    private int isKey;
    private String economics;
    private String families;
    private String familyTypes;
    private String intelligences;
    private String eyesights;
    private String isHealths;
    private String chxs;
    private String oldStatuses;
    private String zcs;
    private String sqzws;


    public String getFamilyTypes() {
        return familyTypes;
    }

    public void setFamilyTypes(String familyTypes) {
        this.familyTypes = familyTypes;
    }

    public String getZcs() {
        return zcs;
    }

    public void setZcs(String zcs) {
        this.zcs = zcs;
    }

    public String getSqzws() {
        return sqzws;
    }

    public void setSqzws(String sqzws) {
        this.sqzws = sqzws;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public String getJwIds() {
        return jwIds;
    }

    public void setJwIds(String jwIds) {
        this.jwIds = jwIds;
    }

    public String getChxs() {
        return chxs;
    }

    public void setChxs(String chxs) {
        this.chxs = chxs;
    }

    public String getOldStatuses() {
        return oldStatuses;
    }

    public void setOldStatuses(String oldStatuses) {
        this.oldStatuses = oldStatuses;
    }

    public int getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(int ageStart) {
        this.ageStart = ageStart;
    }

    public int getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(int ageEnd) {
        this.ageEnd = ageEnd;
    }

    public String getDistrictIds() {
        return districtIds;
    }

    public void setDistrictIds(String districtIds) {
        this.districtIds = districtIds;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCensuses() {
        return censuses;
    }

    public void setCensuses(String censuses) {
        this.censuses = censuses;
    }

    public String getPoliticalStatuses() {
        return politicalStatuses;
    }

    public void setPoliticalStatuses(String politicalStatuses) {
        this.politicalStatuses = politicalStatuses;
    }

    public int getIsKey() {
        return isKey;
    }

    public void setIsKey(int isKey) {
        this.isKey = isKey;
    }

    public String getEconomics() {
        return economics;
    }

    public void setEconomics(String economics) {
        this.economics = economics;
    }

    public String getFamilies() {
        return families;
    }

    public void setFamilies(String families) {
        this.families = families;
    }

    public String getIntelligences() {
        return intelligences;
    }

    public void setIntelligences(String intelligences) {
        this.intelligences = intelligences;
    }

    public String getEyesights() {
        return eyesights;
    }

    public void setEyesights(String eyesights) {
        this.eyesights = eyesights;
    }

    public String getIsHealths() {
        return isHealths;
    }

    public void setIsHealths(String isHealths) {
        this.isHealths = isHealths;
    }
}
