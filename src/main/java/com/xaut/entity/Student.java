package com.xaut.entity;

import java.util.Date;

/**
 * Created by 旺旺
 * 2019/7/20 1:28
 * 学生类
 */
public class Student {

    /* 学号(主键) */
    private String id;

    /* 学生姓名 */
    private String name;

    /* 专业 */
    private String major;

    /* 邮箱 */
    private String mail;

    /* 性别 */
    private String sex;

    /* 更新时间 */
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", mail='" + mail + '\'' +
                ", sex='" + sex + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
