package com.xaut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xaut.entity.Announcement;

/**
 * 公告相关接口
 */
public interface AnnouncementMapper {
	/**
	 * 功能：查询所有公告(先根据'是否已读'升序,再根据'发布时间'降序)
	 * @return
	 */
	List<Announcement> getAllAnnouncement() throws Exception;
	
	/**
	 * 功能：查询所有公告总记录数
	 * @return
	 */
	int countAllAnnouncement();
	
	/**
	 * 功能：查询新公告记录数
	 * @return
	 */
	int countNewAnnouncement();
	
	/**
	 * function：动态sql更新公告
	 */
	void updateAnnouncement(Announcement announcement);
	
	/**
	 * function:查询某课程的公告
	 * @return
	 */
	List<Announcement> getCourseAnnouncement(@Param("cno") String cno);
}