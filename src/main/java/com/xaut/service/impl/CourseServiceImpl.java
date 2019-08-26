package com.xaut.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xaut.service.CourseService;
import com.xaut.util.CommonString;
import com.xaut.util.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xaut.entity.Course;
import com.xaut.mapper.CourseMapper;
import org.springframework.util.StringUtils;

@Service("CourseService")
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseMapper courseMapper;

	// 日志
	private Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	/**
	 * 查找教师所开的课程信息
	 * @param tno 教师职工号
	 * @return
	 */
	public ResponseBean findCourseByTeacherTno(String tno) {
		if (StringUtils.isEmpty(tno)) { // 参数判空
			return new ResponseBean(false, "教师职工号为空");
		}
		List<Course> list = new ArrayList<Course>();
		try {
			list = this.courseMapper.findCourseByTeacherTno(tno);
			if (list.size() == 0) {
				return new ResponseBean(true, list, "该教师未开设课程");
			}
		} catch (Exception e) {
			logger.error("查询教师所开课程信息异常: " +e);
			return new ResponseBean(false, "查询教师所开课程信息异常");
		}
		return new ResponseBean(true, list, "查询教师所开课程信息成功");
	}

	/**
	 * 根据课程名分页获取课程
	 * @param courseName
	 * @param page
	 * @param rows
	 * @return
	 */
	public ResponseBean getAllCourse(String courseName, Integer page, Integer rows) {
		if (page == 0 || rows == 0) { // page和rows为0时,为其设置默认值
			page = Integer.parseInt(CommonString.ONE);
			rows = Integer.parseInt(CommonString.TEN);
		}
		int startPage = (rows * page) - rows; // 为SQL limit参数提供参数,startPage为起始页
		List<Map<String, Object>> list = null;
		String courseTotal = null;
		try {
			if(courseName == "") {
				System.out.println("12312312312312");
				courseTotal = Integer.toString(this.courseMapper.countCourse()); // 课程总数
			}else {
				System.out.println("1231231231231ppppppppppppppppp2");
				courseTotal = Integer.toString(this.courseMapper.countVagueCourse(courseName)); // 模糊课程总数
				System.out.println(courseTotal);
			}
			list = this.courseMapper.getAllCourse(courseName, startPage, rows);
			if (list.size() == 0) {
				return new ResponseBean(true, "无课程");
			}
		} catch (Exception e) {
			logger.error("分页查询课程异常: " +e);
			return new ResponseBean(false, "分页查询课程异常");
		}
		return new ResponseBean(true, list, courseTotal);
	}
	
	/**
     * function:学生本院老师已开课程
     * @param username
     * @return 课程名 开课学期 开课学年 开课老师 老师学院
     */
    public ResponseBean getOurCollegeCourse(String username) {
    	if (StringUtils.isEmpty(username)) {
			return new ResponseBean(false, "参数为空");
		}
    	
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = this.courseMapper.getOurCollegeCourse(username);
			if (list.size() == 0) {
				return new ResponseBean(true, list, "该学生本院老师已开课程为空");
			}
		} catch (Exception e) {
			return new ResponseBean(false, "获得学生本院老师已开课程异常");
		}
		
		return new ResponseBean(true, list, "获得学生本院老师已开课程成功");
    }
    
    /**
     * function:课程的详细信息
     * @param cno
     * @return
     */
    public ResponseBean getCourseDetail(String cno) {
    	if (StringUtils.isEmpty(cno)) {
			return new ResponseBean(false, "参数为空");
		}
    	
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = this.courseMapper.getCourseDetail(cno);
			if (map == null) {
				return new ResponseBean(true, map, "没有该课程");
			}
		} catch (Exception e) {
			return new ResponseBean(false, "获得课程的详细信息异常");
		}
		
		return new ResponseBean(true, map, "获得课程的详细信息成功");
    }
}