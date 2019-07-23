package com.xaut;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		timeTest();
	}
	
	//测试获取时间戳
	public static void timeTest() {
		System.out.println(new Date().getTime());
	}
}