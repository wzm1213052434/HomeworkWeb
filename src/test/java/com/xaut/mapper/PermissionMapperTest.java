package com.xaut.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xaut.entity.Permission;

/*
 * 单元测试
 */
public class PermissionMapperTest {
	
	ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	PermissionMapper permissionMapper = act.getBean(PermissionMapper.class);
	
	/**
	 * 测试：ID查找权限信息
	 */
	@Test
	public void findRoleByIdTest() {		
		Permission permission = permissionMapper.findPermissionById(1);
		System.out.println(permission);
	}
}