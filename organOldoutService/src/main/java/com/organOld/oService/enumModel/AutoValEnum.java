package com.organOld.oService.enumModel;


public enum AutoValEnum {
    PQ("片区",1),//片区
    XQ("小区",2),//小区
    ZZMM("政治面貌",3),//政治面貌
    HJ("户籍",4),//户籍
    JJJG("家庭结构",5),//家庭结构
    JJTJ("经济条件",6),//经济条件
    SZ("失智",7),//失智
    SL("视力",8),//视力
    YJBQ("一级标签",9),//一级标签
    NL("年龄分布",10),
    WDT("无电梯楼层",11),
    JYLY("是否主动申请进养老院",12),
    ZC("职称",13),
    SQZW("社区职务",14),
    JTLB("家庭类别",15);
    private String name ;
    private int index ;

    AutoValEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (AutoValEnum d : AutoValEnum.values()) {
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
