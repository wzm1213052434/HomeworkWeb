package com.xaut.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.xaut.entity.Student;
import com.xaut.util.HandleJSON;

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
		map.put("sno","3160662002");
		map.put("cno","(2017-2018-2)-09191430-104492-4");
		map.put("isCanSubmit","1");
		map.put("updateTime",new java.sql.Date(new Date().getTime()));
		
		studentMapper.studentSelectCourse(map);
		System.out.println("学生选课成功");
	}
	
	/**
	 * 测试：学生退课
	 */
	@Test
	public void studentDeleteCourseTest() {
		studentMapper.studentUndoCourse("3160662002","(2017-2018-2)-09191430-104492-4");
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
		map.put("studentWorkName",null);
		map.put("subTime",null);
		map.put("times","3");
		map.put("isCorrect",null);
		map.put("comment",null);
		map.put("score",null);
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

	/**
	 * 根据课程号查询学生
	 */
    @Test
    public void getStudentByCourse() {
    	try {
			List<Map<String, Object>> result = this.studentMapper.getStudentByCourse("(2017-2018-2)-09191430-104492-4", 1,1, false);
			Assert.assertNotNull(result);
			System.out.println("测试根据课程号查询学生通过");
		} catch (Exception e) {
			System.out.println("测试根据课程号查询学生异常");
		}
    }
    
    /**
     * 测试：获得学生所选课程概况
     */
    @Test
    public void getCourseSurveyTest() {
    	List<Map<String, Object>> result = this.studentMapper.getCourseSurvey("0000123456", "0");
    	
    	//格式化输出
    	HandleJSON handleJSON = new HandleJSON();
    	System.out.println(handleJSON.print_JSON(JSON.toJSONString(handleJSON.to_JSON(result))));
    }
    
    /**
     * test:动态sql更新学生表
     */
    @Test
    public void updateStudentTest() {
    	Student student = new Student();
		student.setSno("0000123456");
		student.setMailbox("1612571478@qq.com");
		
		studentMapper.updateStudent(student);
		System.out.println("动态sql更新学生表成功");
    }
    
    /**
     * test:学生详细信息
     */
    @Test
    public void getStudentDetailTest() {
    	Map<String, Object> result = this.studentMapper.getStudentDetail("0000123456");
    	HandleJSON handleJSON = new HandleJSON();
    	System.out.println(handleJSON.print_JSON(JSON.toJSONString(handleJSON.to_JSON(result))));
    }
}