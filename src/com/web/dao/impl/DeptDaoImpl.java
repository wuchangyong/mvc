package com.web.dao.impl;

import java.util.List;

import com.web.dao.DeptDao;
import com.web.entity.Dept;

public class DeptDaoImpl extends BaseDao<Dept> implements DeptDao{

	/**
	 * 加载所有部门
	 * @return
	 */
	public List<Dept> loadAllDept(){
		return this.sqlQuery("select * from dept");
	}
	
}
