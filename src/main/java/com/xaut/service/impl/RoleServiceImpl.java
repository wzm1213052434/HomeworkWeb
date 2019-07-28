package com.xaut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xaut.entity.Role;
import com.xaut.mapper.RoleMapper;
import com.xaut.service.RoleService;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	
	/**
	 * 通过id查角色
	 */
	public Role findRoleById(Integer id) {
		return this.roleMapper.findRoleById(id);
	}
}
