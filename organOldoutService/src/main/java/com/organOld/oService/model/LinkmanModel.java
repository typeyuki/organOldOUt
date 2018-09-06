package com.organOld.oService.model;


public class LinkmanModel extends MenModel {
    private String relation;
    private String oldman;

    public String getOldman() {
        return oldman;
    }

    public void setOldman(String oldman) {
        this.oldman = oldman;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
