package com.xaut.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.xaut.entity.Announcement;
import com.xaut.service.AnnouncementService;
import com.xaut.util.HandleJSON;
import com.xaut.util.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class AnnouncementServiceImplTest {
	@Autowired
	private AnnouncementService announcementService;
	
	/**
	 * 测试：分页查询所有公告
	 */
	@Test
	public void findAllAnnouncementByPageTest() {
		//预展示信息列表
		List<Announcement> announcement = new ArrayList<Announcement>();
		announcement = announcementService.findAllAnnouncement();
		int count = announcementService.countAllAnnouncement();
		int pageSize = 2;
		//计算总页数
		int totalPage;
        if (count % pageSize == 0) {
            totalPage = count / pageSize;
        }
        else {
            totalPage = (count / pageSize) + 1;
        }
		
		//调用Service
		for(int i=1; i<=totalPage; i++)
		{
			PageInfo<Announcement> pageInfo = announcementService.findAllAnnouncementByPage(announcement, i, pageSize);
			System.out.println("====第" + i + "页====");
			
			HandleJSON handleJSON = new HandleJSON();
			String jsonString = JSON.toJSONString(handleJSON.to_JSON(pageInfo));
			System.out.println(handleJSON.print_JSON(jsonString));
		}
	}
}