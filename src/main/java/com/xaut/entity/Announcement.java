package com.xaut.entity;

import java.util.Date;

public class Announcement {
	/* 公告号 */
	private String ano;
	
	/* 课程号 */
	private String cno;
	
	/* 公告名 */
	private String aName;
	
	/* 描述 */
	private String desc;
	
	/* 发布时间 */
	private Date occurTime;
	
	/* 更新时间 */
	private Date updateTime;

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

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Announcement [ano=" + ano + ", cno=" + cno + ", aName=" + aName + ", desc=" + desc + ", occurTime="
				+ occurTime + ", updateTime=" + updateTime + "]";
	}
}