package com.xaut.mapper;

import com.xaut.entity.Course;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 课程相关接口
 */
@Repository
public interface CourseMapper {

	/**
     * 功能：新增课程
     * @param course
     */
    public void addCourse(Course course);
    
    /**
     * 功能：删除课程
     * @param cno
     */
    public void deleteCourse(String cno);
    
	/**
	 * 查找教师所开的课程信息
	 * @param tno
	 * @return 教师所开的课程集合
	 */
    public List<Course> findCourseByTeacherTno(@Param("tno") String tno) throws Exception;

	/**
	 * 获取所有课程
	 * @return
	 * @throws Exception
	 */
    public List<Map<String, Object>> getAllCourse() throws Exception;
}