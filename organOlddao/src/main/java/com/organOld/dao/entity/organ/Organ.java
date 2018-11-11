package com.organOld.dao.entity.organ;

import com.organOld.dao.entity.DBEntity;

import java.util.List;

/**
 * Created by netlab606 on 2018/6/16.
 */
public class Organ extends DBEntity {
    private Integer organTypeId;
    private String organType;
    private String name;
    private String intro;
    private String work;
    private String serviceTime;
    private String address;
    private String phone;
    private String webUrl;
    private String imgUrl;
    private Integer num;
    private String require;
    private String institution;
    private Integer numIn;
    private Integer numRemain;
    private String districtId;//所属片区 如果有的话
    private String districtName;//所属片区名称 如果有的话
    private String status;
    private Integer parent;

    private Integer authConsume;
    private Integer authProduct;
    private Integer authSign;
    private Integer authQueryInfo;
    private Integer authQueryIntegral;

    private Integer mapX;
    private Integer mapY;
    private String mapTop;
    private String mapLeft;

    private String organNum;//床位号 0表示排队   助餐点无排队
    private String applyTime;//主动申请的时间
    /**
     * 搜索
     * @return
     */
    private Integer organFirTypeId;//一级类型ID
    private String search;//模糊搜索
    private Integer oldmanId;

    public Integer getMapX() {
        return mapX;
    }

    public void setMapX(Integer mapX) {
        this.mapX = mapX;
    }

    public Integer getMapY() {
        return mapY;
    }

    public void setMapY(Integer mapY) {
        this.mapY = mapY;
    }

    public String getMapTop() {
        return mapTop;
    }

    public void setMap_top(String mapTop) {
        this.mapTop = mapTop;
    }

    public String getMapLeft() {
        return mapLeft;
    }

    public void setMapLeft(String mapLeft) {
        this.mapLeft = mapLeft;
    }

    public Organ (){

    }
    public Organ (int id){
        super(id);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organ organ = (Organ) o;

        return id == organ.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getOrganNum() {
        return organNum;
    }

    public void setOrganNum(String organNum) {
        this.organNum = organNum;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getAuthQueryInfo() {
        return authQueryInfo;
    }

    public void setAuthQueryInfo(Integer authQueryInfo) {
        this.authQueryInfo = authQueryInfo;
    }

    public Integer getAuthQueryIntegral() {
        return authQueryIntegral;
    }

    public void setAuthQueryIntegral(Integer authQueryIntegral) {
        this.authQueryIntegral = authQueryIntegral;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public Integer getAuthConsume() {
        return authConsume;
    }

    public void setAuthConsume(Integer authConsume) {
        this.authConsume = authConsume;
    }

    public Integer getAuthProduct() {
        return authProduct;
    }

    public void setAuthProduct(Integer authProduct) {
        this.authProduct = authProduct;
    }

    public Integer getAuthSign() {
        return authSign;
    }

    public void setAuthSign(Integer authSign) {
        this.authSign = authSign;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

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

    public Integer getOrganFirTypeId() {
        return organFirTypeId;
    }

    public void setOrganFirTypeId(Integer organFirTypeId) {
        this.organFirTypeId = organFirTypeId;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOrganType() {
        return organType;
    }

    public void setOrganType(String organType) {
        this.organType = organType;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }


    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Integer getNumIn() {
        return numIn;
    }

    public void setNumIn(Integer numIn) {
        this.numIn = numIn;
    }

    public Integer getNumRemain() {
        return numRemain;
    }

    public void setNumRemain(Integer numRemain) {
        this.numRemain = numRemain;
    }


    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
