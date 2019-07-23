package com.xaut.entity;

import java.util.Date;

/**
 * Created by 旺旺
 * 2019/7/20 1:22
 *权限类
 */
public class Permission {

    /* 权限编号(主键) */
    private String id;

    /* 权限名称 */
    private String permissionName;

    /* 权限标记 */
    private String permissionFlag;

    /* 是否可用(0为不可用,1为可用),默认为1 */
    private String isAvailable;

    /* 更新时间 */
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionFlag() {
        return permissionFlag;
    }

    public void setPermissionFlag(String permissionFlag) {
        this.permissionFlag = permissionFlag;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", permissionFlag='" + permissionFlag + '\'' +
                ", isAvailable='" + isAvailable + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
