package com.xaut.service;

import java.util.Map;

import com.xaut.entity.Work;
import com.xaut.util.ResponseBean;

public interface WorkService {
	/**
	 * 教师发布作业
	 */
	Map<String, Object> publishWork(Work work);
	
	/**
	 * 功能：根据课程号查看发布作业次数
	 * @param cno
	 * @return
	 */
	int findWorkTimesByCno(String cno);
	
	/**
     * function:获得学生所选作业概况
     * @param 学生账号
     * @return 作业名	所属课程名	开课老师	起始时间	截止时间	剩余提交次数	是否批改	评分
     */
	ResponseBean getWorkSurvey(String username);
	
	/**
     * function:公布的作业概况
     * @return 作业 所属课程 开课老师 作业评分 公布人
     */
	ResponseBean getPublishWorkSurvey();
}