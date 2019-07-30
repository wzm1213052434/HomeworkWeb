package com.xaut.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.xaut.service.WorkService;

@Service("WorkService")
public class WorkServiceImpl implements WorkService{
	
	/**
	 * 功能：教师发布作业
	 */
	public Map<String, Object> publishWork() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		//1.新增作业
		//2.学生选择作业
		return map;
	}
}