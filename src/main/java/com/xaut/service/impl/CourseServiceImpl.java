package com.xaut.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.xaut.service.CourseService;
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
}