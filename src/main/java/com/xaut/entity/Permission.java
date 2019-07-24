package com.xaut.entity;

import java.util.Date;

/**
 *权限类
 */
public class Permission {

    /* 权限编号(主键) */
    private String id;

    /* 权限名称 */
    private String pName;

    /* 权限标记 */
    private String resource;

    /* 是否可用(0为不可用,1为可用),默认为1 */
    private String available;

    /* 更新时间 */
    private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", pName=" + pName + ", resource=" + resource + ", available=" + available
				+ ", updateTime=" + updateTime + "]";
	}
}