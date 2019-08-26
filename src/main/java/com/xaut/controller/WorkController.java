package com.xaut.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xaut.entity.Work;
import com.xaut.service.WorkService;
import com.xaut.util.ResponseBean;

@Controller
@RequestMapping(value = "/work")
public class WorkController {
	@Autowired
	private WorkService workService;
	
	/**
	 * 功能：教师发布作业
	 * 参数 request
	 * 返回值 map
	 */
	@RequestMapping(value = "/publishWork", method = RequestMethod.POST)
	public Map<String, Object> publishWork(HttpServletRequest request) {
		//1.前端获取参数
		String start_time = request.getParameter("beginDate").toString();
		String end_time = request.getParameter("deadLine").toString();
		String wName = request.getParameter("workName").toString();
		String description = request.getParameter("content").toString();
		String courseName_courseCno = request.getParameter("itemText").toString();
		String courseCno = courseName_courseCno.split(",")[1];
		
		//2.得到work对象
		Work work = new Work();
		//作业号 = "课程号-序号"(序号:本课程发布作业的次数+1,查作业表得来)
		work.setWno(courseCno + "-" + (workService.findWorkTimesByCno(courseCno)+1));
		work.setCno(courseCno);	//课程号
		work.setwName(wName);	//作业名
		work.setDesc(description);	//作业描述
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			work.setStart_time(sdf.parse(start_time));	//开始时间
			work.setEnd_time(sdf.parse(end_time));	//结束时间
		} catch (ParseException e) {
			e.printStackTrace();
		}
		work.setUpdateTime(new java.sql.Date(new Date().getTime()));	//更新时间
		
		//3.调用Service完成功能
		return workService.publishWork(work);
	}
	
	/**
     * function:获得学生所选作业概况
     * @param 学生账号
     * @return 作业号 作业名 所属课程名 开课老师 起始时间 截止时间 剩余提交次数 是否批改 评分 是否公布 提交作业文件名
     */
	@RequestMapping(value = "/getWorkSurvey", method = {RequestMethod.GET})
	@ResponseBody
	public ResponseBean getWorkSurvey(HttpServletRequest request) {
		String username = request.getParameter("UserName");
		return workService.getWorkSurvey(username);
	}
	
	/**
     * function:公布的作业概况
     * @return 作业 所属课程 开课老师 作业评分 公布人
     */
	@RequestMapping(value = "/getPublishWorkSurvey", method = {RequestMethod.GET})
	@ResponseBody
	public ResponseBean getPublishWorkSurvey(HttpServletRequest request) {
		return workService.getPublishWorkSurvey();
	}
	
	/**
     * function:学生某个作业的详细信息
     * @param username
     * @param wno
     * @return
     */
	@RequestMapping(value = "/getWorkDetail", method = {RequestMethod.GET})
	@ResponseBody
	public ResponseBean getWorkDetail(HttpServletRequest request) {
		String username = request.getParameter("userName");
		String wno = request.getParameter("wno");
		return workService.getWorkDetail(username, wno);
	}
}