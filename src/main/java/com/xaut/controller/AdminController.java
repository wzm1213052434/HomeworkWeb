package com.xaut.controller;

import com.xaut.service.CourseService;
import com.xaut.util.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {

	@Autowired
	private CourseService courseService;

	/**
	 * 管理员主页
	 */
	@RequestMapping(value = "/index")
	public String successLogin() {
		return "admin/index";
	}

	/**
	 * 查询所有课程
	 * @return
	 */
	@RequestMapping(value = "/lookCourse", method = {RequestMethod.GET})
    @ResponseBody
	public ResponseBean lookCourse() {
		return courseService.getAllCourse();
	}
}