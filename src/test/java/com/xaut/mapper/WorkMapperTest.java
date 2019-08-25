package com.xaut.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.xaut.entity.Work;
import com.xaut.util.HandleJSON;

public class WorkMapperTest {
	
	//从Spring容器中获取CourseMapper
	ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	WorkMapper workMapper = act.getBean(WorkMapper.class);
	
	/**
	 * 测试：教师新增作业
	 */
	@Test
	public void addWorkTest() {
		Work work = new Work();
		work.setWno("(2017-2018-2)-09191430-104496-3-5");
		work.setCno("(2017-2018-2)-09191430-104496-3");
		work.setwName("第一次作业");
		work.setDesc("用java输入hello world ！！");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			work.setStart_time(sdf.parse("2109-7-30 11:11:20"));
			work.setEnd_time(sdf.parse("2109-8-20 4:31:50"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		work.setUpdateTime(new java.sql.Date(new Date().getTime()));
		
		workMapper.addWork(work);
		System.out.println("教师新增作业成功");
	}
	
	/**
	 * 测试：教师删除作业
	 */
	@Test
	public void deteteWorkTest() {
		workMapper.deteteWork("(2017-2018-2)-09191430-104496-3-5");
		System.out.println("教师删除作业成功");
	}
	
	/**
	 * 测试：根据课程号查看发布作业次数
	 */
	@Test
	public void findWorkTimesByCnoTest() {
		System.out.println("发布作业次数：" + workMapper.findWorkTimesByCno("(2017-2018-2)-09191430-104496-3"));
	}
	
	/**
	 * 测试：获得学生所选作业概况
	 */
	@Test
	public void getWorkSurveyTest() {
		List<Map<String, Object>> result = workMapper.getWorkSurvey("0000123456");
		
		//格式化输出
    	HandleJSON handleJSON = new HandleJSON();
    	System.out.println(handleJSON.print_JSON(JSON.toJSONString(handleJSON.to_JSON(result))));
	}
	
	/**
	 * 测试：学生某个作业的详细信息
	 */
	@Test
	public void getWorkDetailTest() {
		Map<String, Object> map = workMapper.getWorkDetail("0000123456", "(2017-2018-2)-09191430-104492-4-1");
		System.out.println(map);
	}
	
	/**
	 * 测试：动态sql更新学生作业表
	 */
	@Test
	public void updateStudentWorkTest() {
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("username","0000123456");
    	map.put("wno","(2017-2018-1)-09191430-104496-3-1");
    	map.put("studentWorkName","本次作业呀"); //提交作业文件名-更新
    	map.put("subTime",new java.sql.Date(new Date().getTime())); //提交时间-更新
    	map.put("times",1); //剩余提交次数-减1
    	map.put("isCorrect","0"); //是否批改-为否
    	map.put("comment","无"); //评论-清空
    	map.put("score","无"); //成绩-清空
		map.put("updateTime",new java.sql.Date(new Date().getTime())); //更新时间-更新
		map.put("isPublish","0"); //是否发布-为否
		workMapper.updateStudentWork(map);
		System.out.println("动态sql更新学生作业表成功");
	}
}