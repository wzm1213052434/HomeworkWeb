package com.xaut.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import com.xaut.service.StudentService;
import com.xaut.util.HandleJSON;
import com.xaut.util.ResponseBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class StudentServiceImplTest {
	@Autowired
	private StudentService studentService;
	
	HandleJSON handleJSON = new HandleJSON();
	
	/**
	 * test：根据学生账号获得学生姓名
	 */
	@Test
	public void findStudentNameByUsernameTest() {
		System.out.println(studentService.findStudentNameByUsername("0000123456"));
		System.out.println("查询学生姓名成功");
	}
	
	/**
	 * test：获得学生所选课程概况
	 */
	@Test
	public void getCourseSurveyTest() {
		ResponseBean bean = this.studentService.getCourseSurvey("0000123456","0");
		
		String jsonString = JSON.toJSONString(bean); //将JSON对象	转化为	JSON字符串
		System.out.println(handleJSON.print_JSON(jsonString)); //将JSON字符串格式化输出
		System.out.println("测试获得学生所选课程概况通过");
	}
}