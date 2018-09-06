package com.organOld.oService.enumModel;


public enum OrganiFirEnum {

    ZF("政府机构",1),
    JGYL("机构养老",21),
    SQYL("社区养老",22),
    SH("社会涉老机构",3);
    private String name ;
    private int index ;

    OrganiFirEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (OrganiFirEnum d : OrganiFirEnum.values()) {
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
