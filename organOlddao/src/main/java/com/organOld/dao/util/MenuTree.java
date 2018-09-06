package com.organOld.dao.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单树
 * Created by netlab606 on 2017/6/30.
 */
public class MenuTree {
    private int id;				//节点的ID
    private String name;		//节点显示的文字
    private String url;			// url
    private List<MenuTree> children=new ArrayList<MenuTree>();		//定义了一些子节点的节点数组
    private int pid;					//定义该节点的父节点
    private String icon;//图标
    private int sequence;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public List<MenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
