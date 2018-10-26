package com.organOld.dao.entity;

import com.organOld.dao.entity.oldman.Oldman;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * 一卡通
 * Created by netlab606 on 2018/7/16.
 */
public class Card extends DBEntity implements UserDetails,Serializable {
    private Integer oldmanId;
    private String cid;//身份证后六位
    private String password;
    private Double money;
    private Integer status;
    private Oldman oldman;
    private Integer isCreate;
    Collection<GrantedAuthority> authorities;

    private String search;


    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getIsCreate() {
        return isCreate;
    }

    public void setIsCreate(Integer isCreate) {
        this.isCreate = isCreate;
    }

    public Oldman getOldman() {
        return oldman;
    }

    public void setOldman(Oldman oldman) {
        this.oldman = oldman;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public int hashCode() {
        return id*31;
    }

    @Override
    public boolean equals(Object obj) {
        return this.cid.equals(((SysUser)obj).getUsername());
    }

    @Override
    public String getUsername() {
        return cid;
    }

    public void setUsername(String username) {
        this.cid = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
