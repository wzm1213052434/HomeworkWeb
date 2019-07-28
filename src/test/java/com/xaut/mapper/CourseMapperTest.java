package com.xaut.mapper;

import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xaut.entity.Course;

/*
 * 单元测试
 */
public class CourseMapperTest {
	/**
	 * 测试通过用户id查找用户对象
	 */
	@Test
	public void findCourseByTeacherTno() {
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		CourseMapper courseMapper = act.getBean(CourseMapper.class);
		
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