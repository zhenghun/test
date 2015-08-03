package com.xbzheng.model;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Created by Administrator on 2015/8/3.
 */
public class Role {
    private String id;
    private String officeId;//��������
    private String name;//��ɫ����
    private String enname;//Ӣ������
    private String roleType;//��ɫ����
    private String dataScope;//���ݷ�Χ
    private String isSys;//�Ƿ���ϵͳ����
    private String useable;//�Ƿ����
    private String remarks;//˵��
    private String delFlag;// �Ƿ���ɾ��(0 ɾ����1 û��ɾ��)
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
