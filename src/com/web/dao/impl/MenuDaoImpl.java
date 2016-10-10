package com.web.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.web.dao.MenuDao;
import com.web.entity.Menu;
import com.web.util.Page;
import com.web.vo.MenuVo;

public class MenuDaoImpl extends BaseDao<Menu> implements MenuDao{

	/**
	 * 通过帐号主键Id加载此用户拥有的菜单集合
	 * @param uid
	 * @return
	 */
	public List<Menu> loadMenusByUid(int uid){
		String sql = "select m.* from userrole ur,rolemenu rm,menu m where ur.rid=rm.rid and rm.mid=m.mid and m.isshow=1 and ur.uid=?";
		List<Menu> menuList = this.sqlQuery(sql, uid);
		return menuList;
	}
	
	/**
	 * 加载所有菜单
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Page<MenuVo> loadAllMenus(int pageNo, int pageSize){
		String sql1 = "select count(*) from v_menu";
		//String sql1 = "select count(*) from menu";
		String sql2 = "select * from v_menu";
		//String sql2 = "select m.mid,m.name,m.url,m.isshow,m.level,(select m2.name from menu m2 where m2.mid=m.parentid) parentName from menu m;";
		Session session = this.openSession();
		List<BigInteger> count = session.createSQLQuery(sql1).list();
		long total = count.get(0).longValue();
		
		
		List<MenuVo> menuList = session.createSQLQuery(sql2).addEntity(MenuVo.class).setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
//		List<MenuVo> menuList = new ArrayList<MenuVo>();
//		List<Object[]> list = session.createSQLQuery(sql2).setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
//		MenuVo m = null;
//		if(null != list && list.size() > 0){
//			for(Object[] os : list){
//				m = new MenuVo((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3], (Integer)os[4], (String)os[5]);
//				menuList.add(m);
//			}
//		}
		session.close();
		return new Page<MenuVo>(pageNo, pageSize, menuList, total);
	}
	
	/**
	 * 加载所有一级和二级菜单
	 * @return
	 */
	public List<Menu> load12Menus(){
		String sql = "select m.* from menu m where m.level in(1,2)";
		List<Menu> menuList = this.sqlQuery(sql);
		return menuList;
	}
	
	/**
	 * 通过主键id加载一个菜单对象
	 * @param mid
	 * @return
	 */
	public Menu loadMenuById(int mid){
		return this.get(mid);
	}
	
	/**
	 * 添加菜单
	 * @param name 菜单名称
	 * @param url  菜单地址
	 * @param isshow 是否在欢迎界面展示
	 * @param level 当前添加的菜单的级别
	 * @param parentid 父级菜单ID
	 */
	public void addMenu(Menu menu){
		this.save(menu);
	}
	
}
