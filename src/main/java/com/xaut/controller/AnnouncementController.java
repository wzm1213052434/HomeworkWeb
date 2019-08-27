package com.xaut.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xaut.entity.Announcement;
import com.xaut.service.AnnouncementService;
import com.xaut.service.impl.GetListByPage;
import com.xaut.util.ResponseBean;

@RequestMapping(value = "/announcement")
@Controller
public class AnnouncementController {
	@Autowired
	private AnnouncementService announcementService;
	
	@Autowired
	private GetListByPage<Map<String, Object>> getListByPage;
	
	/**
	 * 功能：查询新公告记录数
	 * @return
	 */
	@RequestMapping(value = "/countNewAnnouncement",method = {RequestMethod.GET})
	@ResponseBody
	public int countNewAnnouncement() {
		return announcementService.countNewAnnouncement();
	}
	
	/**
	 * function：分页显示所有公告信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findAllAnnouncementByPage", method = {RequestMethod.GET})
    @ResponseBody
	public ResponseBean findAllAnnouncementByPage(HttpServletRequest request) {
		//1..获得前端参数
		Integer currentPage = Integer.parseInt(request.getParameter("currentPage")); //当前页码
		Integer pageSize = Integer.parseInt(request.getParameter("pageSize")); //每页记录数
        
        //2..返回结果
		List<Map<String, Object>> announcement = announcementService.findAllAnnouncement();
		return getListByPage.getListByPage(announcement, currentPage, pageSize);
	}
	
	/**
	 * function：课程发布公告列表详细信息(1不分页)
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getAnnouncementListDetail", method = {RequestMethod.GET})
    @ResponseBody
	public ResponseBean getAnnouncementListDetail(HttpServletRequest request) {
		String cno = request.getParameter("cno");
		
		List<Map<String, Object>> list = announcementService.getCourseAnnouncement(cno);
		if (list.size() == 0) {
			return new ResponseBean(true, list, "此课程无公告");
		}
		
		return new ResponseBean(true, list, "查询课程发布公告列表详细信息成功");
	}
	
	/**
	 * function：某课程的所有公告详情(2分页)
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findCourseAnnouncementByPage", method = {RequestMethod.GET})
    @ResponseBody
	public ResponseBean findCourseAnnouncementByPage(HttpServletRequest request) {
		//1..获得前端参数
		String cno = request.getParameter("cno");
		Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));
		Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		//2..返回结果
		List<Map<String, Object>> announcement = new ArrayList<Map<String, Object>>();
		//2.1 cno为空时：分页显示所有公告信息
		if("".equals(cno)) {
			announcement = announcementService.findAllAnnouncement();
			return getListByPage.getListByPage(announcement, currentPage, pageSize);
		}
		
		//2.2 cno不为空时：分页显示该课程公告信息
		announcement = announcementService.getCourseAnnouncement(cno);
		return getListByPage.getListByPage(announcement, currentPage, pageSize);
	}
	
	/**
	 * 功能：设置公告为已读
	 * @return
	 */
	@RequestMapping(value = "/announcementIsRead",method = {RequestMethod.GET})
	@ResponseBody
	public boolean announcementIsRead(HttpServletRequest request) {
		String ano = request.getParameter("ano");
		Announcement announcement = new Announcement();
		announcement.setAno(ano);
		announcement.setIsRead(true); //设置为已读
		
		try {
			announcementService.updateAnnouncement(announcement);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * function:查询某个公告详细信息
	 * @param ano
	 * @return
	 */
	@RequestMapping(value = "/getAnnouncementDetail",method = {RequestMethod.GET})
	@ResponseBody
	public ResponseBean getAnnouncementDetail(HttpServletRequest request) {
		String ano = request.getParameter("ano");
		return announcementService.getAnnouncementDetail(ano);
	}
}