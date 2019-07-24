package com.xaut.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * API接口测试
 */
public class TeacherControllerTest {
	@Test
	public void readExcelTest() {
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		TeacherController teacherController = act.getBean(TeacherController.class);
		teacherController.readExcel("1563628557767(2017-2018-2)-09191430-104496-31dmc.xls");
	}
}