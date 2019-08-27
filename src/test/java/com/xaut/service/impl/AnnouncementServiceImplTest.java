package com.xaut.service.impl;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import com.xaut.entity.Announcement;
import com.xaut.service.AnnouncementService;
import com.xaut.util.HandleJSON;
import com.xaut.util.ResponseBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class AnnouncementServiceImplTest {
	@Autowired
	private AnnouncementService announcementService;
	
	@Autowired
	private GetListByPage<Map<String, Object>> getListByPage;
	
	HandleJSON handleJSON = new HandleJSON();
	
	/**
	 * 测试：分页查询所有公告
	 */
	@Test
	public void findAllAnnouncementByPageTest() {
		List<Map<String, Object>> announcement = announcementService.findAllAnnouncement();
		ResponseBean result = getListByPage.getListByPage(announcement, 1, 3);
		
        String jsonString = JSON.toJSONString(handleJSON.to_JSON(result));
        System.out.println(handleJSON.print_JSON(jsonString));
	}
	
	/**
	 * 测试：分页查询课程的公告
	 */
	@Test
	public void getCourseAnnouncementTest() {
		List<Map<String, Object>> announcement = announcementService.getCourseAnnouncement("(2017-2018-2)-09191430-104496-3");
		ResponseBean result = getListByPage.getListByPage(announcement,1,2);
		
		String jsonString = JSON.toJSONString(result);
		System.out.println(handleJSON.print_JSON(jsonString));
	}
	
	/**
	 * 测试：动态sql更新公告
	 */
	@Test
	public void updateAnnouncementTest() {
		Announcement announcement = new Announcement();
		announcement.setAno("(2017-2018-2)-09191430-104492-4-1");
		
		//以下为可选
		announcement.setIsRead(false);

		announcementService.updateAnnouncement(announcement);
		System.out.println("动态sql更新公告成功");
	}
}