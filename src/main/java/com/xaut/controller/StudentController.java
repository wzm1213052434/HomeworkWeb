package com.xaut.controller;

import java.io.File;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xaut.service.StudentService;
import com.xaut.util.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RequestMapping(value = "/student")
@Controller
public class StudentController {
	
	// 日志
	private Logger logger = LoggerFactory.getLogger(TeacherController.class);

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
	@RequestMapping(value = "/upload")
	@ResponseBody
	public Boolean upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取文件和文件拓展名
		MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;  
        MultipartFile file = mpRequest.getFile("file");
        String originalFilename = file.getOriginalFilename();
        
        //2.保存文件
        //2.1保存的路径
		String dirPath = "E:\\HomeWorkWeb\\teacher\\excel";
		File filePath = new File(dirPath);
		if(!filePath.exists()) { //不存在文件夹则创建
			filePath.mkdirs();
		}
		
		//2.2新的文件名字(重复提交以时间戳区分文件版本)
        String newFileName = new Date().getTime()+originalFilename;
        try {
        	File targetFile = new File(filePath,newFileName);//封装上传文件位置的全路径
            file.transferTo(targetFile);//把本地文件上传到封装上传文件位置的全路径
        } catch(Exception e)
        {
        	logger.error("上传文件异常: " +e);
        	e.printStackTrace();
        	return false;
        }
        return true;
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