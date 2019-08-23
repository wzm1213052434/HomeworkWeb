package com.xaut.service;

import com.xaut.util.ResponseBean;

public interface TeacherService {
	/**
     * function:根据学号获得已选课程老师
     * @param username
     * @return 教师名 所属院系 开课数
     */
	ResponseBean getTeacherByUsername(String username);
	
	/**
     * function:根据学号获得本院老师
     * @param username
     * @return 教师名 所属院系 开课数
     */
	ResponseBean getCollegeTeacherByUsername(String username);
}