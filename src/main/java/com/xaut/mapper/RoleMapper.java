package com.xaut.mapper;

import com.xaut.entity.Role;

public interface RoleMapper {
	/**
	 * 通过id查角色
	 */
	public Role findRoleById(Integer id);
}
