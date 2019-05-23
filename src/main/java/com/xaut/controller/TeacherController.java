package com.xaut.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/teacher")
public class TeacherController {
	/**
	 * 教师主页
	 */
	@RequestMapping(value = "/index")
	public String successLogin() {
		return "teacher/index";
	}
}
