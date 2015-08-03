package com.xbzheng.model;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Created by Administrator on 2015/8/3.
 */
public class Role {
    private String id;
    private String officeId;//归属机构
    private String name;//角色名称
    private String enname;//英文名称
    private String roleType;//角色类型
    private String dataScope;//数据范围
    private String isSys;//是否是系统数据
    private String useable;//是否可用
    private String remarks;//说明
    private String delFlag;// 是否已删除(0 删除，1 没有删除)
    private User user;
    private List<Menu> menuList = Lists.newArrayList();

    public Role(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    public String getIsSys() {
        return isSys;
    }

    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }

    public String getUseable() {
        return useable;
    }

    public void setUseable(String useable) {
        this.useable = useable;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", officeId='" + officeId + '\'' +
                ", name='" + name + '\'' +
                ", enname='" + enname + '\'' +
                ", roleType='" + roleType + '\'' +
                ", dataScope='" + dataScope + '\'' +
                ", isSys='" + isSys + '\'' +
                ", useable='" + useable + '\'' +
                ", remarks='" + remarks + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
