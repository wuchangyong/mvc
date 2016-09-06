package com.web.entity;

import java.io.Serializable;

/**
 * 部门实体类
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Dept implements Serializable{

	private int deptid;
	
	private String deptName;
	
	private String location;

	public Dept() {}

	public Dept(int deptid, String deptName, String location) {
		this.deptid = deptid;
		this.deptName = deptName;
		this.location = location;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
