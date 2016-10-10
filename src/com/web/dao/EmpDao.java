package com.web.dao;

import com.web.util.Page;
import com.web.vo.EmployeeVo;

public interface EmpDao {
	
	/**
	 * 分页查询员工列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<EmployeeVo> loadEmployeeByPage(int pageNo, int pageSize, String searchName,String searchJob,String searchDept);

}
