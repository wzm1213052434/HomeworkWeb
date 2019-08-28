package com.xaut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xaut.entity.User;
import com.xaut.mapper.UserMapper;
import com.xaut.service.UserService;
import com.xaut.util.ResponseBean;

@Service("UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	/**
     * 通过用户账号查找用户对象
     */
	public User findUserByUsername(String username) {
		return this.userMapper.findUserByUsername(username);
	}
	
	/**
     * 根据用户账号查找其角色
     */
	public List<String> findRolesByUsername(String username){
		return this.userMapper.findRolesByUsername(username);
	}
	
	/**
     * 根据用户账号查找其权限
     */
	public List<String> findPermissionsByUsername(String username){
		return this.userMapper.findPermissionsByUsername(username);
	}
	
	/**
	 * function:更新用户信息
	 * @param map
	 * @return
	 */
	public ResponseBean updateUser(User user) {
		if (user == null) {
			return new ResponseBean(false, "参数为空");
		}
    	
		User judge_user = userMapper.findUserByUsername(user.getUserName());
		if(judge_user == null) {
			return new ResponseBean(false, "无此用户");
		}
		try {
			userMapper.updateUser(user);
		} catch (Exception e) {
			return new ResponseBean(false, "更新用户信息异常");
		}
		
		return new ResponseBean(true, "更新用户信息成功");
	}
}