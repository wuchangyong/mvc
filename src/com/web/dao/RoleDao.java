package com.web.dao;

import java.util.List;

import com.web.entity.Role;

public interface RoleDao {
	
	/**
	 * 通过角色id加载角色对象
	 * @param rid
	 * @return
	 */
	public Role loadRoleById(int rid);
	
	/**
	 * 加载所有角色
	 * @return
	 */
	public List<Role> loadAllRoles();
	
	/**
	 * 通过角色id查询角色菜单
	 * @param rid
	 * @return
	 */
	public List<Object[]> loadRoleMenuByRoleId(int rid);

}
