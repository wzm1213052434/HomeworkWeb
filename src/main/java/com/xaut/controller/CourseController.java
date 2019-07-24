package com.xaut.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xaut.entity.Course;
import com.xaut.service.impl.CourseServiceImpl;
import com.xaut.util.ResponseBean;

@RequestMapping(value = "/course")
@Controller
public class CourseController {

	@Autowired
	private CourseServiceImpl courseServiceImpl;
	
	/**
	 * 功能：查找教师所开的课程信息
	 * 参数：老师教工号
	 * 返回值：所有课程信息的json格式
	 */
	@RequestMapping(value = "/findCourseByTeacherTno",method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean findCourseByTeacherTno(HttpServletRequest request,HttpServletResponse response) {
		String tno = request.getParameter("teacherId").toString();

		List<Course> course = courseServiceImpl.findCourseByTeacherTno(tno);
		
		ResponseBean responseBean = new ResponseBean();
		responseBean.setData(course);
		return responseBean;
	}
}