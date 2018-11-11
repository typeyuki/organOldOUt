package com.organOld.oService.model;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.product.Product;

import java.util.List;

public class ProductBookModel {
    private int id;
    //private Oldman oldman;
    private String time;
    private String organName;
    private String name;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





//    public Oldman getOldman() {
//        return oldman;
//    }
//
//    public void setOldman(Oldman oldman) {
//        this.oldman = oldman;
//    }

}
