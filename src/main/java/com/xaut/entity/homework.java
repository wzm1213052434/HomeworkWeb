package com.xaut.entity;

import java.util.Date;

public class homework {
	String wno;	//作业号
	String cno;	//课程号
	String wname;	//作业名
	String desc;	//作业描述
	Date start_time;	//发布时间
	Date end_time;	//结束时间
	Date updatetime;	//更新时间
	public String getWno() {
		return wno;
	}
	public void setWno(String wno) {
		this.wno = wno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public String toString() {
		return "homework [wno=" + wno + ", cno=" + cno + ", wname=" + wname + ", desc=" + desc + ", start_time="
				+ start_time + ", end_time=" + end_time + ", updatetime=" + updatetime + "]";
	}
}