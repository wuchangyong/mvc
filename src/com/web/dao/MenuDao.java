package com.web.dao;

import java.util.List;

import com.web.entity.Menu;
import com.web.util.Page;
import com.web.vo.MenuVo;

public interface MenuDao {
	/**
	 * 通过帐号主键Id加载此用户拥有的菜单集合
	 * @param uid
	 * @return
	 */
	public List<Menu> loadMenusByUid(int uid);
	
	/**
	 * 加载所有菜单
	 * @return
	 */
	public Page<MenuVo> loadAllMenus(int pageNo, int pageSize);
	
	/**
	 * 加载所有一级和二级菜单
	 * @return
	 */
	public List<Menu> load12Menus();
	
	/**
	 * 通过主键id加载一个菜单对象
	 * @param mid
	 * @return
	 */
	public Menu loadMenuById(int mid);
	
	/**
	 * 添加菜单
	 * @param name 菜单名称
	 * @param url  菜单地址
	 * @param isshow 是否在欢迎界面展示
	 * @param level 当前添加的菜单的级别
	 * @param parentid 父级菜单ID
	 */
	public void addMenu(Menu menu);
}
