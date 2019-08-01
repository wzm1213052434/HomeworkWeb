package com.xaut.service;

import java.util.Map;
import com.xaut.entity.Work;

public interface WorkService {
	/**
	 * 教师发布作业
	 */
	public Map<String, Object> publishWork(Work work);
}