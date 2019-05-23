package com.xaut.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xaut.entity.Permission;

public class PermissionMapperTest {
	/**
	 * 测试ID查找权限信息
	 */
	@Test
	public void findRoleByIdTest() {
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		PermissionMapper permissionMapper = act.getBean(PermissionMapper.class);
		Permission permission = permissionMapper.findPermissionById(1);
		System.out.println(permission);
	}
}
