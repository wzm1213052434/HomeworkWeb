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
	 * 根据课程名分页获取课程
	 * @param courseName
	 * @param startPage
	 * @param rows
	 * @return
	 * @throws Exception
	 */
    public List<Map<String, Object>> getAllCourse(@Param("courseName") String courseName,
												  @Param("startPage") Integer startPage,
												  @Param("rows") Integer rows) throws Exception;
}