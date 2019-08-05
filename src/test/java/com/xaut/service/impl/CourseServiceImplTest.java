package com.xaut.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import com.xaut.util.HandleJSON;
import com.xaut.util.ResponseBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class CourseServiceImplTest {

    @Autowired
    private CourseServiceImpl service;

    HandleJSON handleJSON = new HandleJSON();

    /**
     * 测试: 查找教师所开的课程信息
     */
    @Test
	public void findCourseByTeacherTnoTest() {
		ResponseBean bean = this.service.findCourseByTeacherTno("123456");
		
		String jsonString = JSON.toJSONString(bean); //将JSON对象	转化为	JSON字符串
		System.out.println(new HandleJSON().print_JSON(jsonString)); //将JSON字符串格式化输出
		System.out.println("测试查询教师课程信息通过");
	}

    /**
     * 测试: 根据课程名分页获取课程
     */
    @Test
    public void getAllCourse() {
        ResponseBean result = this.service.getAllCourse("软", 1, 3);
        
        String jsonString = JSON.toJSONString(result);
        System.out.println(new HandleJSON().print_JSON(jsonString));
        System.out.println("测试分页查询课程信息通过");
    }
}