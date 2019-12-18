package com.xaut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/error")
@Controller
public class ErrorPageController {
	/**
	 * function:404异常
	 */
	@RequestMapping(value = "/404",method = {RequestMethod.GET})
    public String page404() {
        return "forward:/WEB-INF/404.html";
    }
	
	/**
	 * function:500异常
	 */
	@RequestMapping(value = "/500",method = {RequestMethod.GET})
    public String page500() {
        return "forward:/WEB-INF/500.html";
    }
}