package com.xaut.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色实体类
 */
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String rname;
	private String sn;
	private boolean available;
	private Date createtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", rname=" + rname + ", sn=" + sn + ", available=" + available + ", createtime="
				+ createtime + "]";
	}
}
