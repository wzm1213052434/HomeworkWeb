package com.xaut.service;

import java.util.List;
import com.xaut.entity.Course;
import com.xaut.util.ResponseBean;

public interface CourseService {
	/**
	 * 查找教师所开的课程信息
	 * @param tno 教师职工号
	 * @return
	 */
    public ResponseBean findCourseByTeacherTno(String tno);
}