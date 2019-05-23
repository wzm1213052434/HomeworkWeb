package com.xaut.service;

import com.xaut.entity.Permission;

public interface PermissionService {
	/**
	 * 通过id查权限
	 */
	public Permission findPermissionById(Integer id);
}
