package com.xaut.entity;

import java.util.Date;

/**
 * 作业类
 */
public class Work {

    /* 作业号(主键) */
    private String wno;

    /* 课程号 */
    private String cno;

    /* 作业名 */
    private String wName;

    /* 作业描述 */
    private String desc;

    /* 开始时间 */
    private Date start_time;

    /* 结束时间 */
    private Date end_time;
    
    /* 更新时间 */
    private Date updateTime;

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

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Work [wno=" + wno + ", cno=" + cno + ", wName=" + wName + ", desc=" + desc + ", start_time="
				+ start_time + ", end_time=" + end_time + ", updateTime=" + updateTime + "]";
	}
}