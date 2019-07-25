package com.xaut.service;

import com.xaut.util.ResponseBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xaut.service.impl.CourseServiceImpl;

/*
 * 单元测试
 */
public class CourseServiceTest {

	/**
	 * 测试查找老师的所有课程信息
	 */
	@Test
	public void findCourseByTeacherTnoTest() {
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		CourseServiceImpl courseServiceImpl = act.getBean(CourseServiceImpl.class);

		ResponseBean bean = courseServiceImpl.findCourseByTeacherTno("123456");

		System.out.println(bean);
	}
}