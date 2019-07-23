package com.xaut.entity;

import java.util.Date;

/**
 * Created by 旺旺
 * 2019/7/21 1:12
 * 课程类
 */
public class Course {

    /* 课程id(主键) */
    private String id;

    /* 教职工id */
    private String teacherId;

    /* 课程名 */
    private String courseName;

    /* 学年 */
    private String year;

    /* 学期 */
    private String term;

    /* 上课时间 */
    private String courseTime;

    /* 上课地点 */
    private String courseAddress;

    /* 是否结课(0为未结课,1为已结课),默认为0 */
    private String isOver;

    /* 选课表名 */
    private String tableName;

    /* 更新时间 */
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseAddress() {
        return courseAddress;
    }

    public void setCourseAddress(String courseAddress) {
        this.courseAddress = courseAddress;
    }

    public String getIsOver() {
        return isOver;
    }

    public void setIsOver(String isOver) {
        this.isOver = isOver;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", year='" + year + '\'' +
                ", term='" + term + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", courseAddress='" + courseAddress + '\'' +
                ", isOver='" + isOver + '\'' +
                ", tableName='" + tableName + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
