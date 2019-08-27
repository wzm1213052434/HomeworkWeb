package com.xaut.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 单元测试
 */
public class AnnouncementMapperTest {
	//从Spring容器中获取CourseMapper
	ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	AnnouncementMapper announcementMapper = act.getBean(AnnouncementMapper.class);
	
	/**
	 * 测试：查询所有公告(先根据'是否已读'升序,再根据'发布时间'降序)
	 */
	@Test
	public void getAllAnnouncementTest() {
		List<Map<String, Object>> announcement = new ArrayList<Map<String, Object>>();
		
		try {
			announcement = announcementMapper.getAllAnnouncement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(announcement);
		System.out.println("分页查询所有公告成功");
	}
	
	/**
	 * 测试：查询所有公告总记录数
	 */
	@Test
	public void countAllAnnouncementTest() {
		System.out.println(announcementMapper.countAllAnnouncement());
		System.out.println("查询所有公告总记录数成功");
	}
	
	/**
	 * 测试：查询新公告记录数
	 */
	@Test
	public void countNewAnnouncementTest() {
		System.out.println(announcementMapper.countNewAnnouncement());
		System.out.println("查询新公告记录数成功");
	}
}