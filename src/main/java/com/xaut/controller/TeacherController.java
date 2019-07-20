package com.xaut.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RequestMapping(value = "/teacher")
@Controller
public class TeacherController {

	// 日志
	private Logger logger = LoggerFactory.getLogger(TeacherController.class);

	/**
	 * 教师主页
	 */
	@RequestMapping(value = "/index")
	public String successLogin() {
		return "teacher/index";
	}
	
	/**
	 * 功能：保存教师上传excel
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
        
        //3.调用函数处理excel的值
        if(!readExcel(newFileName))
        {
        	return false;
        }
        
        return true;
	}
	
	/**
	 * 功能：解析Excel的值
	 * 参数：Excel名称
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/readExcel")
	@ResponseBody
	public Boolean readExcel(String filename) {
		//1.读取excel表信息，封装为bean
		HSSFWorkbook swb = null;
		try {
			swb = new HSSFWorkbook(new FileInputStream("E:\\HomeWorkWeb\\teacher\\excel\\"+filename));
			HSSFSheet sheet = swb.getSheetAt(0);
			// 获取sheet中的最后一行（最大行）
			int lastRowNum = sheet.getLastRowNum();
			for (int i = 0; i <= lastRowNum; i++) {
				// 获取当前行
				HSSFRow row = sheet.getRow(i);
				// 获取当前行最后单元格列号（最大列）
				int LastCellNum = row.getLastCellNum();
				for (int j = 0; j < LastCellNum; j++) {
					//首先强制设置成string类型，避免其他类型出错
					HSSFCell cell = row.getCell(j);
					switch(cell.getCellType())
					{
					case HSSFCell.CELL_TYPE_NUMERIC://数字 
						System.out.print(cell.getNumericCellValue()+" ");
						break;
					case HSSFCell.CELL_TYPE_STRING://字符串
						System.out.print(cell.getStringCellValue()+" ");
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN://Boolean
						System.out.print(cell.getBooleanCellValue()+" ");   
                        break;
					case HSSFCell.CELL_TYPE_FORMULA://公式   
                        System.out.print(cell.getCellFormula()+" ");
                        break;
                    case HSSFCell.CELL_TYPE_BLANK://空值   
                        System.out.print(" ");
                        break;
                    case HSSFCell.CELL_TYPE_ERROR://故障   
                        System.out.print(" ");
                        break;
                    default:
                        System.out.print("未知类型   ");
                        break;
					}
				}
				System.out.println();
			}

			swb.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//2.课程表
		//3.教师表+用户表+用户角色表
		//4.学生表+用户表+用户角色表
		//5.学生课程表
		return true;
	}
}