package com.xaut.service;

import java.util.Map;
import com.xaut.entity.Work;

public interface WorkService {
	/**
	 * 教师发布作业
	 */
	public Map<String, Object> publishWork(Work work);
	
	/**
	 * 功能：根据课程号查看发布作业次数
	 * @param cno
	 * @return
	 */
	public int findWorkTimesByCno(String cno);
}