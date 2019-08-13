package com.xaut.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xaut.entity.Announcement;
import com.xaut.mapper.AnnouncementMapper;
import com.xaut.service.AnnouncementService;
import com.xaut.util.PageInfo;

@Service("AnnouncementService")
public class AnnouncementServiceImpl implements AnnouncementService {
	@Autowired
	AnnouncementMapper announcementMapper;
	
	/**
	 * 功能：分页查询所有公告
	 * @param 当前页
	 * @param 页大小
	 * @return 分页信息
	 */
	public PageInfo<Announcement> findAllAnnouncementByPage(List<Announcement> announcement,Integer currentPage,Integer pageSize){		
		//构造分页信息
		int pageNo = 5; //设置页码显示位数
		PageInfo<Announcement> pageInfo = new PageInfo<Announcement>(announcement.size(), currentPage, pageSize , pageNo);
        if(currentPage == pageInfo.getTotalPage()) { //如果最后一页就显示最后一页的几条
            pageInfo.setList(announcement.subList((currentPage-1)*pageSize, announcement.size()));
        }
        else { //不是最后一页就显示pageSize条
            pageInfo.setList(announcement.subList((currentPage-1)*pageSize, (currentPage-1)*pageSize+pageSize));
        }
		return pageInfo;
	}
	
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
	 * 功能：查询所有公告总记录数
	 * @return
	 */
	public int countAllAnnouncement() {
		return announcementMapper.countAllAnnouncement();
	}
}