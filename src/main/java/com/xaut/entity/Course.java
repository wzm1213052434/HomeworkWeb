package com.xaut.entity;

import java.util.Date;

/**
 * 课程类
 */
public class Course {

    /* 课程号 */
    private String cno;

    /* 教职工号 */
    private String tno;

    /* 课程名 */
    private String cname;

    /* 学年 */
    private String year;

    /* 学期 */
    private String term;

    /* 上课时间 */
    private String time;

    /* 上课地点 */
    private String place;

    /* 是否结课(0为未结课,1为已结课),默认为0 */
    private String state;

    /* 选课表名 */
    private String stableName;

    /* 更新时间 */
    private Date updateTime;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTableName() {
		return stableName;
	}

	public void setTableName(String stableName) {
		this.stableName = stableName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Course [cno=" + cno + ", tno=" + tno + ", cname=" + cname + ", year=" + year + ", term=" + term
				+ ", time=" + time + ", place=" + place + ", state=" + state + ", tableName=" + stableName
				+ ", updateTime=" + updateTime + "]";
	}
}