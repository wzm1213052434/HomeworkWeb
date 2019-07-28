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
	 * 获取所有课程信息
	 * @return
	 */
    public ResponseBean getAllCourse();
}