package com.organOld.oService.enumModel;

public enum SignPeopleTypeEnum {
    L1("活动参与",1),L2("活动组织",2),L3("其他",3);

    private String name ;
    private int index ;

    SignPeopleTypeEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (SignPeopleTypeEnum d : SignPeopleTypeEnum.values()) {
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
