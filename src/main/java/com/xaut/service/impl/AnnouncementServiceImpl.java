package com.xaut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xaut.entity.Announcement;
import com.xaut.mapper.AnnouncementMapper;
import com.xaut.service.AnnouncementService;

@Service("AnnouncementService")
public class AnnouncementServiceImpl implements AnnouncementService {
	@Autowired
	AnnouncementMapper announcementMapper;
	
	/**
	 * 功能：查询所有公告(先根据'是否已读'升序,再根据'发布时间'降序)
	 * @return
	 */
	public List<Announcement> findAllAnnouncement() {
		List<Announcement> announcement = new ArrayList<Announcement>();
		try {
			announcement = announcementMapper.getAllAnnouncement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return announcement;
	}
	
	/**
	 * function:查询某课程的公告
	 * @return
	 */
	public List<Announcement> getCourseAnnouncement(String cno){
		List<Announcement> announcement = announcementMapper.getCourseAnnouncement(cno);
		return announcement;
	}
	
	/**
	 * 功能：查询所有公告总记录数
	 * @return
	 */
	public int countAllAnnouncement() {
		return announcementMapper.countAllAnnouncement();
	}
	
	/**
	 * 功能：查询新公告记录数
	 * @return
	 */
	public int countNewAnnouncement() {
		return announcementMapper.countNewAnnouncement();
	}
	
	/**
	 * function：动态sql更新公告
	 */
	public void updateAnnouncement(@Param("announcement") Announcement announcement) {
		announcementMapper.updateAnnouncement(announcement);
	}
}