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
     * @return 作业号 作业名 所属课程号 所属课程名 开课老师号 开课老师 起始时间 截止时间 剩余提交次数 是否批改 评分 是否公布 提交作业文件名
     */
	ResponseBean getWorkSurvey(String username);
	
	/**
     * function:公布的作业概况
     * @return 作业号 作业名  所属课程号 所属课程 开课老师号 开课老师 作业评分 公布人学号 公布人 提交作业文件名
     */
	ResponseBean getPublishWorkSurvey();
	
	/**
     * function:学生某个作业的详细信息
     * @param username
     * @param wno
     * @return
     */
	ResponseBean getWorkDetail(String username,String wno);
	
	/**
     * function:课程所布置作业列表的详细信息
     * @param cno
     * @return
     */
	ResponseBean getWorkListDetail(String cno);
}