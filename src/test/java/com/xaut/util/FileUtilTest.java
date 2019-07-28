package com.xaut.util;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FileUtilTest {
	/**
	 * 测试：解析Excel的值
	 */
	@Test
	public void readExcelTest() {
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		
		FileUtil fileUtil = act.getBean(FileUtil.class);
		fileUtil.readExcel("(2017-2018-2)-09191430-104496-31dmc.xls");
	}
}