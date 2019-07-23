package com.xaut.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xaut.entity.Course;
import com.xaut.mapper.CourseMapper;

@Service
public class CourseServiceImpl {
	@Autowired
	private CourseMapper courseMapper;
	
	/**
	 * 查找老师的所有课程信息
	 * @param 老师的职工号tno
	 * @return
	 */
    public List<Course> findCourseByTeacherTno(String tno){
    	return this.courseMapper.findCourseByTeacherTno(tno);
    }
}