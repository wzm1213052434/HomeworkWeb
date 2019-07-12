package com.xaut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/student")
@Controller
public class StudentController {
	
	/**
	 * 学生主页
	 */
	@RequestMapping(value = "/index")
	public String successLogin() {
		return "student/index";
	}
}
