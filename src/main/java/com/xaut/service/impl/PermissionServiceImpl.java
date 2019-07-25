package com.xaut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xaut.entity.Permission;
import com.xaut.mapper.PermissionMapper;
import com.xaut.service.PermissionService;

@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;
	
	/**
	 * 通过id查权限
	 */
	public Permission findPermissionById(Integer id) {
		return this.permissionMapper.findPermissionById(id);
	}
}
