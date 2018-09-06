package com.organOld.dao.util;


import com.organOld.dao.entity.DBEntity;

/**
 * 分页
 * Created by netlab606 on 2018/4/2.
 */
public class Page<T extends DBEntity> {

    private int start; //起始位置
    private int length;//行数
    private String sort;//排序
    private String sortType;//根据哪个字段进行排序
    private T entity;//查找


    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
