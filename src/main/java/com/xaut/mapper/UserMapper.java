package com.xaut.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.xaut.entity.User;

public interface UserMapper {
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
	
	/**
	 * 根据用户账号删除User用户
	 * @param username
	 */
	public void deleteUser(String username);
	
	/**
	 * 增加用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 根据用户账号查用户ID
	 * @param username
	 */
	public String findUserIDByUsername(String username);
	
	/**
	 * 根据用户ID为用户增加一个角色
	 * @param uid
	 */
	public void addRoleForUser(@Param("user_id") String uid,@Param("role_id") String rid,@Param("updateTime") String updateTime);
	
	/**
	 * 根据用户ID删除用户的一个角色
	 * @param uid rid
	 */
	public void deteleRoleByUID(@Param("user_id") String uid,@Param("role_id") String rid);
	
	/**
     * function:动态sql更新用户表
     * @param map
     */
    void updateUser(Map<String, Object> map);
}
