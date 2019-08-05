package com.xaut.service;

import java.util.List;
import com.xaut.entity.User;

public interface UserService {
	/**
     * 通过用户账号查找用户对象
     */
	public User findUserByUsername(String username);
	
	/**
     * 根据用户账号查找其角色
     */
	public List<String> findRolesByUsername(String username);
	
	/**
     * 根据用户账号查找其权限
     */
	public List<String> findPermissionsByUsername(String username);
}