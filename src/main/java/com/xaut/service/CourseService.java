package com.xaut.service;

import com.xaut.util.ResponseBean;

public interface CourseService {
	/**
	 * 查找教师所开的课程信息
	 * @param tno 教师职工号
	 * @return
	 */
    public ResponseBean findCourseByTeacherTno(String tno);

	/**
	 * 根据课程名分页获取课程
	 * @param courseName
	 * @param page
	 * @param rows
	 * @return
	 */
    public ResponseBean getAllCourse(String courseName, Integer page, Integer rows);
}