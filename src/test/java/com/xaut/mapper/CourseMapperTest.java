package com.xaut.mapper;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xaut.entity.Course;

/*
 * 单元测试
 */
public class CourseMapperTest {
	
	//从Spring容器中获取CourseMapper
	ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	CourseMapper courseMapper = act.getBean(CourseMapper.class);
	
	/**
	 * 测试：新增课程
	 */
	@Test
	public void addStudentTest() {
		Course course = new Course();
		course.setCno("(2017-2018-2)-09191430-104496-7");
		course.setTno("123456");
		course.setcName("Python");
		course.setYear("2017-2018");
		course.setTerm("1");
		course.setTime("周二第1,2节{第1-12周}；周五第7,8节{第1-12周}");
		course.setPlace("曲江10-217；曲江10-217");
		course.setState("0");
		course.setTableName("(2017-2018-2)-09191430-104496-31dmc.xls");
		course.setUpdateTime(new java.sql.Date(new Date().getTime()));
		
		try {
			courseMapper.addCourse(course);
			System.out.println("新增课程成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试：删除课程
	 */
	@Test
	public void deleteStudentTest() {
		courseMapper.deleteCourse("(2017-2018-2)-09191430-104496-7");
		System.out.println("删除课程成功");
	}
	
	/**
	 * 测试：通过用户id查找用户对象
	 */
	@Test
	public void findCourseByTeacherTno() {
		try {
			List<Course> course = courseMapper.findCourseByTeacherTno("104496");
			for (Course c : course) {
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}