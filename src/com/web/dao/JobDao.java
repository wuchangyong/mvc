package com.web.dao;

import java.util.List;

import com.web.entity.Job;

public interface JobDao {
	
	/**
	 * 加载所有职位
	 * @return
	 */
	public List<Job> loadAllJob();

}
