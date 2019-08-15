package com.xaut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系统共有的页面跳转Controller
 */
@Controller
public class PageController {
	/**
	 * 功能：不带目录的页面跳转(访问views目录下的jsp)
	 * @param page:jsp/html名称
	 */
	@RequestMapping(value="/{page}",method= RequestMethod.GET)
    public String page(@PathVariable("page") String page){
        System.out.println("====" + page + "====");
		return page;
    }
	
	/**
	 * 功能：带有一级目录(访问admin/student/teacher目录下的jsp)
	 * @param type:一级目录(admin/student/teacher)
	 * @param page:jsp/html名称
	 */
	@RequestMapping(value="/{type}/{page}",method=RequestMethod.GET)
    public String page(@PathVariable("type") String type,@PathVariable("page") String page){
		System.out.println("====" + type + "/" + page + "====");
		return type + "/" + page;
    }
}