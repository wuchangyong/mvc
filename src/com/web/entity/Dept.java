package com.web.entity;

import java.io.Serializable;

/**
 * 部门实体类
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Dept implements Serializable{

	private int did;
	
	private String dname;

	public Dept() {}

	public Dept(String dname) {
		this.dname = dname;
	}

	public Dept(int did, String dname) {
		this.did = did;
		this.dname = dname;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
}
