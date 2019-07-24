package com.xaut.entity;

import java.util.Date;

/**
 * 角色类
 */
public class Role {

    /* 角色(主键) */
    private String id;

    /* 角色名称 */
    private String rName;

    /* 角色标记 */
    private String sn;

    /* 是否可用(0为不可用,1为可用),默认为1 */
    private String available;

    /* 更新时间 */
    private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", rName=" + rName + ", sn=" + sn + ", available=" + available + ", createTime="
				+ createTime + "]";
	}
}