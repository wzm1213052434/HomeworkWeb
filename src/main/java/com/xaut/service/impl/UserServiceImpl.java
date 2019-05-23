package com.xaut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xaut.entity.User;
import com.xaut.mapper.UserMapper;
import com.xaut.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 通过用户id查找用户对象
	 */
	public User findUserById(Integer id) {
		return this.userMapper.findUserById(id);
	}
	
	/**
     * 通过用户名查找用户对象
     */
	public User findUserByUsername(String username) {
		return this.userMapper.findUserByUsername(username);
	}
	
	/**
     * 根据用户名查找其角色
     */
	public List<String> findRolesByUsername(String username){
		return this.userMapper.findRolesByUsername(username);
	}
	
	/**
     * 根据用户名查找其权限
     */
	public List<String> findPermissionsByUsername(String username){
		return this.userMapper.findPermissionsByUsername(username);
	}
}