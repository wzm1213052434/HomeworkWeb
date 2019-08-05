package com.xaut.mapper;

import org.springframework.stereotype.Repository;
import com.xaut.entity.Work;

@Repository
public interface WorkMapper {
	/**
	 * 功能：教师新增作业
	 * @param work
	 */
	public void addWork(Work work);
	
	/**
	 * 功能：教师删除作业
	 * @param wno
	 */
	public void deteteWork(String wno);
	
	/**
	 * 功能：根据课程号查看发布作业次数
	 * @param cno
	 * @return
	 */
	public int findWorkTimesByCno(String cno);
}