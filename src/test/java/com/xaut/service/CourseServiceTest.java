package com.xaut.service;

import com.xaut.util.HandleJSON;
import com.xaut.util.ResponseBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.xaut.service.CourseService;

/**
 * 单元测试
 */
public class CourseServiceTest {
	
	ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	CourseService courseService = act.getBean(CourseService.class);
	
	/**
	 * 测试：查找老师的所有课程信息
	 */
	@Test
	public void findCourseByTeacherTnoTest() {
		ResponseBean bean = courseService.findCourseByTeacherTno("123456");
		String jsonString = JSON.toJSONString(bean); //将JSON对象	转化为	JSON字符串
		System.out.println(new HandleJSON().print_JSON(jsonString)); //将JSON字符串格式化输出
	}
}