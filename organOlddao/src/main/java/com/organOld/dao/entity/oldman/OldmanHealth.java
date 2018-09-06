package com.organOld.dao.entity.oldman;


import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.XqInterface;

import java.util.List;

/**
 * 老人健康档案
 */
public class OldmanHealth extends DBEntity implements DBInterface,XqInterface{

    private String bloodType;
    private String intelligence;//失智
    private String eyesight;//视力
    private List<HealthAdd> healthAdd;
    private List<HealthSelect> healthSelect;
    //TODO 选取所有表格中最新的一个时间  暂时还没实现
    private Oldman oldman;

//    值与健康表  类型的索引一直  用于规则制定标签筛选
    private int isMb;
    private int isSn;
    private int isYwfy;
    private int isExzl;
    private int isGz;
    private int isCj;





    private String search;//模糊搜索
    private Integer oldmanId;
    private Integer organId;//居委Id
    private List<Integer> xqIds;

    /**
     * 接受更新的
     * @return
     */
    private List<String> healthAdd_exzl;
    private List<String> healthAdd_gz;
    private List<String> healthAdd_cj;
    private List<Integer> healthSelectIds;

    @Override
    public List<Integer> getXqIds() {
        return xqIds;
    }

    @Override
    public void setXqIds(List<Integer> xqIds) {
        this.xqIds = xqIds;
    }

    public List<Integer> getHealthSelectIds() {
        return healthSelectIds;
    }

    public void setHealthSelectIds(List<Integer> healthSelectIds) {
        this.healthSelectIds = healthSelectIds;
    }

    public List<String> getHealthAdd_exzl() {
        return healthAdd_exzl;
    }

    public void setHealthAdd_exzl(List<String> healthAdd_exzl) {
        this.healthAdd_exzl = healthAdd_exzl;
    }

    public List<String> getHealthAdd_gz() {
        return healthAdd_gz;
    }

    public void setHealthAdd_gz(List<String> healthAdd_gz) {
        this.healthAdd_gz = healthAdd_gz;
    }

    public List<String> getHealthAdd_cj() {
        return healthAdd_cj;
    }

    public void setHealthAdd_cj(List<String> healthAdd_cj) {
        this.healthAdd_cj = healthAdd_cj;
    }

    public int getIsMb() {
        return isMb;
    }

    public void setIsMb(int isMb) {
        this.isMb = isMb;
    }

    public int getIsSn() {
        return isSn;
    }

    public void setIsSn(int isSn) {
        this.isSn = isSn;
    }

    public int getIsYwfy() {
        return isYwfy;
    }

    public void setIsYwfy(int isYwfy) {
        this.isYwfy = isYwfy;
    }

    public int getIsExzl() {
        return isExzl;
    }

    public void setIsExzl(int isExzl) {
        this.isExzl = isExzl;
    }

    public int getIsGz() {
        return isGz;
    }

    public void setIsGz(int isGz) {
        this.isGz = isGz;
    }

    public int getIsCj() {
        return isCj;
    }

    public void setIsCj(int isCj) {
        this.isCj = isCj;
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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getEyesight() {
        return eyesight;
    }

    public void setEyesight(String eyesight) {
        this.eyesight = eyesight;
    }

    public List<HealthAdd> getHealthAdd() {
        return healthAdd;
    }

    public void setHealthAdd(List<HealthAdd> healthAdd) {
        this.healthAdd = healthAdd;
    }

    public List<HealthSelect> getHealthSelect() {
        return healthSelect;
    }

    public void setHealthSelect(List<HealthSelect> healthSelect) {
        this.healthSelect = healthSelect;
    }
}
