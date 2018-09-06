package com.organOld.oService.enumModel;

//通用 是否
public enum LogsTypeEnum {
    CONSUME("消费记录",1),SIGN("签到记录",2),INFO("老人信息查询记录",3),IN("老人积分查询记录",4),
    CQ("充钱",5),GS("挂失",6),BKY("不可用",7),KY("可用",8),JF("积分记录",9);

    private String name ;
    private int index ;

    LogsTypeEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (LogsTypeEnum d : LogsTypeEnum.values()) {
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
