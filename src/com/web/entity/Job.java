package com.web.entity;

import java.io.Serializable;

/**
 * Job实体类
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Job implements Serializable{

	private int jobid;
	
	private String jobName;

	public Job() {}

	public Job(String jobName) {
		this.jobName = jobName;
	}

	public Job(int jobid, String jobName) {
		this.jobid = jobid;
		this.jobName = jobName;
	}

	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}
