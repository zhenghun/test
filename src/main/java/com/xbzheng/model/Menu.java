package com.xbzheng.model;

/**
 * @Created by Administrator on 2015/8/3.
 */
public class Menu {
    private String id;
    private Menu parent;//���ڵ�
    private String parentIds;//���и��ڵ���
    private String name;//����
    private Integer sort;//����
    private String href;//����
    private String target;//Ŀ�� (mainFrame��_blank��_self��_parent��_top)
    private String icon;//ͼ��
    private String isShow;//�Ƿ���ʾ(1 ��ʾ��0 ����ʾ)
    private String permission; //Ȩ�ޱ�ʶ
    private String remarks;//˵��
    private String delFlag;//ɾ����ʶ


    public Menu(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", parent=" + parent +
                ", parentIds='" + parentIds + '\'' +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", href='" + href + '\'' +
                ", target='" + target + '\'' +
                ", icon='" + icon + '\'' +
                ", isShow='" + isShow + '\'' +
                ", permission='" + permission + '\'' +
                ", remarks='" + remarks + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
