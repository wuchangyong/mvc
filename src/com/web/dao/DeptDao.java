package com.web.dao;

import java.util.List;

import com.web.entity.Dept;

public interface DeptDao {
	
	/**
	 * 加载所有部门
	 * @return
	 */
	public List<Dept> loadAllDept();

}
