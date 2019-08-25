package com.xaut.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.xaut.service.StudentService;
import com.xaut.util.FileUtil;
import com.xaut.util.ResponseBean;

@RequestMapping(value = "/student")
@Controller
public class StudentController {
	@Autowired
	FileUtil fileUtil;
	
	@Autowired
	private StudentService studentService;
	
	/**
	 * 功能：学生主页
	 */
	@RequestMapping(value="/index",method= RequestMethod.GET)
	public String index(){
		return "student/index";
	}
	
	/**
	 * function:student目录下万能的页面跳转
	 * @param student目录下的jsp/html的名称
	 */
	@RequestMapping(value="/{pageUrl}",method= RequestMethod.GET)
	public String page(@PathVariable("pageUrl") String pageUrl){
		return "student/" + pageUrl;
	}
	
	/**
	 * 功能：学生上传作业
	 */
	@RequestMapping(value = "/workUpload", method = {RequestMethod.GET})
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
	
	/**
	 * function：根据学生账号获得学生姓名
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findStudentNameByUsername", method = {RequestMethod.GET})
	@ResponseBody
	public String findStudentNameByUsername(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		return studentService.findStudentNameByUsername(userName);
	}
	
	/**
     * function：获得学生所选课程概况
     * @param username
     * @param isClassEnd
     * @return
     */
	@RequestMapping(value = "/getCourseSurvey", method = {RequestMethod.GET})
	@ResponseBody
	public ResponseBean getCourseSurvey(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String isClassEnd = request.getParameter("isClassEnd");
		
		return studentService.getCourseSurvey(userName, isClassEnd);
	}
	
	/**
	 * function：学生提交作业
	 * @param request
	 * @return true | false
	 */
	@RequestMapping(value = "/studentSubmitWork", method = {RequestMethod.POST})
	@ResponseBody
	public boolean studentSubmitWork(HttpServletRequest request) throws Exception {
		try {
			//1.获取文件	和	文件名
			MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;  
	        MultipartFile file = mpRequest.getFile("file");
	        String originalFilename = file.getOriginalFilename();
	        
	        //2.设置文件保存的逻辑路径	和	新文件名
	        String dirPath = "E:\\HomeWorkWeb\\student\\work";
	        String newFileName = originalFilename;
	        
	        //3.删除上一次提交的作业文件(文件重名会自动进行覆盖)
	        String studentWorkName = request.getParameter("studentWorkName");
	        System.out.println(dirPath + "\\" + studentWorkName);
	        File preview_file = new File(dirPath + "\\" + studentWorkName);
	        if (preview_file.isFile() && preview_file.exists()) {
	        	preview_file.delete();
	        }
	        
	        //4.文件上传
	        fileUtil.fileUpload(dirPath,newFileName,file);
	        
	        //5.更新学生作业表
	        String userName = request.getParameter("userName");
			String wno = request.getParameter("wno");
			studentService.studentSubmitWorkToUpdate(userName,wno,originalFilename);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * function：学生作业文件下载
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/fileDownLoad", method = {RequestMethod.GET})
	@ResponseBody
	public ResponseEntity<byte[]> fileDownLoad(HttpServletRequest request){
		String fileName = request.getParameter("fileName");
		String dirPath = "E:\\HomeWorkWeb\\student\\work";
		
		return fileUtil.fileDownLoad(dirPath, fileName);
	}
}