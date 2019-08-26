package com.xaut.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xaut.entity.Work;
import com.xaut.mapper.StudentMapper;
import com.xaut.mapper.WorkMapper;
import com.xaut.service.WorkService;
import com.xaut.util.ResponseBean;

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
			map.put("studentWorkName",null);	//默认学生提交作业名null
			map.put("subTime",null);	//默认提交时间null
			map.put("times","3");	//默认提交次数为3
			map.put("isCorrect",null);	//默认批改状态为null
			map.put("comment",null);	//学生看的评语为null
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
	
	/**
     * function:获得学生所选作业概况
     * @param 学生账号
     * @return 作业号 作业名 所属课程号 所属课程名 开课老师号 开课老师 起始时间 截止时间 剩余提交次数 是否批改 评分 是否公布 提交作业文件名
     */
	public ResponseBean getWorkSurvey(String username) {
		if (StringUtils.isEmpty(username)) {
			return new ResponseBean(false, "参数为空");
		}
    	
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = this.workMapper.getWorkSurvey(username);
			if (list.size() == 0) {
				return new ResponseBean(true, list, "该学生未选作业");
			}
		} catch (Exception e) {
			return new ResponseBean(false, "获得学生所选作业概况异常");
		}
		
		return new ResponseBean(true, list, "获得学生所选作业概况成功");
	}
	
	/**
     * function:公布的作业概况
     * @return 作业 所属课程 开课老师 作业评分 公布人 提交作业文件名
     */
	public ResponseBean getPublishWorkSurvey() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = this.workMapper.getPublishWorkSurvey();
			if (list.size() == 0) {
				return new ResponseBean(true, list, "没有人公布作业");
			}
		} catch (Exception e) {
			return new ResponseBean(false, "获得公布的作业概况异常");
		}
		
		return new ResponseBean(true, list, "获得公布的作业概况成功");
	}
	
	/**
     * function:学生某个作业的详细信息
     * @param username
     * @param wno
     * @return
     */
	public ResponseBean getWorkDetail(String username,String wno) {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(wno)) {
			return new ResponseBean(false, "参数为空");
		}
    	
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = this.workMapper.getWorkDetail(username, wno);
			if (map == null) {
				return new ResponseBean(true, map, "该学生没有该作业");
			}
		} catch (Exception e) {
			return new ResponseBean(false, "获得学生某个作业的详细信息异常");
		}
		
		return new ResponseBean(true, map, "获得学生某个作业的详细信息成功");
	}
}