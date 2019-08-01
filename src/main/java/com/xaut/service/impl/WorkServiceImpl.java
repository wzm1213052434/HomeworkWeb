package com.xaut.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xaut.entity.Work;
import com.xaut.mapper.StudentMapper;
import com.xaut.mapper.WorkMapper;
import com.xaut.service.WorkService;

@Service("WorkService")
public class WorkServiceImpl implements WorkService{
	@Autowired
	WorkMapper workMapper;
	
	@Autowired
	StudentMapper studentMapper;
	
	/**
	 * 功能：教师发布作业
	 * 参数：work
	 */
	public Map<String, Object> publishWork(Work work) {
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("success", true);
		json.put("message", "成功");
		
		//1.新增一个作业
		try {
			workMapper.addWork(work);
		} catch (Exception e) {
			json.put("success", false);
			json.put("message", "新增作业异常");
			e.printStackTrace();
		}
		
		//2.为每个学生主动选择这个作业
		//2.1 查询选了这门课的所有学生
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = studentMapper.getStudentByCourse(work.getCno(),0,0,false);	//false不分页查询
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//2.2 为每个学生主动选择这个作业
		for (Map<String, Object> one_map : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sno",one_map.get("sno"));	//学号
			map.put("wno",work.getWno());	//作业号
			map.put("subTime",null);	//默认提交时间null
			map.put("times","3");	//默认提交次数为3
			map.put("correctionStatus",null);	//默认批改状态为null
			map.put("state",null);	//默认申请重新提交状态为null
			map.put("comment",null);	//学生看的评语为null
			map.put("evaluate",null);	//老师看的评价为null
			map.put("score",null);	//默认成绩为null
			map.put("updateTime",new java.sql.Date(new Date().getTime()));
			
			try {
				studentMapper.studentSelectWork(map);
			} catch (Exception e) {
				json.put("success", false);
				json.put("message", "主动为学生选作业异常");
				e.printStackTrace();
			}
		}
		
		return json;
	}
	
	/**
	 * 功能：根据课程号查看发布作业次数
	 */
	public int findWorkTimesByCno(String cno) {
		return workMapper.findWorkTimesByCno(cno);
	}
}