package com.xaut.mapper;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xaut.entity.User;

/*
 * 单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class UserMapperTest {
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 测试：通过用户账号查找用户对象
	 */
	@Test
	public void findUserByUsernameTest() {
		User user = userMapper.findUserByUsername("superadmin");
		System.out.println("用户为："+user);
	}
	
	/**
	 * 测试：根据用户账号查找其角色
	 */
	@Test
	public void findRolesByUsernameTest() {
		List<String> list = userMapper.findRolesByUsername("superadmin");
		for (String string : list) {
			System.out.println("角色为："+string);
		}
	}
	
	/**
	 * 测试：根据用户账号查找其权限
	 */
	@Test
	public void findPermissionsByUsernameTest() {
		List<String> list = userMapper.findPermissionsByUsername("123456");
		for (String string : list) {
			System.out.println("权限为："+string);
		}
	}
	
	/**
	 * 测试：根据用户账号删除用户
	 */
	@Test
	public void deleteUserTest() {
		userMapper.deleteUser("111111");
		System.out.println("删除用户成功");
	}
	
	/**
	 * 测试：新增用户
	 */
	@Test
	public void addUserTest() {
		User user = new User();
		user.setUserName("111111");
		user.setPassWord("f140c7490b8b0420831f96dc2a597c25");
		user.setFlag("4");
		user.setSalt("123456");
		user.setLocked("0");
		user.setUpdateTime(new java.sql.Date(new Date().getTime()));

		userMapper.addUser(user);
		System.out.println("新增用户成功");
	}
	
	/**
	 * 测试：根据用户账号查用户ID
	 */
	@Test
	public void findUserIDByUsernameTest() {
		System.out.println("用户ID为：" + userMapper.findUserIDByUsername("104496"));
	}
	
	/**
	 * 根据用户ID为用户增加一个角色 
	 */
	@Test
	public void addRoleForUserTest() {
		userMapper.addRoleForUser("7","4",new java.sql.Date(new Date().getTime()).toString());
		System.out.println("用户增加角色成功");
	}
	
	/**
	 * 根据用户ID删除用户的一个角色
	 */
	@Test
	public void deteleRoleByUIDTest() {
		userMapper.deteleRoleByUID("7","4");
		System.out.println("删除用户角色成功");
	}
}