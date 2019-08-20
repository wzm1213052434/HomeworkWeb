package com.xaut.controller;

import com.xaut.service.AdminService;
import com.xaut.service.CourseService;
import com.xaut.util.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private AdminService adminService;

	/**
	 * 管理员主页
	 */
	@RequestMapping(value = "/index")
	public String successLogin() {
		return "admin/index";
	}
	
	/**
	 * function:admin目录下万能的页面跳转
	 * @param admin目录下的jsp/html的名称
	 */
	@RequestMapping(value="/{pageUrl}",method= RequestMethod.GET)
	public String page(@PathVariable("pageUrl") String pageUrl){
		return "admin/" + pageUrl;
	}

	/**
	 * 根据课程名分页获取课程
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/lookCourse", method = {RequestMethod.GET})
    @ResponseBody
	public ResponseBean lookCourse(HttpServletRequest request) {
		String courseName = request.getParameter("cname"); // 课程名
		Integer page = Integer.parseInt(request.getParameter("page")); // 页码
		Integer rows = Integer.parseInt(request.getParameter("rows")); // 每页记录数
		return courseService.getAllCourse(courseName, page, rows);
	}

	/**
	 * 获取用户群体的统计信息
	 * @return
	 */
	@RequestMapping(value = "/lookIndexMsg", method = {RequestMethod.GET})
	@ResponseBody
	public ResponseBean lookIndex() {
		return adminService.getUserGroupInfo();
	}
}