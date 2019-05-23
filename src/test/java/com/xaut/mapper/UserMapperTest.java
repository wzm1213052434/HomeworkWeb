package com.xaut.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xaut.entity.User;

public class UserMapperTest {
	/**
	 * 测试通过用户id查找用户对象
	 */
	@Test
	public void findUserByIdTest() {
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		UserMapper useMapper = act.getBean(UserMapper.class);
		User user = useMapper.findUserById(1);
		System.out.println("用户为："+user);
	}
	
	/**
	 * 测试通过用户名查找用户对象
	 */
	@Test
	public void findUserByUsernameTest() {
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		UserMapper useMapper = act.getBean(UserMapper.class);
		User user = useMapper.findUserByUsername("superadmin");
		System.out.println("用户为："+user);
	}
	
	/**
	 * 测试根据用户名查找其角色
	 */
	@Test
	public void findRolesByUsernameTest() {
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		UserMapper useMapper = act.getBean(UserMapper.class);
		List<String> list = useMapper.findRolesByUsername("superadmin");
		for (String string : list) {
			System.out.println("角色为："+string);
		}
	}
	
	/**
	 * 测试根据用户名查找其权限
	 */
	@Test
	public void findPermissionsByUsernameTest() {
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		UserMapper useMapper = act.getBean(UserMapper.class);
		List<String> list = useMapper.findPermissionsByUsername("123456");
		for (String string : list) {
			System.out.println("权限为："+string);
		}
	}
}
