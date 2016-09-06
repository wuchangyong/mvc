package com.web.vo;

import java.io.Serializable;
import java.util.Date;

public class EmployeeVo implements Serializable{
	private int eid;
	
	//员工姓名
	private String ename;
	
	//职位名称
	private String jobName;
	
	//直属领导人
	private String managerName;
	
	//入职时间
	private String hireDate;
	
	//工资
	private int salary;
	
	//津贴
	private int comm;
	
	//所属部门
	private String deptName;

	public EmployeeVo() {}

	public EmployeeVo(int eid, String ename, String jobName,
			String managerName, String hireDate, int salary, int comm,
			String deptName) {
		this.eid = eid;
		this.ename = ename;
		this.jobName = jobName;
		this.managerName = managerName;
		this.hireDate = hireDate;
		this.salary = salary;
		this.comm = comm;
		this.deptName = deptName;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}

