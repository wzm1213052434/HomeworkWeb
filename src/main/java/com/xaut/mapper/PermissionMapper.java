package com.xaut.mapper;

import com.xaut.entity.Permission;

public interface PermissionMapper {
	/**
	 * 通过id查权限
	 */
	public Permission findPermissionById(Integer id);
}
