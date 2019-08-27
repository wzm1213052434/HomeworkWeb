package com.xaut.mapper;

import java.util.List;
import java.util.Map;

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
	List<Map<String, Object>> getAllAnnouncement() throws Exception;
	
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
	 * function:查询某课程的所有公告详情
	 * @return
	 */
	List<Map<String, Object>> getCourseAnnouncement(@Param("cno") String cno);
	
	/**
	 * function:查询某个公告详细信息
	 * @param ano
	 * @return
	 */
	List<Map<String, Object>> getAnnouncementDetail(@Param("ano") String ano);
}