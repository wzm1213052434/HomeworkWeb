package com.xaut.service;

import java.util.List;
import java.util.Map;

import com.xaut.entity.User;
import com.xaut.util.ResponseBean;

public interface UserService {
	/**
     * 通过用户账号查找用户对象
     */
	User findUserByUsername(String username);
	
	/**
     * 根据用户账号查找其角色
     */
	List<String> findRolesByUsername(String username);
	
	/**
     * 根据用户账号查找其权限
     */
	List<String> findPermissionsByUsername(String username);
	
	/**
	 * function:更新用户信息
	 * @param map
	 * @return
	 */
	ResponseBean changeUserMessage(Map<String,Object> map);
}