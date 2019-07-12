package com.xaut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {
	/**
	 * 管理员主页
	 */
	@RequestMapping(value = "/index")
	public String successLogin() {
		return "admin/index";
	}
}
