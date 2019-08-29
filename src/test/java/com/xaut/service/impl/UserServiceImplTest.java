package com.xaut.service.impl;

import java.util.Date;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import com.xaut.entity.User;
import com.xaut.util.HandleJSON;
import com.xaut.util.ResponseBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class UserServiceImplTest {
	@Autowired
	private UserServiceImpl userService;
	
	HandleJSON handleJSON = new HandleJSON();
	
	/**
	 * test:动态sql更新用户表
	 */
	@Test
	public void updateUserTest() {
		User user = new User();
    	user.setUserName("0000123456");
    	user.setPassWord(new Md5Hash("123456","0000123456").toString());
    	user.setUpdateTime(new java.sql.Date(new Date().getTime()));
    	
		ResponseBean result = userService.updateUser(user);
    	HandleJSON handleJSON = new HandleJSON();
    	System.out.println(handleJSON.print_JSON(JSON.toJSONString(handleJSON.to_JSON(result))));
	}
}