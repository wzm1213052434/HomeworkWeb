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
    void addCourse(Course course);
    
    /**
     * 功能：删除课程
     * @param cno
     */
    void deleteCourse(String cno);
    
	/**
	 * 查找教师所开的课程信息
	 * @param tno
	 * @return 教师所开的课程集合
	 */
    List<Course> findCourseByTeacherTno(@Param("tno") String tno) throws Exception;

	/**
	 * 根据课程名分页获取课程
	 * @param courseName
	 * @param startPage
	 * @param rows
	 * @return
	 * @throws Exception
	 */
    List<Map<String, Object>> getAllCourse(@Param("courseName") String courseName,
												  @Param("startPage") Integer startPage,
												  @Param("rows") Integer rows) throws Exception;

    /**
     * 为分页查询课程提供总数
     * @return
     * @throws Exception
     */
    int countCourse() throws Exception;
    
    /**
     * 为分页模糊查询课程提供总数
     * @return
     * @throws Exception
     */
    int countVagueCourse(@Param("courseName") String courseName);
    
    /**
     * function:学生本院老师已开课程
     * @param username
     * @return 课程名 开课学期 开课学年 开课老师 老师学院
     */
    List<Map<String, Object>> getOurCollegeCourse(@Param("username") String username);
}