package com.xaut.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.xaut.util.FileUtil;

@RequestMapping(value = "/teacher")
@Controller
public class TeacherController {
	@Autowired
	FileUtil fileUtil;
	
	/**
	 * 教师主页
	 */
	@RequestMapping(value = "/index")
	public String successLogin() {
		return "teacher/index";
	}
	
	/**
	 * function:teacher目录下万能的页面跳转
	 * @param teacher目录下的jsp/html的名称
	 */
	@RequestMapping(value="/{pageUrl}",method= RequestMethod.GET)
	public String page(@PathVariable("pageUrl") String pageUrl){
		return "teacher/" + pageUrl;
	}
	
	/**
	 * 功能：保存教师上传excel
	 * 参数：request域中的file
	 * 返回值：true | false
	 */
	@RequestMapping(value = "/to_upload")
	@ResponseBody
	public Map<String,Object> to_upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> json = new HashMap<String,Object>();
		json.put("message","成功");
		
		try {
			//1.获取文件	和	文件名
			MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;  
	        MultipartFile file = mpRequest.getFile("file");
	        String originalFilename = file.getOriginalFilename();
	        
	        //2.设置文件保存的逻辑路径	和	新文件名
	        String dirPath = "E:\\HomeWorkWeb\\teacher\\excel";
	        String newFileName = originalFilename;
	        
	        //3.文件上传
	        fileUtil.fileUpload(dirPath,newFileName,file);
	        
	        //4.调用函数处理excel的值
	        fileUtil.readExcel(newFileName);
		} catch (Exception e) {
			json.put("message","失败");
			e.printStackTrace();
		}
        
        return json;
	}
}