package com.xaut.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class AdminMapperTest {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * (分组)查询所有的用户的数量
     */
    @Test
    public void findAllUser() {
        try {
            int res = adminMapper.findAllUser("1", "adminCount");
            Assert.assertNotNull(res);
            System.out.println("res============" +res);
        } catch (Exception e) {
            System.out.println("查询所有的用户数量异常: " +e);
        }

    }

    /**
     * 分组获取教师用户所在的学院和各学院人数
     */
    @Test
    public void groupTeacherInfo() {
        try {
            List<Map<String,  Object>> map = adminMapper.groupTeacherInfo();
            Assert.assertNotNull(map);
            System.out.println("map==========" +map);
        } catch (Exception e) {
            System.out.println("分组获取教师用户所在的学院和各学院人数异常: " +e);
        }
    }

    /**
     *  分组获取学生用户所在的专业和各专业人数
     */
    @Test
    public void groupStudentInfo() {
        try {
            List<Map<String,  Object>> map = adminMapper.groupStudentInfo();
            Assert.assertNotNull(map);
            System.out.println("map==========" +map);
        } catch (Exception e) {
            System.out.println(" 分组获取学生用户所在的专业和各专业人数异常: " +e);
        }
    }

    /**
     * 获取不同角色的账号锁定状态
     */
    @Test
    public void getAccountStatus() {
        try {
            int flag = this.adminMapper.getAccountStatus("3", "1"); // 账号锁定的学生
            System.out.println("flag==========" +flag);
        } catch (Exception e) {
            System.out.println(" 获取不同角色的账号锁定状态异常: " +e);
        }
    }
}