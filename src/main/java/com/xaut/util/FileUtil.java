package com.xaut.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.xaut.controller.TeacherController;
import com.xaut.entity.Course;
import com.xaut.entity.Student;
import com.xaut.entity.Teacher;
import com.xaut.entity.User;
import com.xaut.mapper.CourseMapper;
import com.xaut.mapper.StudentMapper;
import com.xaut.mapper.UserMapper;

@Service("FileUtil")
public class FileUtil {
	
	//此处调用Mapper中简单的增删改查，这些简单Service中不用写
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private StudentMapper studentMapper;
		
	// 日志
	private Logger logger = LoggerFactory.getLogger(TeacherController.class);
	
	/**
	 * 文件上传
	 * @param dirPath 保存路径
	 * @param fileName 文件名
	 * @param file 文件
	 * @return 成功 | 失败
	 */
	public void fileUpload(String dirPath,String fileName,MultipartFile file) {
        //1.得到保存的路径的物理地址
		File filePath = new File(dirPath);
		if(!filePath.exists()) { //不存在文件夹则创建
			filePath.mkdirs();
		}
		
		//2.保存文件
        try {
        	File targetFile = new File(filePath,fileName);//封装上传文件位置的全路径
            file.transferTo(targetFile);//把本地文件上传到封装上传文件位置的全路径
        } catch(Exception e)
        {
        	logger.error("上传文件异常: " +e);
        	e.printStackTrace();
        }
	}
	
	/**
	 * 功能：解析Excel的值
	 * 参数：Excel名称
	 */
	@SuppressWarnings("deprecation")
	public void readExcel(String filename) {
		List<Student> student_list = new ArrayList<Student>();
		Course course = new Course();
		Teacher teacher = new Teacher();
		
		//解析Excel,并保存数据
		HSSFWorkbook swb = null;
		try {
			swb = new HSSFWorkbook(new FileInputStream("E:\\HomeWorkWeb\\teacher\\excel\\"+filename));
			HSSFSheet sheet = swb.getSheetAt(0);
			
			//1.读第2行到字符串数组中
			String[] line1 =  new String[15];
			int num = 0;
			for (int j = 0; j < sheet.getRow(1).getLastCellNum(); j++) {
				HSSFCell cell = sheet.getRow(1).getCell(j);
				if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) { //空值
					continue;
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) { //数字
					line1[num] = String.valueOf(cell.getNumericCellValue());
					num++;
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING){ //字符转
					line1[num] = cell.getStringCellValue();
					num++;
				}
			}
			
			//2.读第3行到字符串数组中
			String[] line2 =  new String[15];
			num = 0;
			for (int j = 0; j < sheet.getRow(2).getLastCellNum(); j++) {
				HSSFCell cell = sheet.getRow(2).getCell(j);
				if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) { //空值
					continue;
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) { //数字
					line2[num] = String.valueOf(cell.getNumericCellValue());
					num++;
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING){ //字符转
					line2[num] = cell.getStringCellValue();
					num++;
				}
			}
			
			//3.封装数据到Course,Teacher中
			teacher.settName(line2[1]); //教师名称
			teacher.setCompany(line2[3]); //教师单位
			String course_cno = line1[5]; //选课课号
			String cno_tno[] = course_cno.split("-"); //将选课课号进行分割
			teacher.setTno(cno_tno[4]); //老师教工号
			teacher.setUpdateTime(new java.sql.Date(new Date().getTime())); //最后更新时间
			
			course.setCno(course_cno); //课程号
			course.setTno(cno_tno[4]); //课程教职工号 
			course.setcName(line1[7]); //课程名称
			course.setYear(line1[1]); //学年
			course.setTerm(line1[3]); //学期
			course.setTime(line2[5].replace(';', '；')); //上课时间
			course.setPlace(line2[7].replace(';', '；')); //上课地点
			course.setTableName(filename); //选课表名
			course.setIsClassEnd("0"); //0为结课
			course.setUpdateTime(new java.sql.Date(new Date().getTime())); //最后更新时间
			
			//4.读取>=第5行到Student中
			int lastRowNum = sheet.getLastRowNum(); //获取sheet中的最后一行（最大行）
			for (int i = 4; i <= lastRowNum; i++) {
				//4.1 读取一行数据到字符数组中
				Student student = new Student();
				String[] line3 = new String[15];
				num = 0;
				HSSFRow row = sheet.getRow(i); // 获取当前行
				for (int j = 0; j < row.getLastCellNum(); j++) {
					HSSFCell cell = row.getCell(j);
					if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) { //空值
						continue;
					}
					else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) { //数字
						line3[num] = String.valueOf(cell.getNumericCellValue());
						num++;
					}
					else if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING){ //字符转
						line3[num] = cell.getStringCellValue();
						num++;
					}
				}
				
				//5.封装到Student，并添加到学生列表
				student.setSno(line3[0]);
				student.setsName(line3[1]);
				student.setDepart(line3[2]);
				student.setUpdateTime(new java.sql.Date(new Date().getTime())); //最后更新时间
				student_list.add(student);
			}
			
			swb.close();
		} catch(IOException e) {
			logger.error("解析Excel异常: " +e);
			e.printStackTrace();
		}
		
		//6.导入数据库
		to_Database(student_list,course,teacher);
	}
	
	/**
	 * 将存储的Excel数据	导入到	数据库
	 */
	public void to_Database(List<Student> student_list,Course course,Teacher teacher) {
		//1.新增课程
		courseMapper.addCourse(course);
		
		//2.新增学生，用户，用户角色对应关系
		for(Student stu : student_list) {
			//1.1新增学生
			studentMapper.addStudent(stu);
			
			//1.2新增用户
			User user = new User();
			user.setUserName(stu.getSno()); //用户账号
			user.setPassWord(new Md5Hash(stu.getSno(),stu.getSno()).toString()); //密码
			user.setFlag("3"); //账号类型(3为学生)
			user.setSalt(stu.getSno()); //加盐(就是账号)
			user.setLocked("0"); //是否锁定(0为未锁定)
			user.setUpdateTime(new java.sql.Date(new Date().getTime())); //最后更新时间
			System.out.println(user);
			userMapper.addUser(user);
			
			//1.3为用户增加角色
			String uid = userMapper.findUserIDByUsername(user.getUserName());
			userMapper.addRoleForUser(uid,user.getFlag(),new java.sql.Date(new Date().getTime()).toString());
			//最后更新时间
			
			//3.增加学生选课记录
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("sno",stu.getSno());
			map.put("cno",course.getCno());
			map.put("isCanSubmit","1");
			map.put("updateTime",new java.sql.Date(new Date().getTime()));
			studentMapper.studentSelectCourse(map);
		}
	}
}