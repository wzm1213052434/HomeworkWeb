package com.xaut.util;

/**
 * Created by 旺旺
 * 2019/7/29 23:19
 * 公共字符串,存放整个系统的公共字段信息
 */
public class CommonString {
	//1---分页相关
    public static final String PAGE = "page"; // 页码
    public static final String ROWS = "rows"; // 每页条数
    public static final String ZERO = "0";
    public static final String ONE = "1";
    public static final String TEN = "10";
    
    //2---系统角色
    public static final String ADMIN_FLAG = "1"; // 管理员角色
    public static final String SUPER_ADMIN_FLAG = "2"; // 超级管理员角色
    public static final String STUDENT_FLAG = "3"; // 学生角色
    public static final String TEACHER_FLAG = "4"; // 教师角色
    
    //3---账号信息
    public static final String LOCKED = "1"; // 账号锁定状态
    public static final String UN_LOCKED = "0"; // 账号未锁定状态
    public static final String DEFAULT_PASSWORD = "123456"; //默认密码
    
    //4---资源路径
    public static final String STUDENTHOMEWORKPATH = "E:\\HomeWorkWeb\\student\\work"; // 保存学生作业的路径
    public static final String TEACHERCOURSEPATH = "E:\\HomeWorkWeb\\teacher\\excel"; // 保存教师课程表的路径
    
    //5.系统错误
    public static final String ERROR_404 = "404";
    public static final String ERROR_500 = "500";
    public static final String ERROR_505 = "505";
}
