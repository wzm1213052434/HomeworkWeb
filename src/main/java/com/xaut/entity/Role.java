package com.xaut.entity;

import java.util.Date;

/**
 * Created by 旺旺
 * 2019/7/20 1:25
 * 角色类
 */
public class Role {

    /* 角色(主键) */
    private String id;

    /* 角色名称 */
    private String roleName;

    /* 角色标记 */
    private String roleFlag;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(String roleFlag) {
        this.roleFlag = roleFlag;
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
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleFlag='" + roleFlag + '\'' +
                ", isAvailable='" + isAvailable + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
