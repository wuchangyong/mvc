package com.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.web.dao.RoleMenuDao;
import com.web.entity.RoleMenu;

public class RoleMenuDaoImpl extends BaseDao<RoleMenu> implements RoleMenuDao{

	/**
	 * 编辑角色权限
	 * @param rid
	 * @param mids
	 */
	public void editRoleMenu(int rid, String[] mids){
		Session session = this.openSession();
		Transaction tx = session.beginTransaction();
		tx.begin();
		/*
		 * 先删除原来已有的菜单关联
		 */
		String sql = "delete from rolemenu where rid=?";
		session.createSQLQuery(sql).executeUpdate();
		
		/*
		 * 再重新添加
		 */
		if(null != mids && mids.length > 0){
			RoleMenu rm = null;
			for(String mid : mids){
				rm = new RoleMenu(rid, Integer.valueOf(mid));
				session.save(rm);
			}
		}
		tx.commit();
		session.close();
	}
	
	/**
	 * 检查uid这个用户是否拥有uri这个菜单权限
	 * @param uid
	 * @param uri
	 * @return 返回true表示有权限 返回false表示无权限
	 */
	@SuppressWarnings("unchecked")
	public boolean checkUserMenu(int uid, String uri){
		String sql = "select 1 from userrole ur,rolemenu rm,menu m where ur.rid=rm.rid and rm.mid=m.mid and ur.uid=? and m.url like '%" + uri + "%'";
		Session session = this.openSession();
		List<Object[]> list = session.createSQLQuery(sql).setInteger(0, uid).list();
		if(null != list && list.size() > 0){
			return true;
		}
		session.close();
		return false;
	}
	
}
