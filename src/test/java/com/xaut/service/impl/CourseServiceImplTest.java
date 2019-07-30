package com.xaut.service.impl;


import com.xaut.util.HandleJSON;
import com.xaut.util.ResponseBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
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
    public void findCourseByTeacherTno() {
        ResponseBean result = this.service.findCourseByTeacherTno("123456");
        Assert.assertNotNull(result.getData());
        System.out.println("测试查询教师课程信息通过");
        System.out.println(handleJSON.to_JSON(result));
    }

    /**
     * 测试: 根据课程名分页获取课程
     */
    @Test
    public void getAllCourse() {
        ResponseBean result = this.service.getAllCourse("软", 1, 3);
        Assert.assertNotNull(result.getData());
        System.out.println("测试分页查询课程信息通过");
        System.out.println(handleJSON.to_JSON(result));
    }
}