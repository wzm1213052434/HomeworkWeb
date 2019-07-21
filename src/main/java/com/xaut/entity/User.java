package com.xaut.entity;

import java.util.Date;

/**
 * Created by 旺旺
 * 2019/7/21 1:07
 * 用户类
 */
public class User {

    /* 主键 */
    private String id;

    /* 用户名 */
    private String userName;

    /* 密码 */
    private String passWord;

    /* 账号类型 */
    private String flag;

    /* 加盐 */
    private String salt;

    /* 是否锁定,0为未锁定,1为锁定,默认为0 */
    private String isLocked;

    /* 更新时间 */
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", flag='" + flag + '\'' +
                ", salt='" + salt + '\'' +
                ", isLocked='" + isLocked + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
