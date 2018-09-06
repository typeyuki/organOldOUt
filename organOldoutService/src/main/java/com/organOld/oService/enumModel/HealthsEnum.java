package com.organOld.oService.enumModel;


public enum HealthsEnum {

    MB("慢病",1),//慢病
    SN("失能",2),//失能
    YW("药物反应",3),//药物反应
    EXZL("恶性肿瘤史",4),//恶性肿瘤史
    GZ("骨折史",5),//骨折史
    CJQK("残疾情况",6);//残疾情况
    private String name ;
    private int index ;

    HealthsEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (HealthsEnum d : HealthsEnum.values()) {
            if (d.getIndex() == index) {
                return d.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
