package com.web.dao;

import com.web.util.Page;
import com.web.vo.MenuVo;

public interface MenuVoDao {

	/**
	 * 加载所有菜单
	 * @return
	 */
	public Page<MenuVo> loadAllMenus(int pageNo, int pageSize);
	
}
