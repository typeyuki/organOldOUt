package com.organOld.oService.enumModel;

public enum LabelTypeEnum {
    L1("老有所养",1),L2("老有所医",2),L3("老有所乐",3),L4("老有所为",4),
    L5("老有所学",5);

    private String name ;
    private int index ;

    LabelTypeEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (LabelTypeEnum d : LabelTypeEnum.values()) {
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
