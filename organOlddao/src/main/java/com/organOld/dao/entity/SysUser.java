package com.organOld.dao.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * 账号
 * Created by netlab606 on 2018/4/8.
 */
public class SysUser extends DBEntity implements UserDetails,Serializable{
    private String username;
    private String password;

    private String organName;//对应的机构名
    private Integer organId;
    private Integer roleId;
    private Integer authConsume;
    private Integer authProduct;
    private Integer authSign;
    private Integer authQueryInfo;
    private Integer authQueryIntegral;
    private Integer disable;
    private String desc;

    Collection<GrantedAuthority> authorities;

    private String search;


    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Override
    public int hashCode() {
        return id*31;
    }

    @Override
    public boolean equals(Object obj) {
        return this.username.equals(((SysUser)obj).getUsername());
    }


    public Integer getAuthConsume() {
        return authConsume;
    }

    public void setAuthConsume(Integer authConsume) {
        this.authConsume = authConsume;
    }

    public Integer getAuthProduct() {
        return authProduct;
    }

    public void setAuthProduct(Integer authProduct) {
        this.authProduct = authProduct;
    }

    public Integer getAuthSign() {
        return authSign;
    }

    public void setAuthSign(Integer authSign) {
        this.authSign = authSign;
    }

    public Integer getAuthQueryInfo() {
        return authQueryInfo;
    }

    public void setAuthQueryInfo(Integer authQueryInfo) {
        this.authQueryInfo = authQueryInfo;
    }

    public Integer getAuthQueryIntegral() {
        return authQueryIntegral;
    }

    public void setAuthQueryIntegral(Integer authQueryIntegral) {
        this.authQueryIntegral = authQueryIntegral;
    }

    public Integer getOrganId() {
        return organId;
    }

    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
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

}
