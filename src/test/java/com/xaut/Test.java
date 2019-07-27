package com.xaut;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.xaut.entity.Student;
import net.sf.json.JSONArray;

public class Test {
	public static void main(String[] args) {
		timeTest();
		//JSONTest();
	}
	
	//测试时间
	public static void timeTest() {
		System.out.println(new Date().getTime());
		System.out.println(new java.sql.Date(new Date().getTime()));
	}
	
	//测试JSON的转化
	public static void JSONTest() {
		Student stu = new Student();
		stu.setSno("123");
		stu.setDepart("123");
		stu.setsName("事实上");
		
		Student stu1 = new Student();
		stu1.setSno("123");
		stu1.setDepart("123");
		stu1.setsName("事实上");
		
		List<Student> aa = new ArrayList<Student>();
		aa.add(stu);
		aa.add(stu1);
		System.out.println(aa);
		
		JSONArray json = JSONArray.fromObject(aa);
		System.out.println(json);
	}
}