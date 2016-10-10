package com.web.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Employee implements Serializable{
	private int eid;
	
	//员工姓名
	private String ename;
	
	//职位名称
	private int jobid;
	
	//直属领导人
	private int managerid;
	
	//入职时间
	private Date hireDate;
	
	//工资
	private int salary;
	
	//津贴
	private int comm;
	
	//所属部门
	private int deptid;

	public Employee() {}

	public Employee(String ename, int jobid, int managerid, Date hireDate,
			int salary, int comm, int deptid) {
		this.ename = ename;
		this.jobid = jobid;
		this.managerid = managerid;
		this.hireDate = hireDate;
		this.salary = salary;
		this.comm = comm;
		this.deptid = deptid;
	}

	public Employee(int eid, String ename, int jobid, int managerid,
			Date hireDate, int salary, int comm, int deptid) {
		this.eid = eid;
		this.ename = ename;
		this.jobid = jobid;
		this.managerid = managerid;
		this.hireDate = hireDate;
		this.salary = salary;
		this.comm = comm;
		this.deptid = deptid;
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

	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
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

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

}

