package com.xaut.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xaut.entity.Announcement;
import com.xaut.mapper.AnnouncementMapper;
import com.xaut.service.AnnouncementService;
import com.xaut.util.ResponseBean;

@Service("AnnouncementService")
public class AnnouncementServiceImpl implements AnnouncementService {
	@Autowired
	AnnouncementMapper announcementMapper;
	
	/**
	 * 功能：查询所有公告(先根据'是否已读'升序,再根据'发布时间'降序)
	 * @return
	 */
	public List<Map<String, Object>> findAllAnnouncement() {
		List<Map<String, Object>> announcement = new ArrayList<Map<String, Object>>();
		try {
			announcement = announcementMapper.getAllAnnouncement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return announcement;
	}
	
	/**
	 * function:查询某课程的所有公告详情
	 * @return
	 */
	public List<Map<String, Object>> getCourseAnnouncement(String cno){
		List<Map<String, Object>> announcement = announcementMapper.getCourseAnnouncement(cno);
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
	
	/**
	 * function:查询某个公告详细信息
	 * @param ano
	 * @return
	 */
	public ResponseBean getAnnouncementDetail(String ano) {
		if (StringUtils.isEmpty(ano)) {
			return new ResponseBean(false, "参数为空");
		}
    	
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = this.announcementMapper.getAnnouncementDetail(ano);
			if (list.size() == 0) {
				return new ResponseBean(true, list, "无此公告");
			}
		} catch (Exception e) {
			return new ResponseBean(false, "查询某个公告详细信息异常");
		}
		
		return new ResponseBean(true, list, "查询某个公告详细信息成功");
	}
}