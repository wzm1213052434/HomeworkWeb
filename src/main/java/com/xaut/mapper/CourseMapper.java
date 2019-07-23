package com.xaut.mapper;

import com.xaut.entity.Course;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 课程相关接口
 */
@Repository
public interface CourseMapper {

	/**
	 * 新增课程
	 * @param course
	 * @return
	 * @throws Exception
	 */
    public int addCourse(Course course) throws Exception;
    
	/**
	 * 查找老师的所有课程信息
	 * @param 老师的职工号tno
	 * @return
	 */
    public List<Course> findCourseByTeacherTno(String tno);
}