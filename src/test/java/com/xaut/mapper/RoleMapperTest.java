package com.xaut.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xaut.entity.Role;

public class RoleMapperTest {
	/**
	 * 测试ID查找角色信息
	 */
	@Test
	public void findRoleByIdTest() {
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		RoleMapper roleMapper = act.getBean(RoleMapper.class);
		Role role = roleMapper.findRoleById(1);
		System.out.println(role);
	}
}
