package com.xbzheng.model;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * @author hun
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    private String userName;
    private String password;
    private String loginName;
    private String loginFlag;
    private Role role;
    private List<Role> roleList = Lists.newArrayList();

    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(final String loginName) {
        this.loginName = loginName;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(final String loginFlag) {
        this.loginFlag = loginFlag;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(final List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", loginName='" + loginName + '\'' +
                '}';
    }
}
