package com.xaut.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xaut.entity.Work;

public class WorkMapperTest {
	
	//从Spring容器中获取CourseMapper
	ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	WorkMapper workMapper = act.getBean(WorkMapper.class);
	
	/**
	 * 测试：教师新增作业
	 */
	@Test
	public void addWorkTest() {
		Work work = new Work();
		work.setWno("(2017-2018-2)-09191430-104496-3-5");
		work.setCno("(2017-2018-2)-09191430-104496-3");
		work.setwName("第一次作业");
		work.setDesc("用java输入hello world ！！");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			work.setStart_time(sdf.parse("2109-7-30 11:11:20"));
			work.setEnd_time(sdf.parse("2109-8-20 4:31:50"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		work.setUpdateTime(new java.sql.Date(new Date().getTime()));
		
		workMapper.addWork(work);
		System.out.println("教师新增作业成功");
	}
	
	/**
	 * 测试：教师删除作业
	 */
	@Test
	public void deteteWorkTest() {
		workMapper.deteteWork("(2017-2018-2)-09191430-104496-3-5");
		System.out.println("教师删除作业成功");
	}
	
	/**
	 * 测试：根据课程号查看发布作业次数
	 */
	@Test
	public void findWorkTimesByCnoTest() {
		System.out.println("发布作业次数：" + workMapper.findWorkTimesByCno("(2017-2018-2)-09191430-104496-3"));
	}
}