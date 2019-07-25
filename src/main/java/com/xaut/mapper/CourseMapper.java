package com.xaut.mapper;

import com.xaut.entity.Course;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	 * 查找教师所开的课程信息
	 * @param tno 教师职工号
	 * @return
	 */
    public List<Course> findCourseByTeacherTno(@Param("tno") String tno) throws Exception;
}