package com.xaut.entity;

import java.util.Date;

/**
 * Created by 旺旺
 * 2019/7/20 1:33
 * 作业类
 */
public class Work {

    /* 作业号(主键) */
    private String id;

    /* 课程号 */
    private String courseId;

    /* 作业名 */
    private String name;

    /* 作业描述 */
    private String description;

    /* 创建时间 */
    private Date createTime;

    /* 更新时间 */
    private Date updateTime;

    /* 结束时间 */
    private Date overTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id='" + id + '\'' +
                ", courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", overTime=" + overTime +
                '}';
    }
}
