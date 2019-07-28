package com.xaut.util;

import java.util.ArrayList;
import java.util.List;

import com.xaut.entity.Student;

/**
 * 单元测试
 * @author 小华
 */
public class HandleJSONTest {
	
	public static void main(String[] args) {
		to_JSONTest();
		print_JSONTest();
	}
	
	/**
	 * 测试：Java数据结构	转化为	JSON数据
	 */
	public static void to_JSONTest() {
		HandleJSON handleJson = new HandleJSON();
		List<Student> aa = new ArrayList<Student>();
		Student stu = new Student();
		stu.setSno("123");
		stu.setDepart("123");
		stu.setsName("事实上");
		aa.add(stu);
		stu.setSno("123");
		stu.setDepart("123");
		stu.setsName("事实上");
		aa.add(stu);
		
		System.out.println(handleJson.to_JSON(stu));
		System.out.println(handleJson.to_JSON(aa));
	}
	
	/**
	 * 测试：对JSON字符串格式化输出
	 */
	public static void print_JSONTest() {
		HandleJSON handleJson = new HandleJSON();
		String jsonString = "{'姓名':'bbb','年龄':'30'}";
		
		System.out.println(handleJson.print_JSON(jsonString));
	}
}