package com.xaut.entity;

import java.util.Date;

/**
 * 教师类
 */
public class Teacher {

    /* 教师工号(主键唯一) */
    private String tno;

    /* 教师姓名 */
    private String tName;

    /* 教师所在学院 */
    private String company;
    
    /* 更新时间*/
    private Date updateTime;

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", tName=" + tName + ", company=" + company + ", updateTime=" + updateTime + "]";
	}
}