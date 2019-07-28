package com.xaut;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		timeTest();
	}
	
	/**
	 * 测试：Java时间类型 和 mysql时间类型
	 */
	public static void timeTest() {
		System.out.println(new java.sql.Date(new Date().getTime()));
	}

}