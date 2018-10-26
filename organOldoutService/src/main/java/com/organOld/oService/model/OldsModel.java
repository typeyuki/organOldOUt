package com.organOld.oService.model;


import java.util.ArrayList;
import java.util.List;

public class OldsModel extends MenModel {
    private Integer integral;
    private String sex;
    private String census;//户籍
    private Integer age;//年龄
    private String politicalStatus;//政治面貌
    private String address;//地址
    private String idNum;//身份证号码
    private String buildNum;//楼号
    private String neighbour;//小区名称
    private String neiboCom;//居委名称
    private String area;//片区名称
    private List<String> family = new ArrayList<>();//家庭结构
    private List<String> economic = new ArrayList<>();//经济条件


    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    // private List<String> familyType=new ArrayList<>();
    //    private List<LabelManInfoModel> labelManInfoModelList;
    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getBuildNum() {
        return buildNum;
    }

    public void setBuildNum(String buildNum) {
        this.buildNum = buildNum;
    }

    public String getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(String neighbour) {
        this.neighbour = neighbour;
    }

    public String getNeiboCom() {
        return neiboCom;
    }

    public void setNeiboCom(String neiboCom) {
        this.neiboCom = neiboCom;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<String> getFamily() {
        return family;
    }

    public void setFamily(List<String> family) {
        this.family = family;
    }

    public List<String> getEconomic() {
        return economic;
    }

    public void setEconomic(List<String> economic) {
        this.economic = economic;
    }
//    public List<String> getFamilyType() {
//        return familyType;
//    }
//
//    public void setFamilyType(List<String> familyType) {
//        this.familyType = familyType;
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCensus() {
        return census;
    }

    public void setCensus(String census) {
        this.census = census;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

}
