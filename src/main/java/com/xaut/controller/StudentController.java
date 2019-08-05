package com.xaut.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xaut.service.StudentService;
import com.xaut.util.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/student")
@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	/**
	 * 学生主页
	 */
	@RequestMapping(value = "/index")
	public String successLogin() {
		return "student/index";
	}
	
	/**
	 * 功能：学生上传作业
	 */
	@RequestMapping(value = "/workUpload")
	@ResponseBody
	public void workUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
	}

	/**
	 * 根据课程号分页查询学生
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getByCno", method = {RequestMethod.GET})
	@ResponseBody
	public ResponseBean getStudentByCno(HttpServletRequest request) {
		String cno = request.getParameter("cno");
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer rows = Integer.parseInt(request.getParameter("rows"));
		Boolean isPage = Boolean.valueOf(request.getParameter("isPage")); // 控制是否分页,true为分页
		return studentService.getStudentByCourse(cno, page, rows, isPage);
	}
}