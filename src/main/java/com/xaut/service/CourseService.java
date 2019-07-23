package com.xaut.service;

import java.util.List;
import com.xaut.entity.Course;

public interface CourseService {
	/**
	 * 查找老师的所有课程信息
	 * @param 老师的职工号tno
	 * @return
	 */
    public List<Course> findCourseByTeacherTno(String tno);
}