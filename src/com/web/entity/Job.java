package com.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Job实体类
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="job")
public class Job implements Serializable{

	@Id
	@Column(name="jobid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jobid;
	
	@Column(name="jobName",length=20,nullable=false,unique=true)
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
