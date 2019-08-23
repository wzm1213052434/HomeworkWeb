package com.xaut.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.xaut.util.HandleJSON;
import com.xaut.util.ResponseBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class TeacherServiceImplTest {
	@Autowired
	TeacherServiceImpl teacherServiceImpl;
	
	HandleJSON handleJSON = new HandleJSON();
	
	/**
	 * 测试：根据学号获得已选课程老师
	 */
	@Test
	public void getTeacherByUsernameTest() {
		ResponseBean result = teacherServiceImpl.getTeacherByUsername("0000123456");
		
		//格式化输出
    	HandleJSON handleJSON = new HandleJSON();
    	System.out.println(handleJSON.print_JSON(JSON.toJSONString(handleJSON.to_JSON(result))));
	}
	
	/**
	 * 测试：根据学号获得本院老师
	 */
	@Test
	public void getCollegeTeacherByUsernameTest() {
		ResponseBean result = teacherServiceImpl.getCollegeTeacherByUsername("0000123456");
		
		//格式化输出
    	HandleJSON handleJSON = new HandleJSON();
    	System.out.println(handleJSON.print_JSON(JSON.toJSONString(handleJSON.to_JSON(result))));
	}
}
