package com.xaut.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xaut.entity.Role;

/*
 * 单元测试
 */
public class RoleMapperTest {
	
	ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	RoleMapper roleMapper = act.getBean(RoleMapper.class);
	
	/**
	 * 测试：ID查找角色信息
	 */
	@Test
	public void findRoleByIdTest() {
		Role role = roleMapper.findRoleById(1);
		System.out.println(role);
	}
}