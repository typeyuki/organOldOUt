package com.organOld.oService.enumModel;

//性别
public enum MessageEnum {
    XT("系统消息",1),FWBT("服务平台反馈",2);

    private String name ;
    private int index ;

    MessageEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (MessageEnum d : MessageEnum.values()) {
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
