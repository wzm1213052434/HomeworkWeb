package com.xaut.service;

import java.util.List;
import com.xaut.entity.Announcement;
import com.xaut.util.PageInfo;

public interface AnnouncementService {
	/**
	 * 功能：分页查询所有公告
	 * @param 当前页
	 * @param 页大小
	 * @return 分页信息
	 */
	PageInfo<Announcement> findAllAnnouncementByPage(List<Announcement> announcement,Integer currentPage,Integer pageSize);
	
	/**
	 * 功能：查询所有公告(先根据'是否已读'升序,再根据'发布时间'降序)
	 * @return
	 */
	List<Announcement> findAllAnnouncement();
	
	/**
	 * 功能：查询所有公告总记录数
	 * @return
	 */
	int countAllAnnouncement();
}