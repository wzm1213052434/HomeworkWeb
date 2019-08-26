package com.xaut.service;

import com.xaut.util.ResponseBean;

public interface CourseService {
	/**
	 * 查找教师所开的课程信息
	 * @param tno 教师职工号
	 * @return
	 */
    ResponseBean findCourseByTeacherTno(String tno);

	/**
	 * 根据课程名分页获取课程
	 * @param courseName
	 * @param page
	 * @param rows
	 * @return
	 */
    ResponseBean getAllCourse(String courseName, Integer page, Integer rows);
    
    /**
     * function:学生本院老师已开课程
     * @param username
     * @return 课程名 开课学期 开课学年 开课老师 老师学院
     */
    ResponseBean getOurCollegeCourse(String username);
    
    /**
     * function:课程的详细信息
     * @param cno
     * @return
     */
    ResponseBean getCourseDetail(String cno);
}