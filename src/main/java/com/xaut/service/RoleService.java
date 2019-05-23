package com.xaut.service;

import com.xaut.entity.Role;

public interface RoleService {
	/**
	 * 通过id查角色
	 */
	public Role findRoleById(Integer id);
}
