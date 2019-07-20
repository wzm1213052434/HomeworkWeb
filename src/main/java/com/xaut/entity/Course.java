package com.xaut.entity;

import java.util.Date;

public class Course {
	String cno;	//课程号
	String tno;	//教职工号
	String cname;	//课程名
	String year;	//学年
	String term;	//学期
	String time;	//上课时间
	String place;	//上课地点
	Boolean state;	//是否结课
	String stablename;	//选课表名
	Date updatetime;	//更新时间
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public String getStablename() {
		return stablename;
	}
	public void setStablename(String stablename) {
		this.stablename = stablename;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public String toString() {
		return "Course [cno=" + cno + ", tno=" + tno + ", cname=" + cname + ", year=" + year + ", term=" + term
				+ ", time=" + time + ", place=" + place + ", state=" + state + ", stablename=" + stablename
				+ ", updatetime=" + updatetime + "]";
	}
}