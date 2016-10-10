package com.web.dao.impl;

import java.util.List;

import com.web.dao.JobDao;
import com.web.entity.Job;

public class JobDaoImpl extends BaseDao<Job> implements JobDao{

	/**
	 * 加载所有职位
	 * @return
	 */
	public List<Job> loadAllJob(){
		return this.sqlQuery("select * from job");
	}
	
}
