package com.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity//当前类是一个实体类
@Table(name="employee")//当前实体类对应哪一张表名称
public class Employee implements Serializable{
	
	@Id//表示当前属性是主键
	@Column(name="eid",unique=true,nullable=false)//指定当前属性对应表中的哪一列
	@GeneratedValue(strategy=GenerationType.IDENTITY)//指定主键生成策略
	private int eid;
	
	//员工姓名
	@Column(name="ename",length=20,nullable=false)
	private String ename;
	
	//职位名称
	@Column(name="jobid")
	private int jobid;
	
	//直属领导人
	@Column(name="managerid")
	private int managerid;
	
	//入职时间
	@Column(name="hireDate")
	private Date hireDate;
	
	//工资
	@Column(name="salary")
	private int salary;
	
	//津贴
	@Column(name="comm")
	private int comm;
	
	//所属部门
	@Column(name="deptid")
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

