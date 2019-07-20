package com.xaut.entity;

import java.util.Date;

public class Announcement {
	String ano;	//公告号
	String cno;	//课程号
	String aname;	//公告名称
	String desc;	//公告描述
	Date occurtime;	//发布时间
	Date updatetime;	//更新时间
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getOccurtime() {
		return occurtime;
	}

	public void setOccurtime(Date occurtime) {
		this.occurtime = occurtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	@Override
	public String toString() {
		return "Announcement [ano=" + ano + ", cno=" + cno + ", aname=" + aname + ", desc=" + desc + ", occurtime="
				+ occurtime + ", updatetime=" + updatetime + "]";
	}
}