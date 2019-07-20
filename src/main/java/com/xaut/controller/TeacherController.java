package com.xaut.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RequestMapping(value = "/teacher")
@Controller
public class TeacherController {
	/**
	 * 教师主页
	 */
	@RequestMapping(value = "/index")
	public String successLogin() {
		return "teacher/index";
	}
	
	/**
	 * 功能：教师上传excel
	 * 参数：request域中的file
	 * 返回值：true | false
	 */
	@RequestMapping(value = "/upload")
	@ResponseBody
	public Boolean upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取文件和文件拓展名
		MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;  
        MultipartFile file = mpRequest.getFile("file");
        String originalFilename = file.getOriginalFilename();
        
        //2.保存文件
		String dirPath = "E:\\HomeWorkWeb\\teacher\\excel";//保存的路径
		File filePath = new File(dirPath);
		if(!filePath.exists()) { //不存在文件夹则创建
			filePath.mkdirs();
		}
		
		//新的文件名字
        String newFileName = new Date().getTime()+originalFilename;
        try {
        	File targetFile = new File(filePath,newFileName);//封装上传文件位置的全路径
            file.transferTo(targetFile);//把本地文件上传到封装上传文件位置的全路径
        } catch(Exception e)
        {
        	e.printStackTrace();
        	return false;
        }
        return true;
	}
}