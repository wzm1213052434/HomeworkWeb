package com.xaut.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xaut.mapper.TeacherMapper;
import com.xaut.service.TeacherService;
import com.xaut.util.ResponseBean;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	TeacherMapper teacherMapper;
	
	
	/**
     * function:根据学号获得已选课程老师
     * @param username
     * @return 教师名 所属院系 开课数
     */
	public ResponseBean getTeacherByUsername(String username) {
		if (StringUtils.isEmpty(username)) {
			return new ResponseBean(false, "参数为空");
		}
    	
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = this.teacherMapper.getTeacherByUsername(username);
			if (list.size() == 0) {
				return new ResponseBean(true, list, "该学生未选课程");
			}
		} catch (Exception e) {
			return new ResponseBean(false, "根据学号获得已选课程老师异常");
		}
		
		return new ResponseBean(true, list, "根据学号获得已选课程老师成功");
	}
	
	/**
     * function:根据学号获得本院老师
     * @param username
     * @return 教师名 所属院系 开课数
     */
	public ResponseBean getCollegeTeacherByUsername(String username) {
		if (StringUtils.isEmpty(username)) {
			return new ResponseBean(false, "参数为空");
		}
    	
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = this.teacherMapper.getCollegeTeacherByUsername(username);
			if (list.size() == 0) {
				return new ResponseBean(true, list, "该学生无本院老师");
			}
		} catch (Exception e) {
			return new ResponseBean(false, "根据学号获得本院老师异常");
		}
		
		return new ResponseBean(true, list, "根据学号获得本院老师成功");
	}
}