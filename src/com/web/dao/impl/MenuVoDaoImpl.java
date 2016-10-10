package com.web.dao.impl;

import com.web.dao.MenuVoDao;
import com.web.util.Page;
import com.web.vo.MenuVo;

public class MenuVoDaoImpl extends BaseDao<MenuVo> implements MenuVoDao{

	/**
	 * 加载所有菜单
	 * @return
	 */
	public Page<MenuVo> loadAllMenus(int pageNo, int pageSize){
		String sql = "select * from v_menu";
		return this.sqlQuery(sql, pageNo, pageSize);
	}
	
}
