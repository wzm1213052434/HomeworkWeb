package com.xaut.service.impl;

import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xaut.entity.Course;
import com.xaut.service.impl.CourseServiceImpl;

/*
 * 单元测试
 */
public class CourseServiceImplTest {

	/**
	 * 测试查找老师的所有课程信息
	 */
	@Test
	public void findCourseByTeacherTnoTest() {
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		CourseServiceImpl courseServiceImpl = act.getBean(CourseServiceImpl.class);
		
		List<Course> course = courseServiceImpl.findCourseByTeacherTno("104496");
		for (Course c : course) {
			System.out.println(c);
		}
	}
}