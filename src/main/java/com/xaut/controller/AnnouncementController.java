package com.xaut.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xaut.entity.Announcement;
import com.xaut.service.AnnouncementService;
import com.xaut.util.HandleJSON;
import com.xaut.util.PageInfo;
import net.sf.json.JSONObject;

@RequestMapping(value = "/announcement")
@Controller
public class AnnouncementController {
	@Autowired
	private AnnouncementService announcementService;
	
	/**
	 * function：重定向到学生主页(公告管理)
	 */
	@RequestMapping(value = "/index",method = {RequestMethod.GET})
	public String gotoStudentIndex() {
		return "forward:/WEB-INF/views/student/index.html";
	}
	
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
	 * 分页显示公告信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findAllAnnouncementByPage", method = {RequestMethod.GET})
    @ResponseBody
	public JSONObject findAllAnnouncementByPage(HttpServletRequest request) {
		//1.获得前端参数
		Integer currentPage = Integer.parseInt(request.getParameter("currentPage")); //当前页码
		Integer pageSize = Integer.parseInt(request.getParameter("pageSize")); //每页记录数
		
		//2.分页辅助参数
		List<Announcement> announcement = new ArrayList<Announcement>();
		announcement = announcementService.findAllAnnouncement();
        
        //3.返回结果
        PageInfo<Announcement> pageInfo = announcementService.findAllAnnouncementByPage(announcement, currentPage, pageSize);
		return new HandleJSON().to_JSON(pageInfo);
	}
	
	/**
	 * 功能：设置公告为已读
	 * @return
	 */
	@RequestMapping(value = "/announcementIsRead",method = {RequestMethod.GET})
	@ResponseBody
	public boolean announcementIsRead(HttpServletRequest request) {
		System.out.println("======================");
		
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
}