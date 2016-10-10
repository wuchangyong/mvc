package com.web.dao.impl;

import java.util.List;

import com.web.dao.RoleDao;
import com.web.entity.Role;

public class RoleDaoImpl extends BaseDao<Role> implements RoleDao{

	/**
	 * 通过角色id加载角色对象
	 * @param rid
	 * @return
	 */
	public Role loadRoleById(int rid){
		return this.get(rid);
	}
	
	/**
	 * 加载所有角色
	 * @return
	 */
	public List<Role> loadAllRoles(){
		String sql = "select * from role";
		List<Role> roleList = this.sqlQuery(sql);
		return roleList;
	}
	
	
	/**
	 * 通过角色id查询角色菜单
	 * @param rid
	 * @return
	 */
	public List<Object[]> loadRoleMenuByRoleId(int rid){
		String sql = "select m.mid,m.name,m.parentid,(select 1 from rolemenu rm where rm.mid=m.mid and rm.rid=?) from menu m";
		return this.sqlQueryArray(sql, rid);
	}
	
}
