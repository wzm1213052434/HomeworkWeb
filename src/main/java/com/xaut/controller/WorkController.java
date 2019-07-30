package com.xaut.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xaut.service.WorkService;

@Controller
@RequestMapping(value = "/work")
public class WorkController {
	@Autowired
	private WorkService workService;
	
	/**
	 * 功能：教师发布作业
	 * 参数 request
	 * 返回值 true | false
	 */
	@RequestMapping(value = "/publishWork",method=RequestMethod.GET)
	public Map<String, Object> publishWork(HttpServletRequest request) {
		//获取参数
		//调用Service完成功能
		return workService.publishWork();
	}
}