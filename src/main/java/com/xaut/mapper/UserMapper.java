package com.xaut.mapper;

import java.util.List;
import com.xaut.entity.User;

public interface UserMapper {
	/**
	 * 通过用户id查找用户对象
	 */
	public User findUserById(Integer id);
	
	/**
     * 通过用户名查找用户对象
     */
	public User findUserByUsername(String username);
	
	/**
     * 根据用户名查找其角色
     */
	public List<String> findRolesByUsername(String username);
	
	/**
     * 根据用户名查找其权限
     */
	public List<String> findPermissionsByUsername(String username);
}
