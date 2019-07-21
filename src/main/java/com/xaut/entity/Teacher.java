package com.xaut.entity;

import java.util.Date;

/**
 * Created by 旺旺
 * 2019/7/20 1:30
 * 教师类
 */
public class Teacher {

    /* 教师工号(主键唯一) */
    private String id;

    /* 教师姓名 */
    private String name;

    /* 教师所在学院 */
    private String college;
    /* 更新时间*/
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
