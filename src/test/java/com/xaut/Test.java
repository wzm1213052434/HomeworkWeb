package com.xaut;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		timeTest();
	}
	
	/**
	 * 测试：Java时间
	 */
	public static void timeTest() {
		//1.mysql时间类型
		System.out.println(new java.sql.Date(new Date().getTime()));
		
		//2.时间字符串	转化为	时间类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			Date date = sdf.parse("2109-7-30 11:11:20");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}