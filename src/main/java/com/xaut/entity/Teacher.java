package com.xaut.entity;

import java.util.Date;

public class Teacher {
	String tno;	//教师工号
	String tname;	//姓名
	String company;	//学院
	Date updatetime;	//更新时间
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", tname=" + tname + ", company=" + company + ", updatetime=" + updatetime + "]";
	}
}