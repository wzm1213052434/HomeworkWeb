package com.xaut.entity;

import java.util.Date;

/**
 * 学生类
 */
public class Student {

    /* 学号(主键) */
    private String sno;

    /* 学生姓名 */
    private String sName;

    /* 专业 */
    private String depart;

    /* 邮箱 */
    private String mailbox;

    /* 更新时间 */
    private Date updateTime;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sName=" + sName + ", depart=" + depart + ", mailbox=" + mailbox
				+ ", updateTime=" + updateTime + "]";
	}
}