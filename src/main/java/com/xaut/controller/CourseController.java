package com.xaut.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xaut.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xaut.util.ResponseBean;

@RequestMapping(value = "/course")
@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	/**
	 * 功能：查找教师所开的课程信息
	 * 参数：老师教工号
	 * 返回值：所有课程信息的json格式
	 */
	@RequestMapping(value = "/findCourseByTeacherTno",method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean findCourseByTeacherTno(HttpServletRequest request,HttpServletResponse response) {
		String tno = request.getParameter("teacherId").toString();
		return courseService.findCourseByTeacherTno(tno); // 调用Service完成功能
	}
	
	/**
     * function:学生本院老师已开课程
     * @param username
     * @return 课程名 开课学期 开课学年 开课老师 老师学院
     */
	@RequestMapping(value = "/getOurCollegeCourse", method = {RequestMethod.GET})
	@ResponseBody
	public ResponseBean getOurCollegeCourse(HttpServletRequest request) {
		String userName = request.getParameter("userName").toString();
		return courseService.getOurCollegeCourse(userName);
	}
}