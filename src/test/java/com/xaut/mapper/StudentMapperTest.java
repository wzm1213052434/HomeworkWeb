package com.xaut.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xaut.entity.Student;

/*
 * 单元测试
 */
public class StudentMapperTest {
	
	//从Spring容器中获取StudentMapper
	ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	StudentMapper studentMapper = act.getBean(StudentMapper.class);
	
	/**
	 * 测试：新增学生
	 */
	@Test
	public void addStudentTest() {		
		Student student = new Student();
		student.setSno("3162131013");
		student.setsName("吴小华");
		student.setDepart("计算机科学与技术");
		student.setUpdateTime(new java.sql.Date(new Date().getTime()));
		
		studentMapper.addStudent(student);
		System.out.println("新增学生成功");
	}
	
	/**
	 * 测试：删除学生
	 */
	@Test
	public void deleteStudentTest() {
		studentMapper.deleteStudent("3162131013");
		System.out.println("删除学生成功");
	}
	
	/**
	 * 测试：学生选课
	 */
	@Test
	public void studentSelectCourseTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sno","3160662001");
		map.put("cno","(2017-2018-2)-09191430-104492-4");
		map.put("state","1");
		map.put("updateTime",new java.sql.Date(new Date().getTime()));
		
		studentMapper.studentSelectCourse(map);
		System.out.println("学生选课成功");
	}
	
	/**
	 * 测试：学生退课
	 */
	@Test
	public void studentDeleteCourseTest() {
		studentMapper.studentUndoCourse("3160662001","(2017-2018-2)-09191430-104492-4");
		System.out.println("学生退课成功");
	}
	
	/**
	 * 测试：学生选作业
	 */
	@Test
	public void studentSelectWorkTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sno","3160662002");
		map.put("wno","(2017-2018-2)-09191430-104496-3-1");
		map.put("subTime","2019-05-23");
		map.put("times","1");
		map.put("correctionStatus","0");
		map.put("state",null);
		map.put("comment","再接再厉");
		map.put("evaluate","做的很差");
		map.put("score","65");
		map.put("updateTime",new java.sql.Date(new Date().getTime()));
		
		studentMapper.studentSelectWork(map);
		System.out.println("学生选作业成功");
	}
	
	/**
	 * 测试：学生根据作业号退选作业
	 */
	@Test
	public void studentUndoWorkTest() {
		studentMapper.studentUndoWork("3160662002", "(2017-2018-2)-09191430-104496-3-1");
		System.out.println("学生退选作业成功");
	}
}