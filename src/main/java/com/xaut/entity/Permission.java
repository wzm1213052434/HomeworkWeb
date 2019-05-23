package com.xaut.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限实体类
 */
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String pname;
	private String resource;
	private boolean available;
	private Date createtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
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
		return "Permission [id=" + id + ", pname=" + pname + ", resource=" + resource + ", available=" + available
				+ ", createtime=" + createtime + "]";
	}
}
