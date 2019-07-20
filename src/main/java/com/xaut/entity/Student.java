package com.xaut.entity;

import java.util.Date;

public class Student {
	String sno;	//学号
	String sname;	//姓名
	String depart;	//专业
	String mailbox;	//邮箱
	Date updatetime;	//更新时间
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", depart=" + depart + ", mailbox=" + mailbox
				+ ", updatetime=" + updatetime + "]";
	}
}