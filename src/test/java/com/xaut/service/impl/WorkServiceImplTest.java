package com.xaut.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.xaut.entity.Work;
import com.xaut.util.HandleJSON;
import com.xaut.util.ResponseBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class WorkServiceImplTest {
	@Autowired
	WorkServiceImpl workService;
	
	HandleJSON handleJSON = new HandleJSON();
	
	/**
	 * 测试：根据课程号查看发布作业次数
	 */
	@Test
	public void findWorkTimesByCnoTest() {
		System.out.println("发布作业次数：" + workService.findWorkTimesByCno("(2017-2018-2)-09191430-104496-3"));
	}
	
	/**
	 * 测试：教师发布作业
	 */
	@Test
	public void publishWorkTest() {
		Work work = new Work();
		String courseCno = "(2017-2018-2)-09191430-104496-3";
		work.setWno(courseCno + "-" + (workService.findWorkTimesByCno(courseCno)+1));
		work.setCno(courseCno);	//课程号
		work.setwName("第三次作业");	//作业名
		work.setDesc("用Java来个大数据");	//作业描述
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			work.setStart_time(sdf.parse("2017-2018-2 11:11:05"));	//开始时间
			work.setEnd_time(sdf.parse("2017-2018-4 11:11:05"));	//结束时间
		} catch (ParseException e) {
			e.printStackTrace();
		}
		work.setUpdateTime(new java.sql.Date(new Date().getTime()));	//更新时间
		
		Map<String, Object> map = new HashMap<String, Object>();
		map = workService.publishWork(work);
		String jsonString = JSON.toJSONString(map); //将JSON对象	转化为	JSON字符串
		System.out.println(new HandleJSON().print_JSON(jsonString)); //将JSON字符串格式化输出
	}
	
	/**
	 * 测试：获得学生所选课程概况
	 */
	@Test
	public void getCourseSurveyTest() {
		ResponseBean result = workService.getWorkSurvey("0000123456");
		
		//格式化输出
    	HandleJSON handleJSON = new HandleJSON();
    	System.out.println(handleJSON.print_JSON(JSON.toJSONString(handleJSON.to_JSON(result))));
	}
}